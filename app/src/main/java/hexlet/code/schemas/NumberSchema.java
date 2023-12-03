package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {


    public NumberSchema() {
        Predicate<?> requiredPredicate = o -> o instanceof Integer;
        super.putPredicate("required", requiredPredicate);
    }
    public final NumberSchema required() {
        super.changeRequired();
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Integer> positivePredicate = i -> i > 0;
        super.putPredicate("positive", positivePredicate);
        return this;
    }

    public final NumberSchema range(int number1, int number2) {
        Predicate<Integer> rangePredicate = i -> i >= number1 && i <= number2;
        super.putPredicate("range", rangePredicate);
        return this;
    }
}
