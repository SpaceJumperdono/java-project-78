package hexlet.code;

public class App {
    public static void main(String[] args) {
        Validator v = new Validator();

        NumberSchema schema = v.number();
    }

    public static boolean testFunction() {
        return true;
    }
}
