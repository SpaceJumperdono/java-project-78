package hexlet.code;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        StringSchema schema = v.string();
        schema.required();
        System.out.println(schema.contains("what").isValid("what does the fox say"));
        System.out.println(schema.contains("whatthe").isValid("what does the fox say"));
        System.out.println(schema.isValid("what does the fox say"));
    }

    public static boolean testFunction() {
        return true;
    }
}
