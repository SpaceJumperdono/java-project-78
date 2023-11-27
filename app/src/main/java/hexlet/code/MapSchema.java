package hexlet.code;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
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
}
