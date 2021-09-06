import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FahrToCelsConverterTest {

    @ParameterizedTest
    @CsvSource({"0, 32", "37, 98", "100, 212"})
    void toFahrenheit(int celsius, int expectedValue) {
        assertThat(FahrToCelsConverter.toFahrenheit(celsius)).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({"32, 0", "100, 37", "212, 100"})
    void toCelsius(int fahrenheit, int expectedValue) {
        assertThat(FahrToCelsConverter.toCelsius(fahrenheit)).isEqualTo(expectedValue);
    }
}