package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    private Map<String, BaseSchema> schemas = new HashMap<>();
    public final MapSchema required() {
        Predicate<?> requiredPredicate = o -> o instanceof Map;
        super.addPredicate(requiredPredicate);
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map<?, ?>> sizeofPredicate = map -> map.size() == size;
        super.addPredicate(sizeofPredicate);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Map<?, ?>> shapePredicate = checkedData -> {
            for (Map.Entry<String, BaseSchema> currentObjectOfSchemas : schemas.entrySet()) {
                String currentKeySchema = currentObjectOfSchemas.getKey();
                if (checkedData.containsKey(currentKeySchema)) {
                    boolean result = currentObjectOfSchemas.getValue().isValid(checkedData.get(currentKeySchema));
                    if (!result) {
                        return false;
                    }
                }
            }
            return true;
        };
        super.addPredicate(shapePredicate);
        return this;
    }
}
