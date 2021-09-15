package tci.demo.week1.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StudentTest {
    private final String valid_name = "Maya LastName";
    private final int valid_studentNumber = 23456;
    private Student student;
    private final int valid_semester = 7;

    /**
     * A student is identified by studentNumber and name.
     * A student gets semester number 1 when enrolled for the first time (e.g., new regular bachelor students).
     * studentnumber never changes. the name can change.
     * Students can have a mentor, which can be changed later.
     * semesters range from 1..8
     * with a unique student number, consisting of 5 digits.
     */

    @BeforeEach
    public void setup() {
        student = new Student(valid_studentNumber, valid_name);
    }

    /**
     * @verifies initialized parameters properly
     * @see Student#Student(int, String)
     */
    @Test
    public void Student_shouldInitializedParametersProperly() {
        // Arrange
        Student student = new Student(valid_studentNumber, valid_name);
        // Assert
        assertThat(student.getName()).isEqualTo(valid_name);
        assertThat(student.getStudentNumber()).isEqualTo(valid_studentNumber);
    }

    /**
     * @verifies be logically equally with other students with the same name and studentNumber
     * @see Student#Student(int, String)
     */
    @Test
    public void Student_shouldBeLogicallyEquallyWithOtherStudentsWithTheSameNameAndStudentNumber() {
        // Arrange
        Student studentA = new Student(valid_studentNumber, valid_name);
        Student studentB = new Student(valid_studentNumber, valid_name);

        // Assert
        assertThat(studentA).isEqualTo(studentB);
        assertThat(studentA).hasSameHashCodeAs(studentB);

    }

    /**
     * @verifies beInSemester1
     * @see Student#Student(int, String)
     */
    @Test
    public void Student_shouldBeInSemester1() {
        // Arrange
        Student student = new Student(valid_studentNumber, valid_name);
        // Assert
        assertThat(student.getSemester()).isEqualTo(1);
    }

    /**
     * @verifies throw exception when student number is not 5 positive digits
     * @see Student#Student(int, String)
     */
    @ParameterizedTest
    @ValueSource(ints = {123, 123456})
    public void Student_shouldThrowIllegalArgumentExceptionWhenStudentNumberIsNot5PositiveDigits(int studentNumber) throws IllegalArgumentException {
        // Assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new Student(studentNumber, valid_name));
    }

    /**
     * @verifies throw exception if semester is not in the range between 1 and 8
     * @see Student#setSemester(int)
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 9, 10})
    public void setSemester_shouldThrowIllegalArgumentExceptionIfSemesterIsNotInTheRangeOf1And8(int semester) throws IllegalArgumentException {
        // Assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new Student(valid_studentNumber, valid_name).setSemester(semester)
        );
    }

    /**
     * @verifies return the right total number of ECs
     * @see Student#getTotalECs()
     */
    @Test
    public void getTotalECs_shouldReturnTheRightTotalNumberOfECs() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies add a passed course properly
     * @see Student#addPassedCourse(Course)
     */
    @Test
    public void addPassedCourse_shouldAddAPassedCourseProperly() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies throw an exception when course already has been passed
     * @see Student#addPassedCourse(Course)
     */
    @Test
    public void addPassedCourse_shouldThrowAnExceptionWhenCourseAlreadyHasBeenPassed() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies throw not found exception when course is not found
     * @see Student#removePassedCourse(Course)
     */
    @Test
    public void removePassedCourse_shouldThrowNotFoundExceptionWhenCourseIsNotFound() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies throw illegal argument exception when name parameter is not full name
     * @see Student#setName(String)
     */
    @ParameterizedTest
    @ValueSource(strings = {" John", " ", " John ", "John "})
    public void setName_shouldThrowIllegalArgumentExceptionWhenNameParameterIsNotFullName(String name) throws IllegalArgumentException {
        // Assert
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new Student(valid_studentNumber, name).setName(name));
    }

    /**
     * @verifies throw illegal argument exception when name is not full name
     * @see Student#Student(int, String)
     */
    @ParameterizedTest
    @ValueSource(strings = {" John", " ", " John ", "John "})
    public void Student_shouldThrowIllegalArgumentExceptionWhenNameIsNotFullName(String name) throws IllegalArgumentException {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                new Student(valid_studentNumber, name)
        );
    }

    /**
     * @verifies set semester properly
     * @see Student#setSemester(int)
     */
    @Test
    public void setSemester_shouldSetSemesterProperly() {
        // Act
        student.setSemester(valid_semester);
        // Assert
        assertThat(student.getSemester()).isEqualTo(valid_semester);
    }

    /**
     * @verifies remove a passed course
     * @see Student#removePassedCourse(Course)
     */
    @Test
    public void removePassedCourse_shouldRemoveAPassedCourse() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }
}