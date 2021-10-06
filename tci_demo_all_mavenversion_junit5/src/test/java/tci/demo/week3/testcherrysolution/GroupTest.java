package tci.demo.week3.testcherrysolution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tci.demo.week2.school.solutions.Group_withTestSpecification;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupTest {
    /**
     * @verifies create group with default name when no name is given
     * @see Group_withTestSpecification#Group_withTestSpecification()
     */
    @Test
    public void Group_shouldCreateGroupWithDefaultNameWhenNoNameIsGiven() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies create a group with given, non-null name
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_shouldCreateAGroupWithGivenNonnullName() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies create a group with default name, when null is given as name
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_shouldCreateAGroupWithDefaultNameWhenNullIsGivenAsName() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies add a given non-null student to the group
     * @see Group_withTestSpecification#addStudent(tci.demo.week1.school.Student)
     */
    @Test
    public void addStudent_shouldAddAGivenNonnullStudentToTheGroup() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies add nothing when student is null
     * @see Group_withTestSpecification#addStudent(tci.demo.week1.school.Student)
     */
    @Test
    public void addStudent_shouldAddNothingWhenStudentIsNull() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies set the mentor for all students in the group
     * @see Group_withTestSpecification#setMentor(String)
     */
    @Test
    public void setMentor_shouldSetTheMentorForAllStudentsInTheGroup() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies leave current assigned mentor unchanged when mentor is null
     * @see Group_withTestSpecification#setMentor(String)
     */
    @Test
    public void setMentor_shouldLeaveCurrentAssignedMentorUnchangedWhenMentorIsNull() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies not add a student twice to the group
     * @see Group_withTestSpecification#addStudent(tci.demo.week1.school.Student)
     */
    @Test
    public void addStudent_shouldNotAddAStudentTwiceToTheGroup() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }


    /**
     * @verifies show that logically same groups are equal and have same hashcode
     * @see Group_withTestSpecification#object()
     */
    @Test
    public void object_shouldShowThatLogicallySameGroupsAreEqualAndHaveSameHashcode() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies show that different groups are not equal
     * @see Group_withTestSpecification#object()
     */
    @Test
    public void object_shouldShowThatDifferentGroupsAreNotEqual() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies create group with default name when no name is given
     * @see Group_withTestSpecification#Group_withTestSpecification()
     */
    @Test
    public void Group_should_create_group_with_default_name_when_no_name_is_given() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies create a group with given, non-null name
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_should_create_a_group_with_given_nonnull_name() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies create a group with default name, when null is given as name
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void Group_should_create_a_group_with_default_name_when_null_is_given_as_name() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies add a given non-null student to the group
     * @see Group_withTestSpecification#addStudent(tci.demo.week1.school.Student)
     */
    @Test
    public void addStudent_should_add_a_given_nonnull_student_to_the_group() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies add nothing when student is null
     * @see Group_withTestSpecification#addStudent(tci.demo.week1.school.Student)
     */
    @Test
    public void addStudent_should_add_nothing_when_student_is_null() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies not add a student twice to the group
     * @see Group_withTestSpecification#addStudent(tci.demo.week1.school.Student)
     */
    @Test
    public void addStudent_should_not_add_a_student_twice_to_the_group() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies set the mentor for all students in the group
     * @see Group_withTestSpecification#setMentor(String)
     */
    @Test
    public void setMentor_should_set_the_mentor_for_all_students_in_the_group() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies leave current assigned mentor unchanged when mentor is null
     * @see Group_withTestSpecification#setMentor(String)
     */
    @Test
    public void setMentor_should_leave_current_assigned_mentor_unchanged_when_mentor_is_null() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }

    /**
     * @verifies show that logically same groups are equal and have same hashcode
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void object_should_show_that_logically_same_groups_are_equal_and_have_same_hashcode() throws Exception {
        // arrange
        //act
        Group_withTestSpecification A = new Group_withTestSpecification("name1");
        Group_withTestSpecification B = new Group_withTestSpecification("name1");
        // Assert
        assertThat(A).isEqualTo(B);
        assertThat(A).hasSameHashCodeAs(B);
    }

    /**
     * @verifies show that different groups are not equal
     * @see Group_withTestSpecification#Group_withTestSpecification(String)
     */
    @Test
    public void object_should_show_that_different_groups_are_not_equal() throws Exception {
        //TODO auto-generated
        Assertions.fail("Not yet implemented");
    }
}
