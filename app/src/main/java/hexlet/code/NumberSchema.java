package hexlet.code;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<?> requiredPredicate = o -> o instanceof Integer;
        super.addPredicate(requiredPredicate);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Integer> positivePredicate = i -> {
            try {
                return i > 0;
            } catch (Exception e) {
                return true;
            }
        };
        super.addPredicate(positivePredicate);
        return this;
    }

    public final NumberSchema range(int number1, int number2) {
        Predicate<Integer> rangePredicate = i -> {
            try {
                return i >= number1 && i <= number2;
            } catch (Exception e) {
                return true;
            }
        };
        super.addPredicate(rangePredicate);
        return this;
    }
}
