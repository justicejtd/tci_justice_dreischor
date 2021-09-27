package tci.demo.week2.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupTest {
    /**
     * @verifies create group with default name when no name is given
     * @see Group#Group()
     */
    @Test
    public void Group_should_create_group_with_default_name_when_no_name_is_given() throws Exception {
        // Arrange
        String defaultName = "unknown";
        // Act
        Group sut = new Group();
        // Assert
        assertThat(sut.getName()).isEqualTo(defaultName);

    }

    /**
     * @verifies create a group with given, non-null name
     * @see Group#Group(String)
     */
    @Test
    public void Group_should_create_a_group_with_given_nonnull_name() throws Exception {
        // Arrange
        String givenName = "NotDefaultName";
        // Act
        Group sut = new Group(givenName);
        // Assert
        assertThat(sut.getName()).isEqualTo(givenName);
    }

    /**
     * @verifies create a group with default name, when null is given as name
     * @see Group#Group(String)
     */
    @Test
    public void Group_should_create_a_group_with_default_name_when_null_is_given_as_name() throws Exception {
        // Arrange
        String defaultName = "unknown";
        // Act
        Group sut = new Group(null);
        // Assert
        assertThat(sut.getName()).isEqualTo(defaultName);
    }

    /**
     * @verifies show that logically same groups are equal and have same hashcode
     * @see Group#Group(String)
     */
    @Test
    public void Group_should_show_that_logically_same_groups_are_equal_and_have_same_hashcode() throws Exception {
        //act
        Group A = new Group("name1");
        Group B = new Group("name1");
        // Assert
        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);

    }

    /**
     * @verifies show that different groups are not equal
     * @see Group#Group(String)
     */
    @Test
    public void Group_should_show_that_different_groups_are_not_equal() throws Exception {
        //act
        Group A = new Group("name1");
        Group B = new Group("name2");
        // Assert
        assertThat(A).isNotEqualTo(B);
    }

    /**
     * @verifies add a given non-null student to the group
     * @see Group#addStudent(Student)
     */
    @Test
    public void addStudent_should_add_a_given_nonnull_student_to_the_group() throws Exception {
        // Arrange
        Group sut = new Group("testgroup");
        int studentID = 12345;
        Student student1 = new Student(studentID,"jan herring");
        // Act
        sut.addStudent(student1);
        // Assert
        assertThat(sut.getStudentById(studentID)).isEqualTo(student1);

    }

    /**
     * @verifies add nothing when student is null
     * @see Group#addStudent(Student)
     */
    @Test
    public void addStudent_should_add_nothing_when_student_is_null() throws Exception {
        // Arrange
        Group sut = new Group("testgroup");
        int studentID = 12345;
        // Act
        sut.addStudent(null);
        // Assert
        assertThat(sut.getStudentById(studentID)).isNull();
    }

    /**
     * @verifies not add a student twice to the group
     * @see Group#addStudent(Student)
     */
    @Test
    public void addStudent_should_not_add_a_student_twice_to_the_group() throws Exception {
        //arrange
        Group group = new Group("es-71");
        Student student1 = new Student(12345,"jan herring");
        Student student2 = new Student(13456,"eric wamp");
        Student student3 = new Student(14654,"gia jackson");
        Student identicalStudent = new Student(13456,"eric wamp");
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        int numberBefore = group.getNumberOfStudents();

        //act
        group.addStudent(identicalStudent);
        //assert
        assertThat(group.getNumberOfStudents()).isEqualTo(numberBefore);

    }

    /**
     * @verifies set the mentor for all students in the group
     * @see Group#setMentor(String)
     */
    @Test
    public void setMentor_should_set_the_mentor_for_all_students_in_the_group() throws Exception {
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

    /**
     * @verifies leave current assigned mentor unchanged when mentor is null
     * @see Group#setMentor(String)
     */
    @Test
    public void setMentor_should_leave_current_assigned_mentor_unchanged_when_mentor_is_null() throws Exception {
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
        String mentor = "Bert van Gestel";
        group.setMentor(mentor);
        //act
        group.setMentor(null);
        //assert
        // mentor name should not have changed
        assertThat(mentor).isEqualTo(student1.getMentor());
        assertThat(mentor).isEqualTo(student2.getMentor());
        assertThat(mentor).isEqualTo(student3.getMentor());
        assertThat(mentor).isEqualTo(student4.getMentor());
    }

     /**
     * @verifies return null when student with given ID is not present in the group
     * @see Group#getStudentById(int)
     */
    @Test
    public void getStudentById_should_return_null_when_student_with_given_ID_is_not_present_in_the_group() throws Exception {
        // Arrange
        Group sut = new Group("testgroup");
        int studentID = 12345;
        // Act
        // Assert
        assertThat(sut.getStudentById(studentID)).isNull();
    }

    /**
     * @verifies return student when student with given ID was added to the group before
     * @see Group#getStudentById(int)
     */
    @Test
    public void getStudentById_should_return_student_when_student_with_given_ID_was_added_to_the_group_before() throws Exception {
        // Arrange
        Group sut = new Group("testgroup");
        int studentID = 12345;
        Student student1 = new Student(studentID,"jan herring");
        // Act
        sut.addStudent(student1);
        // Assert
        assertThat(sut.getStudentById(studentID)).isEqualTo(student1);
    }

    /**
     * @verifies return 0 when no students are added
     * @see Group#getNumberOfStudents()
     */
    @Test
    public void getNumberOfStudents_should_return_0_when_no_students_are_added() throws Exception {
        // Arrange
        Group sut = new Group("testgroup");
        // Act
        // Assert
        assertThat(sut.getNumberOfStudents()).isEqualTo(0);
    }

    /**
     * @verifies return 1 higher when student is added
     * @see Group#getNumberOfStudents()
     */
    @Test
    public void getNumberOfStudents_should_return_1_higher_when_student_is_added() throws Exception {
        // Arrange
        Group sut = new Group("testgroup");
        int numberBefore = sut.getNumberOfStudents();
        int studentID = 12345;
        Student student1 = new Student(studentID,"jan herring");
        // Act
        sut.addStudent(student1);
        // Assert
        assertThat(sut.getNumberOfStudents()-numberBefore).isEqualTo(1);
    }
}
