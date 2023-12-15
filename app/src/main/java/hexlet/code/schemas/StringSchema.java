package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    public StringSchema() {
        putPredicate("required", o -> o instanceof String && !o.equals(""));
    }

    public final StringSchema required() {
        changeRequired();
        return this;
    }

    public final StringSchema minLength(int minLength) {
        putPredicate("minLength", s -> ((String) s).length() >= minLength);
        return this;
    }

    public final StringSchema contains(String substring) {
        putPredicate("contains", s -> ((String) s).contains(substring));
        return this;
    }

}
