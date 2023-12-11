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
        this.<Integer>putPredicate("positive", i -> i > 0);
        return this;
    }

    public final NumberSchema range(int number1, int number2) {
        this.<Integer>putPredicate("range", i -> i >= number1 && i <= number2);
        return this;
    }
}
