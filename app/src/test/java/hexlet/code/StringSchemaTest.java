package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    public static final int FIVE_LENGTH = 5;
    public static final int FOUR_LENGTH = 4;
    @Test
    public void isValidTest1() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        boolean result = schema.isValid(null);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void isValidTest2() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        boolean result = schema.required().isValid(null);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void isValidTest3() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        boolean result = schema.required().minLength(FIVE_LENGTH).isValid("Hello");
        assertTrue(result);
    }

    @Test
    public void isValidTest4() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        boolean result = schema.required().minLength(FOUR_LENGTH).isValid("Hel");
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void isValidTest5() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        boolean result = schema.required().minLength(FIVE_LENGTH).contains("what").isValid("what does the fox say");
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void isValidTest6() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        boolean result = schema.required().minLength(FIVE_LENGTH).contains("whatthe").isValid("what does the fox say");
        assertThat(result).isEqualTo(false);
    }
}
