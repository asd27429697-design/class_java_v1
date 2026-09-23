package nesTest;

public class UserValidator {

    private static final int SUCCESS = 0;
    private static final int LENGTH_ERROR = 1;
    private static final int FORMAT_ERROR = 2;

    public static int validateId(String id) {
        if (id.length() < 4 || id.length() > 20) {
            return LENGTH_ERROR;
        }
        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);

            if (!Character.isLetterOrDigit(ch)) {
                return FORMAT_ERROR;
            }
        }
        return SUCCESS;
    }

    public static int validatePassword(String password) {
        if (password.length() < 8 || password.length() > 20) {
            return LENGTH_ERROR;
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isLetterOrDigit(ch)) {
                return FORMAT_ERROR;
            }
        }
        return SUCCESS;
    }

}
