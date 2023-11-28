package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> predicates = new ArrayList<>();

    public final <T> Predicate<T> wrapWithCatch(Predicate<T> original) {
        Predicate<T> wrapPredicate = it -> {
            try {
                return original.test(it);
            } catch (Exception e) {
                return true;
            }
        };
        return wrapPredicate;
    }
    public final void addPredicate(Predicate newPredicate) {
        predicates.add(newPredicate);
    }

    public final <T> boolean isValid(T t) {
        for (Predicate predicate : predicates) {
            if (!wrapWithCatch(predicate).test(t)) {
                return false;
            }
        }
        return true;
    }
}
