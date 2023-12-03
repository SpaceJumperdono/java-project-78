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
    public final void putPredicate(String name, Predicate newPredicate) {
        predicates.put(name, newPredicate);
    }

    public final boolean isValid(Object object) {
        boolean requiredPredicate = predicates.get("required").test(object);
        if (!checkRequired && !requiredPredicate) {
            return true;
        }
        for (Map.Entry<String, Predicate<Object>> elementOfPredicates : predicates.entrySet()) {
            if (!elementOfPredicates.getValue().test(object)) {
                return false;
            }
        }
        return true;
    }
}

// s.positive().isValid(null);
