import org.assertj.core.api.ThrowableAssert;

public class Validator {

    public void validatePassword(String password) throws IllegalArgumentException{
        if (!(password.contains("_#") && password.length() >= 3)) {
            throw new IllegalArgumentException("Please enter a valid password!");
        }
    }


}
