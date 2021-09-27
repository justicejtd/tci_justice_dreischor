package tci.demo.week2.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CourseTest {
    private static String VALID_NAME = "Testing and Continuous Integration";
    private static String VALID_CODE = "TCI";
    private static int VALID_EC = 3;

    /**
     * @verifies create course with valid parameters
     * @see Course#Course(String, String, int)
     */
    @Test
    public void Course_should_create_course_with_valid_parameters() throws Exception {
        // arrange

        // act
        Course sut = new Course(VALID_NAME, VALID_CODE, VALID_EC);

        // assert
        assertThat(sut.getName()).isEqualTo(VALID_NAME);
        assertThat(sut.getCode()).isEqualTo(VALID_CODE);
        assertThat(sut.getEc()).isEqualTo(VALID_EC);
    }

    /**
     * @verifies show that logically similar courses are equal
     * @see Course#Course(String, String, int)
     */
    @Test
    public void Course_should_show_that_logically_similar_courses_are_equal() throws Exception {
        // Arrange

        // Act
        Course A = new Course(VALID_NAME,VALID_CODE,VALID_EC);
        Course B = new Course(VALID_NAME,VALID_CODE,VALID_EC);

        // Assert
        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);
    }

    /**
     * @verifies show that logically not-similar courses are not equal
     * @see Course#Course(String, String, int)
     */
    @Test
    public void Course_should_show_that_logically_notsimilar_courses_are_not_equal() throws Exception {
        // Arrange

        // Act
        Course A = new Course(VALID_NAME,VALID_CODE,VALID_EC);
        Course B = new Course(VALID_NAME,"SOT",VALID_EC);

        // Assert
        assertThat(A).isNotEqualTo(B);

    }

    /**
     * @verifies throw illegalargument exception if any of the input parameters is null
     * @see Course#Course(String, String, int)
     */
    @ParameterizedTest
    @MethodSource("wrongInputProvider")
    public void Course_should_throw_illegalargument_exception_if_any_of_the_input_parameters_is_null(String name, String code, int ec) throws Exception {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(name,code,ec);
        });
    }

    private static Stream<Arguments> wrongInputProvider(){
        return Stream.of(
                Arguments.of(null,VALID_CODE,VALID_EC),
                Arguments.of(VALID_NAME,null,VALID_EC),
                Arguments.of(VALID_NAME,VALID_CODE,0)
        );
    }

    /**
     * @verifies throw illegalargument exception if code has invalid format
     * @see Course#Course(String, String, int)
     */
    @ParameterizedTest
    @MethodSource("generateCodeWithInvalidSize")
    public void Course_should_throw_illegalargument_exception_if_code_has_invalid_format(String code) {
        // arrange, // act, // assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Course(VALID_NAME, code, VALID_EC);
        });

    }

    private static Stream<String> generateCodeWithInvalidSize() {
        return Stream.of("", "A", "AB", "ab", "abcd", "ABCd", "abc", "aBC", "ABCDE", "abcde");
    }
}
