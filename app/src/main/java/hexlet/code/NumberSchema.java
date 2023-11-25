package hexlet.code;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema{

    public final NumberSchema required() {
        Predicate<?> requiredPredicate = o -> o instanceof Integer;
        super.addPredicate(requiredPredicate);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Integer> positivePredicate = i -> i > 0;
        super.addPredicate(positivePredicate);
        return this;
    }

    public final NumberSchema range(int number1, int number2) {
        Predicate<Integer> rangePredicate = i -> i >= number1 && i <= number2;
        super.addPredicate(rangePredicate);
        return this;
    }
}
