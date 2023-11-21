package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {
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
        int minLength = 5;
        boolean result = schema.required().minLength(minLength).isValid("Hello");
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void isValidTest4() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        int minLength = 4;
        boolean result = schema.required().minLength(minLength).isValid("Hel");
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void isValidTest5() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        int minLength = 5;
        boolean result = schema.required().minLength(minLength).contains("what").isValid("what does the fox say");
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void isValidTest6() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();
        int minLength = 5;
        boolean result = schema.required().minLength(minLength).contains("whatthe").isValid("what does the fox say");
        assertThat(result).isEqualTo(false);
    }
}
