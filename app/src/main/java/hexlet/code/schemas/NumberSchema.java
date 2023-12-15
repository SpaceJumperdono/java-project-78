package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {


    public NumberSchema() {
        putPredicate("required", o -> o instanceof Integer);
    }
    public final NumberSchema required() {
        changeRequired();
        return this;
    }

    public final NumberSchema positive() {
        putPredicate("positive", i -> (Integer) i > 0);
        return this;
    }

    public final NumberSchema range(int number1, int number2) {
        putPredicate("range", i -> (Integer) i >= number1 && (Integer) i <= number2);
        return this;
    }
}
