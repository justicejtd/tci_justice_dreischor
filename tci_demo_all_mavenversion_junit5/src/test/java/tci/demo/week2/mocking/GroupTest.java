package tci.demo.week2.mocking;

import org.junit.jupiter.api.Test;
import tci.demo.week1.school.Group;
import tci.demo.week1.school.Student;

import static org.mockito.Mockito.*;

public class GroupTest {

    /**
     * Example with mocking
     */
    @Test
    public void mentorShouldBeSetForAllStudents() {
           //arrange
          // arrange SUT
        Group SUT = new Group("es-71");
         // arrange DOCs
        Student student1 = mock(Student.class);
        Student student2 = mock(Student.class);
        Student student3 = mock(Student.class);

        SUT.addStudent(student1);
        SUT.addStudent(student2);
        SUT.addStudent(student3);
        String mentorName = "Bert van Gestel";


        //act
        SUT.setMentor(mentorName);
        //assert (right method call with right parameters)
        verify(student1, description("Mentor was not set for student1.")).setMentor(mentorName);
        verify(student2, description("Mentor was not set for student2.")).setMentor(mentorName);
        verify(student3, description("Mentor was not set for student3.")).setMentor(mentorName);

    }
}