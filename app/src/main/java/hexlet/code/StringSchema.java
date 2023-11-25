package hexlet.code;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<?> requiredPredicate = o -> o instanceof String && !o.equals("");
        super.addPredicate(requiredPredicate);
        return this;
    }

    public final StringSchema minLength(int minLength) {
        Predicate<String> minLengthPredicate = s -> {
            try {
                return s.length() >= minLength;
            } catch (Exception e) {
                return true;
            }
        };
        super.addPredicate(minLengthPredicate);
        return this;
    }

    public final StringSchema contains(String substring) {
        Predicate<String> containsPredicate = s -> {
            try {
                return s.contains(substring);
            } catch (Exception e) {
                return true;
            }
        };
        super.addPredicate(containsPredicate);
        return this;
    }

}
