package tci.demo.week2.nomocking;

import org.junit.jupiter.api.Test;
import tci.demo.week1.school.Group;
import tci.demo.week1.school.Student;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupTest {

    /**
     * Explain:
     * 'bad' test: does not use mocking.
     * This test is dependent on the IMPLEMENTATION CODE of Student. It should only be dependent on the BEHAVIOR of Student.
     * You can only find out INDIRECTLY if the setMentor method was called by actually calling 'getMentor' on the Student Objects.
     *
     * 1. show what happens if getmentor return null (not implemented yet)
     */

    @Test
    public void mentorShouldBeSetForAllStudents() {
        //arrange
        Group group = new Group("es-71");
        Student student1 = new Student(12345,"jan herring");
        Student student2 = new Student(13456,"eric wamp");
        Student student3 = new Student(14654,"gia jackson");
        Student student4 = new Student(15654,"gio mattiu");
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        group.addStudent(student4);

        //act
        String mentor = "Bert van Gestel";
        group.setMentor(mentor);
        //assert
        // how to find out if method setMentor was called by the SUT?
        assertThat(mentor).isEqualTo(student1.getMentor());
        assertThat(mentor).isEqualTo(student2.getMentor());
        assertThat(mentor).isEqualTo(student3.getMentor());
        assertThat(mentor).isEqualTo(student4.getMentor());
    }

}