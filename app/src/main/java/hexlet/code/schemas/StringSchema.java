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
        this.<String>putPredicate("minLength", s -> s.length() >= minLength);
        return this;
    }

    public final StringSchema contains(String substring) {
        this.<String>putPredicate("contains", s -> s.contains(substring));
        return this;
    }

}
