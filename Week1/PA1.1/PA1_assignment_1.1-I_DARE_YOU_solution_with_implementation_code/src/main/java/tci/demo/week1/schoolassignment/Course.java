package tci.demo.week1.schoolassignment;

import java.util.Objects;

/**
 * A Course is an IMMUTABLE object with a given name, code and ec.
 * It's uniquely identified by it's course code (a string).
 * the name of the course (a string) should not be null
 * code should be 3 or 4 characters long and is in upper case
 * the number of EC's (ec) is a positive whole number.
 * If above parametes are wrong, an IllegalArgumentException should be thrown during construction.
 */
public class Course {
    // TODO: create code which complies with the specification above,
    // and uses the method calls below (add methods if you think they
    // are necessary (they are!).
    // TODO: create code which complies with the specification above.
    // YOUR perfect code goes here.
    private final String courseCode;
    private final String name;
    private final Integer ecs;

    public Course(String name, String courseCode, Integer ecs) throws IllegalArgumentException {
        if (name == null)
            throw new IllegalArgumentException("name cannot be null.");
        if (courseCode == null)
            throw new IllegalArgumentException("course cannot be null.");
        if (courseCode.length() < 3 || courseCode.length() > 4)
            throw new IllegalArgumentException("courseCode too small or too big.");
        if (ecs < 0)
            throw new IllegalArgumentException("Cannot have negative ECs.");
            if (!courseCode.toUpperCase().equals(courseCode)) {
                throw new IllegalArgumentException("Coursecode is not in uppercase");
            }
        this.courseCode = courseCode;
        this.name = name;
        this.ecs = ecs;
    }

    public String getCode() {
        return courseCode;
    }

    public String getName() {
        return name;
    }

    public Integer getEc() {
        return ecs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return courseCode.equals(course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}
/*
*
* Note: An IMMUTABLE object is mostly used for transfering data between layers in your software
* , so it only has a constructor which sets ALL attributes, and it has getters (generated by the IDE)
* for all of the attributes.
* (this is a so called DTO: Data Transfer Object)
* 
*
 */

