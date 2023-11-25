package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {
    private List<Predicate> predicates = new ArrayList<>();

//    public final BaseSchema required() {
//        Predicate<?> requiredPredicate = (__) -> true;
//        addPredicate(requiredPredicate);
//        return this;
//    }
    public void addPredicate(Predicate newPredicate) {
        predicates.add(newPredicate);
    }

    public <T> boolean isValid(T t) {
        for (Predicate predicate : predicates) {
            if (!predicate.test(t)) {
                return false;
            }
        }
        return true;
    }
}
