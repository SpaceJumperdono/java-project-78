package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {
    public static final int SIZE_TWO = 2;
    public static final int HUNDRED = 100;
    public static final int MINUS_FIVE = -5;

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

    @Test
    public void mapSchemaTest6() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema> schemas = Map.of("name", validator.string().required(),
                "age", validator.number().positive());
        schema.shape(schemas);
        Map<String, Object> map = Map.of("name", "Kolya", "age", HUNDRED);
        boolean result = schema.isValid(map);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void mapSchemaTest7() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema> schemas = Map.of("name", validator.string().required(),
                "age", validator.number().positive());
        schema.shape(schemas);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Maya");
        map.put("age", null);
        boolean result = schema.isValid(map);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void mapSchemaTest8() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema> schemas = Map.of("name", validator.string().required(),
                "age", validator.number().positive());
        schema.shape(schemas);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "");
        map.put("age", null);
        boolean result = schema.isValid(map);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void mapSchemaTest9() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();
        Map<String, BaseSchema> schemas = Map.of("name", validator.string().required(),
                "age", validator.number().positive());
        schema.shape(schemas);
        Map<String, Object> map = Map.of("name", "Valya", "age", MINUS_FIVE);
        boolean result = schema.isValid(map);
        assertThat(result).isEqualTo(false);
    }
}
