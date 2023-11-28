package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<?> requiredPredicate = o -> o instanceof String && !o.equals("");
        super.addPredicate(requiredPredicate);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        Predicate<String> minLengthPredicate = s -> s.length() >= minLength;
        super.addPredicate(minLengthPredicate);
        return this;
    }

    public final StringSchema contains(String substring) {
        Predicate<String> containsPredicate = s -> s.contains(substring);
        super.addPredicate(containsPredicate);
        return this;
    }

}
