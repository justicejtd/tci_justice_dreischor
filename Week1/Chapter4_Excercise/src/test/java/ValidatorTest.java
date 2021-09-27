import org.junit.jupiter.api.Test;
import raceResultsService.models.Validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ValidatorTest {
    @Test
    public void invalidPasswordShouldThrowIllegalArgumentsException() {
        // Arrange
        Validator validator = new Validator();
        // Act
        // Assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                validator.validatePassword("Testtest"));
    }
}
