package tci.demo.week1.school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A Course is an IMMUTABLE object with a given name, code and ec.
 * It's uniquely identified by it's course code (a string).
 * the name of the course (a string) should not be null
 * code should be 3 or 4 characters long and is in upper case
 * the number of EC's (ec) is a positive whole number.
 * If above parametes are wrong, an IllegalArgumentException should be thrown during construction.
 */
class CourseTest {
    private final String name = "John";
    private final String code = "TCI";
    private final int ec = 12;

    @Test
    void constructorParametersShouldBeProperlyInitialized() {
        // arrange
        Course course = new Course(name, code, ec);
        // assert
        assertThat(course.getName()).isEqualTo(name);
        assertThat(course.getCode()).isEqualTo(code);
        assertThat(course.getEc()).isEqualTo(ec);
    }

    @Test
    void courseWithTheSameCodeShouldBeLogicallyEqual() {
        // arrange
        Course courseA = new Course(name, code, ec);
        Course courseB = new Course(name, code, ec);
        // assert
        assertThat(courseA).isEqualTo(courseB);
        assertThat(courseA).hasSameHashCodeAs(courseB);
    }

    @Test
    void nullCodeShouldThrowIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(name, null, 2);
        });
    }

    @Test
    void nullNameShouldThrowIllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(null, "", 2);
        });
    }

    @ParameterizedTest
    @CsvSource({"DD", "DDDD", "ddd", "Dddd", "2334", "3"})
    void wrongSizeOfCourseCodeShouldThrowIllegalArgumentsException(String code) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(name, code, ec);
        });
    }

    @Test
    void negativeEcShouldThrowIllegalArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           new Course(name, code, -1);
        });
    }
}