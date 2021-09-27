package tci.demo.week2.mocking;

import org.junit.jupiter.api.Test;
import tci.demo.week1.school.Course;
import tci.demo.week1.school.Student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentTest {

    private static final String VALID_NAME = "Joe Smith";
    private static final int VALID_STUDENT_NUMBER = 12345;

    /**
     * Explain:
     * 1. first point Course constructor by saying "ec=ec", instead of "this.ec = ec" - test will fail
     * 2. Add System.out.printline to Course : constructor and in getEC
     * 3. mock course1,2,3 -> test will pass, no println shown!
     */
    @Test
    public void ecsShouldBeAddedCorrectly() {
        // arrange
        // arrange SUT
        Student SUT = new Student(VALID_STUDENT_NUMBER, VALID_NAME);
        // arrange DOCs
        Course course1 = mock(Course.class); //new Course("Databases","DBS", 3);
        when(course1.getEc()).thenReturn(3);

        Course course2 = mock(Course.class); //new Course("Programming","PRG", 4);
        when(course2.getEc()).thenReturn(4);

        Course course3 = mock(Course.class); //new Course("Networks","NET", 3);
        when(course3.getEc()).thenReturn(3);

        SUT.addPassedCourse(course1);
        SUT.addPassedCourse(course2);
        SUT.addPassedCourse(course3);

        // act

        int totalSUTECs = SUT.getTotalECs();
        // assert
        assertThat(totalSUTECs).isEqualTo(3 + 4 + 3);
    }

    @Test
    public void shouldSetGivenMentorNameAsAMentorOfThisStudent(){
        // test the setMentor method of STUDENT object
    }

}