package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private boolean checkRequired = false;
    private Map<String, Predicate<Object>> predicates = new LinkedHashMap<>();

    public final void changeRequired() {
        checkRequired = true;
    }
    public final <T> void putPredicate(String name, Predicate<T> newPredicate) {
        predicates.put(name, (Predicate<Object>) newPredicate);
    }

    public final boolean isValid(Object object) {
        if (!checkRequired && !predicates.get("required").test(object)) {
            return true;
        }
        return predicates.values().stream()
                .allMatch(valueOfElement -> valueOfElement.test(object));
    }
}
