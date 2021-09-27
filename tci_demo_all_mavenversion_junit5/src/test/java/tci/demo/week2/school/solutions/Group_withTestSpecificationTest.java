package tci.demo.week2.school.solutions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tci.demo.week2.school.Group;
import tci.demo.week2.school.Student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class Group_withTestSpecificationTest {
    /**
     * @verifies set the mentor for all students in the group
     * @see Group_withTestSpecification#setMentor(String)
     */
    @Test
    public void setMentor_should_set_the_mentor_for_all_students_in_the_group() {
        // Arrange
        String mentorName = "John";
        Student studentA = mock(Student.class);
        Student studentB = mock(Student.class);
        Student studentC = mock(Student.class);
        Group_withTestSpecification sut = new Group_withTestSpecification();
        // Act
        sut.addStudent(studentA);
        sut.addStudent(studentB);
        sut.addStudent(studentC);
        sut.setMentor(mentorName);
        // Assert
        verify(studentA).setMentor(mentorName);
        verify(studentB).setMentor(mentorName);
        verify(studentC).setMentor(mentorName);
    }

    /**
     * @verifies create group with default name when no name is given
     * @see Group_withTestSpecification#Group_withTestSpecification()
     */
    @Test
    public void Group_withTestSpecification_should_create_group_with_default_name_when_no_name_is_given() {
        // Arrange
        String defaultName = "unknown";
        Group_withTestSpecification sut = new Group_withTestSpecification();
        // Assert
        assertThat(sut.getName()).isEqualTo(defaultName);
    }

    /**
     * @verifies add a given non-null student to the group
     * @see Group_withTestSpecification#addStudent(Student)
     */
    @Test
    public void addStudent_should_add_a_given_nonnull_student_to_the_group() {
        // Arrange
        Student studentA = mock(Student.class);
        int studentNumber = 1245678910;
        Group_withTestSpecification sut = new Group_withTestSpecification();
        // Act
        when(studentA.getStudentNumber()).thenReturn(studentNumber);
        sut.addStudent(studentA);
        // Assert
        assertThat(sut.getStudentById(studentNumber)).isEqualTo(studentA);
    }

    /**
     * @verifies add nothing when student is null
     * @see Group_withTestSpecification#addStudent(Student)
     */
    @Test
    public void addStudent_should_add_nothing_when_student_is_null() {
        // Arrange
        Group_withTestSpecification sut = new Group_withTestSpecification();
        int numberOfStudentsBeforeAdding = sut.getNumberOfStudents();
        // Act
        sut.addStudent(null);
        // Assert
        assertThat(sut.getNumberOfStudents() - numberOfStudentsBeforeAdding).isEqualTo(0);
    }

    /**
     * @verifies not add a student twice to the group
     * @see Group_withTestSpecification#addStudent(Student)
     */
    @Test
    public void addStudent_should_not_add_a_student_twice_to_the_group() {
        // Arrange
        Group_withTestSpecification sut = new Group_withTestSpecification();
        Student studentA = mock(Student.class);
        // Act
        sut.addStudent(studentA);
        sut.addStudent(studentA);
        // Assert
        assertThat(sut.getStudents()).containsOnlyOnce(studentA);
    }

    /**
     * @verifies leave current assigned mentor unchanged when mentor is null
     * @see Group_withTestSpecification#setMentor(String)
     */
    @Test
    public void setMentor_should_leave_current_assigned_mentor_unchanged_when_mentor_is_null() {
        // Arrange
        Student studentA = mock(Student.class);
        String mentor = "John";
        Group_withTestSpecification sut = new Group_withTestSpecification();
        // Act
        sut.addStudent(studentA);
        sut.setMentor(null);
        // Verify
        verify(studentA, never()).setMentor(mentor);
    }

    /**
     * @verifies create a group with given, non-null name
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_withTestSpecification_should_create_a_group_with_given_nonnull_name() {
        // Arrange
        String name = "name";
        Group_withTestSpecification sut = new Group_withTestSpecification(name);
        // Assert
        assertThat(sut.getName()).isEqualTo(name);
    }

    /**
     * @verifies create a group with default name, when null is given as name
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_withTestSpecification_should_create_a_group_with_default_name_when_null_is_given_as_name() throws Exception {
        // Arrange
        String name = "unknown";
        Group_withTestSpecification sut = new Group_withTestSpecification(null);
        // Assert
        assertThat(sut.getName()).isEqualTo(name);
    }

    /**
     * @verifies show that logically same groups are equal and have same hashcode
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_withTestSpecification_should_show_that_logically_same_groups_are_equal_and_have_same_hashcode() throws Exception {
        // Arrange
        Group_withTestSpecification sutA = new Group_withTestSpecification();
        Group_withTestSpecification sutB = new Group_withTestSpecification();
        // Assert
        assertThat(sutA).isEqualTo(sutB);
        assertThat(sutA.hashCode()).isEqualTo(sutB.hashCode());
    }

    /**
     * @verifies show that different groups are not equal
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_withTestSpecification_should_show_that_different_groups_are_not_equal() throws Exception {
        // Arrange
        Group_withTestSpecification sutA = new Group_withTestSpecification();
        Group_withTestSpecification sutB = new Group_withTestSpecification("GroupB");
        // Assert
        assertThat(sutA).isNotEqualTo(sutB);
    }

    /**
     * @verifies return null when student with given ID is not present in the group
     * @see Group_withTestSpecification#getStudentById(int)
     */
    @Test
    public void getStudentById_should_return_null_when_student_with_given_ID_is_not_present_in_the_group() throws Exception {
        // Arrange
        Group_withTestSpecification sut = new Group_withTestSpecification();
        Student student = mock(Student.class);
        // Act
        sut.addStudent(student);
        // Assert
        assertThat(sut.getStudentById(1234568910)).isNull();
    }

    /**
     * @verifies return student when student with given ID was added to the group before
     * @see Group_withTestSpecification#getStudentById(int)
     */
    @Test
    public void getStudentById_should_return_student_when_student_with_given_ID_was_added_to_the_group_before() throws Exception {
        // Arrange
        int studentNumber = 123456789;
        Group_withTestSpecification sut = new Group_withTestSpecification();
        Student student = mock(Student.class);
        // Act
        when(student.getStudentNumber()).thenReturn(studentNumber);
        sut.addStudent(student);
        // Assert
        assertThat(sut.getStudentById(studentNumber)).isEqualTo(student);
    }

    /**
     * @verifies return 0 when no students are added
     * @see Group_withTestSpecification#getNumberOfStudents()
     */
    @Test
    public void getNumberOfStudents_should_return_0_when_no_students_are_added() throws Exception {
        // Arrange
        Group_withTestSpecification sut = new Group_withTestSpecification();
        // Assert
        assertThat(sut.getNumberOfStudents()).isEqualTo(0);
    }

    /**
     * @verifies return 1 higher when student is added
     * @see Group_withTestSpecification#getNumberOfStudents()
     */
    @Test
    public void getNumberOfStudents_should_return_1_higher_when_student_is_added() throws Exception {
        // Arrange
        Group_withTestSpecification sut = new Group_withTestSpecification();
        Student student = mock(Student.class);
        // Act
        sut.addStudent(student);
        // Assert
        assertThat(sut.getNumberOfStudents()).isEqualTo(1);
    }
}
