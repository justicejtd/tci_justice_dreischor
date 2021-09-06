import java.util.ArrayList;
import java.util.List;

public class StringManager {

    /**
     * @should throw IllegalArgumentsException if input length is less than 2
     * @should throw IllegalArgumentsException if input is a blank string
     * @should not be the same as the input value
     * @should be the same length as input value
     */
    public static String reverse(String s) throws IllegalArgumentException{
        if (s.length() < 2) {
            throw new IllegalArgumentException("Input length should be at least 2");
        }
        if (s.isBlank()){
            throw new IllegalArgumentException("Input length should be at least 2");
        }
        List<String> tempArray = new ArrayList<String>(s.length());
        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i + 1));
        }
        StringBuilder reversedString = new StringBuilder(s.length());
        for (int i = tempArray.size() - 1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }
        return reversedString.toString();
    }
}
