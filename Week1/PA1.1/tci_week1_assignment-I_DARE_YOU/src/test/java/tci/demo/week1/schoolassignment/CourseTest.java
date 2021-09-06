package tci.demo.week1.schoolassignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CourseTest {
    private static String VALID_NAME = "Testing and Continuous Integration";
    private static String VALID_CODE = "TCI";
    private static int VALID_EC = 3;

    @Test
    public void constructor_withValidParametersIsInitializedProperly() {
        // arrange

        // act
        Course sut = new Course(VALID_NAME, VALID_CODE, VALID_EC);

        // assert
        assertThat(sut.getName()).isEqualTo(VALID_NAME);
        assertThat(sut.getCode()).isEqualTo(VALID_CODE);
        assertThat(sut.getEc()).isEqualTo(VALID_EC); // this should fail, this is the end of the demo on Mocking
    }

    @Test
    public void course_withSameCodesAreLogicallyEqual(){
        // Arrange

        // Act
        Course A = new Course(VALID_NAME,VALID_CODE,VALID_EC);
        Course B = new Course(VALID_NAME,VALID_CODE,VALID_EC);

        // Assert
        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);

    }

    /**
     * ASSUMPTION: objects in parameter list should not be NULL
     *
     * methods below check for this
     *
     * TODO: check assumption with designer
     */
    @Test
    public void nullNameShouldThrowIllegalArgumentException() {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(null, VALID_CODE, VALID_EC);
        });

    }

    @Test
    public void nullCodeShouldThrowIllegalArgumentException() {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, null, VALID_EC);
        });

    }

    @Test
    public void negativeEcShouldThrowIllegalArgumentException() {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, VALID_CODE, -3);
        });

    }


    @ParameterizedTest
    @MethodSource("generateCodeWithInvalidSize")
    public void wrongSizeOfCodeShouldThrowIllegalArgumentException(String code) {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, code, VALID_EC);
        });

    }

    private static Stream<String> generateCodeWithInvalidSize() {
        return Stream.of("", "A", "AB", "ab", "abcd", "ABCd", "abc", "aBC", "ABCDE", "abcde");
    }


}