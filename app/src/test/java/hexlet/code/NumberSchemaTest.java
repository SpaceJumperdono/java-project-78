package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberSchemaTest {
    public static final int MINUS_TEN = -10;
    public static final int TEN = 10;
    @Test
    public void numberSchemaTest1() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        boolean result = schema.isValid(null);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void numberSchemaTest2() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        boolean result = schema.positive().isValid(null);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void numberSchemaTest3() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        boolean result = schema.positive().range(MINUS_TEN, TEN).isValid(TEN);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void numberSchemaTest4() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        schema.required();
        boolean result = schema.isValid(null);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void numberSchemaTest5() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        schema.required();
        schema.positive();
        boolean result = schema.isValid(MINUS_TEN);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void numberSchemaTest6() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        schema.required();
        schema.positive();
        boolean result = schema.isValid(TEN);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void numberSchemaTest7() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();
        schema.required();
        schema.positive();
        boolean result = schema.isValid("10");
        assertThat(result).isEqualTo(false);
    }
}
