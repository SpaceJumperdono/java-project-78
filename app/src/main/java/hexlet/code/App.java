package hexlet.code;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        NumberSchema schema = v.number();
        schema.required();
        schema.positive();
        schema.range(6, 7);

        System.out.println(schema.isValid(5));
    }

    public static boolean testFunction() {
        return true;
    }
}
