import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringManagerTest {
    private final StringManager stringManager = new StringManager();
    private final String mockValue = "testValue";

    @Test
    void reverse() {

    }

    /**
     * @verifies throw IllegalArgumentsException if input length is less than 2
     * @see StringManager#reverse(String)
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "1"})
    public void reverse_shouldThrowIllegalArgumentsExceptionIfInputLengthIsLessThan2(String input) throws IllegalArgumentException {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringManager.reverse(input);
        });
    }

    /**
     * @verifies not be the same as the input value
     * @see StringManager#reverse(String)
     */
    @Test
    public void reverse_shouldNotBeTheSameAsTheInputValue() {
        // arrange
        String reversedValue;

        // act
        reversedValue = StringManager.reverse(mockValue);

        // assert
        assertThat(mockValue).isNotEqualTo(reversedValue);
        System.out.println(reversedValue);
    }

    /**
     * @verifies throw IllegalArgumentsException if input is a blank string
     * @see StringManager#reverse(String)
     */
    @ParameterizedTest
    @ValueSource(strings = {"", "   ",})
    public void reverse_shouldThrowIllegalArgumentsExceptionIfInputIsABlankString(String input) throws IllegalArgumentException {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            StringManager.reverse(input);
        });
    }

    /**
     * @verifies be the same length as input value
     * @see StringManager#reverse(String)
     */
    @Test
    public void reverse_shouldBeTheSameLengthAsInputValue() throws Exception {
        // arrange
        String reversedValue;

        // act
        reversedValue = StringManager.reverse(mockValue);

        // assert
        assertThat(mockValue.length()).isEqualTo(reversedValue.length());
        System.out.println(mockValue.length() + " " + reversedValue.length());
    }
}