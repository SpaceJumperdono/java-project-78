package hexlet.code.schemas;


import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        Predicate<?> requiredPredicate = o -> o instanceof Map;
        super.putPredicate("required", requiredPredicate);
    }

    public final MapSchema required() {
        super.changeRequired();
        return this;
    }

    public final MapSchema sizeof(int size) {
        Predicate<Map<?, ?>> sizeofPredicate = map -> map.size() == size;
        super.putPredicate("sizeof", sizeofPredicate);
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
        super.putPredicate("shape", shapePredicate);
        return this;
    }
}
