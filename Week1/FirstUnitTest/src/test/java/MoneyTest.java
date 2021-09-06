import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class MoneyTest {

    @ParameterizedTest
    @CsvSource({"-23, something", "-33, blahSomething", "-34, saySomething", "-55, testTest"})
    void constructorShouldSetAmountAndCurrency(int amount, String currency) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            // Arrange
            Money money = new Money(amount, currency);

            // Act
            // Assert
            assertThat(money.getAmount()).isEqualTo(amount);
            assertThat(money.getCurrency()).isEqualTo(currency);
            assertThat("some string")
                    .isNotEmpty()
                    .hasSize(11)
                    .matches("some.*");
        });
    }

    @Test
    void testEquals() {
    }


}