package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        putPredicate("required", o -> o instanceof Map);
    }

    public final MapSchema required() {
        changeRequired();
        return this;
    }

    public final MapSchema sizeof(int size) {
        putPredicate("sizeof", map -> ((Map<?, ?>) map).size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> shapePredicate = checkedData -> schemas.entrySet().stream()
                .filter(schema -> ((Map<?, ?>) checkedData).containsKey(schema.getKey()))
                .allMatch(schema -> schema.getValue().isValid(((Map<?, ?>) checkedData).get(schema.getKey())));
        putPredicate("shape", shapePredicate);
        return this;
    }
}
