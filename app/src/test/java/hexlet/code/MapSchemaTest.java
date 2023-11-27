package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    public static final int SIZE_TWO = 2;

    @Test
    public void mapSchemaTest1() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        boolean result = schema.isValid(null);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void mapSchemaTest2() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        schema.required();
        boolean result = schema.isValid(null);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void mapSchemaTest3() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        schema.required();
        boolean result = schema.isValid(new HashMap<>());
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void mapSchemaTest4() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        schema.required().sizeof(SIZE_TWO);
        Map<String, String> map = Map.of("value1", "key1");
        boolean result = schema.isValid(map);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void mapSchemaTest5() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        schema.required().sizeof(SIZE_TWO);
        Map<String, String> map = Map.of("value1", "key1", "value2", "key2");
        boolean result = schema.isValid(map);
        assertThat(result).isEqualTo(true);
    }

}
