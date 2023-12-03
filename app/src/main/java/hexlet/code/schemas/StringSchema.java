package hexlet.code.schemas;


import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        Predicate<?> requiredPredicate = o -> o instanceof String && !o.equals("");
        super.putPredicate("required", requiredPredicate);
    }

    public final StringSchema required() {
        super.changeRequired();
        return this;
    }

    public final StringSchema minLength(int minLength) {
        Predicate<String> minLengthPredicate = s -> s.length() >= minLength;
        super.putPredicate("minLength", minLengthPredicate);
        return this;
    }

    public final StringSchema contains(String substring) {
        Predicate<String> containsPredicate = s -> s.contains(substring);
        super.putPredicate("contains", containsPredicate);
        return this;
    }

}
