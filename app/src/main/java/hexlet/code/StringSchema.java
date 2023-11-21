package hexlet.code;

public class StringSchema {
    private boolean requiredFlag = false;
    private int length = 0;
    private String substring;

    public final StringSchema required() {
        requiredFlag = true;
        return this;
    }

    public final StringSchema minLength(int minLength) {
        if (minLength <= 0) {
            throw new RuntimeException();
        }
        this.length = minLength;
        return this;
    }

    public final StringSchema contains(String contains) {
        this.substring = contains;
        return this;
    }
    public final boolean isValid(Object object) {
        boolean validation = false;
        if (requiredFlag && object instanceof String) {
            String objectString = object.toString();
            if (objectString.length() >= length && substring == null) {
                validation = true;
            } else if (objectString.length() >= length && objectString.contains(substring)) {
                validation = true;
            }
        } else if (!requiredFlag) {
            validation = true;
        }
        return validation;
    }
}
