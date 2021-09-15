package tci.demo.week1.school;

import org.w3c.dom.ranges.Range;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A student is identified by studentNumber and name.
 * A student gets semester number 1 when enrolled for the first time (e.g., new regular bachelor students).
 * studentnumber never changes. the name can change.
 * Students can have a mentor, which can be changed later.
 * semesters range from 1..8
 * with a unique student number, consisting of 5 digits.
 */

public class Student {

    // TODO
    private final int studentNumber;
    private String name;
    private final ArrayList<Course> courses = new ArrayList<>();
    private int semester;

    /**
     * Constructor which sets fields for studentNumber and firstName. Field semester is set to 1.
     * Should be used when student is enrolled in the first semester (e.g., regular bachelor students).
     *
     * @param studentNumber student number of 5 digits.
     * @param name          full full name of the student, e.g., Joe van der Smith
     * @throws IllegalArgumentException Exception is thrown is studentNumber is not a positive 5-digits integer,
     *                                  or semester is not in range [1..8].
     * @should beInSemester1
     * @should initialized parameters properly
     * @should be logically equally with other students with the same name and studentNumber
     * @should throw illegal argument exception when student number is not 5 positive digits
     * @should throw illegal argument exception when name is not full name
     */
    public Student(int studentNumber, String name) throws IllegalArgumentException {
        if (String.valueOf(studentNumber).length() != 5 || !(studentNumber > 0)) {
            throw new IllegalArgumentException("Please enter a valid student number, it must be positive 5 digits integer");
        }
        this.studentNumber = studentNumber;
        setName(name);
        setSemester(1);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @param semester range of 1 and 8
     * @should throw illegal argument exception if semester is not in the range of 1 and 8
     * @should set semester properly
     */
    public void setSemester(int semester) throws IllegalArgumentException {
        if (!(semester >= 1 && semester <= 8)) {
            throw new IllegalArgumentException("Please a valid semester in the range of 1 and 8");
        }
        this.semester = semester;
    }

    /**
     * get the total ECs from all passed courses.
     *
     * @return number of ECs.
     * @should return the right total number of ECs
     */
    public int getTotalECs() {
        // TODO
        return 0;
    }

    /**
     * adds a passed course to a student. a student can only pass a course once.
     *
     * @param course
     * @should add a passed course properly
     * @should throw an illegal exception when course already has been passed
     * @should throw null pointer exception when course is null
     */
    public void addPassedCourse(Course course) throws IllegalArgumentException, NullPointerException {
        if (course == null) {
            throw new NullPointerException("Course is null, please enter a valid course");
        }
        if (courses.contains(course)) {
            throw new IllegalArgumentException("Course already been passed!");
        }
        getCourses().add(course);
    }

    /**
     * removes a passed course from a student.
     *
     * @param course passed course to remove
     * @throws NotFoundException when course is not found
     * @should throw not found exception when course is not found
     * @should remove a passed course
     */

    public void removePassedCourse(Course course) throws NotFoundException {
        if (!(getCourses().contains(course))) {
            throw new NotFoundException("Course not found, please enter a valid Course!");
        }
        courses.remove(course);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @param name
     * @should throw illegal argument exception when name parameter is not full name
     */
    public void setName(String name) {
        String[] names = name.split(" ");
        int nameCounter = 0;

        for (int i = 0; i < names.length; i++) {
            if (names[i].trim().equals("")) {
                names[i] = null;
            }
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                nameCounter++;
            }
        }

        if (!(nameCounter >= 2)) {
            throw new IllegalArgumentException("Please enter a full name!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentNumber == student.studentNumber && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, name);
    }

    public int getSemester() {
        return semester;
    }

    /******************************************************
     *
     *   GETTERS/SETTERS CODE IS GENERATED BY INTELLIJ,
     *   AND UNTOUCHED BY PEOPLE.
     *   THE BEHAVIOUR OF THIS CODE DOES NOT HAVE TO BE TESTED.
     *
     ********************************************************/

    // TODO: when needed.

    /******************************************************
     *
     *   OTHER CODE GENERATED BY INTELLIJ,
     *   BUT BASED ON INPUT OF A PROGRAMMER.
     *   THE BEHAVIOUR OF THIS CODE HAS TO BE TESTED.
     *   (but not present to keep demo code short)
     *
     ********************************************************/
    // TODO
}
