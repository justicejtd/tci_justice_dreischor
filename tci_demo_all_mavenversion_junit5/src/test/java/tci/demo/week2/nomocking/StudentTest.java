package tci.demo.week2.nomocking;

import org.junit.jupiter.api.Test;
import tci.demo.week1.school.Course;
import tci.demo.week1.school.Student;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    private static final String VALID_NAME = "Joe Smith";
    private static final int VALID_STUDENT_NUMBER = 12345;


    @Test
    public void newStudentsAreCreatedWithSemesterNumberOne(){
        //
    }

    @Test
    public void existingStudentsShouldBeAbleToBeCreatedWithAGivenSemesterNumber(){
        //
    }

    /**
     * Explain:
     * 'bad' test: does not use mocking.
     * This test is dependent on the IMPLEMENTATION CODE of Course. It should only be dependent on the BEHAVIOR of Course.
     * 1. first point Course constructor by saying "ec=ec", instead of "this.ec = ec" - test will fail
     * 2. Add System.out.printline to Course : constructor and in getEC
     * 3. mock course1,2,3 -> test will pass, no println shown!
     */
    @Test
    public void ecsOfPassedCourses_ShouldBeAddedCorrectly() {
        // arrange
        // arrange SUT
        Student SUT = new Student(VALID_STUDENT_NUMBER, VALID_NAME);
        // arrange DOCs
        Course course1 = new Course("Databases","DBS", 3);
        Course course2 = new Course("Programming","PRG", 4);
        Course course3 = new Course("Networks","NET", 3);
        SUT.addPassedCourse(course1);
        SUT.addPassedCourse(course2);
        SUT.addPassedCourse(course3);

        // act

        int totalSUTECs = SUT.getTotalECs();
        // assert
        assertThat(totalSUTECs).isEqualTo( 3 + 4 + 3 );
    }

}