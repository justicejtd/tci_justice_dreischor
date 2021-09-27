package tci.demo.week2.school;

public interface IStudent {
    int getTotalECs();

    void addPassedCourse(Course course);


    void removePassedCourse(Course course) throws NotFoundException;

    int getStudentNumber();

    String getName();

    void setName(String name);

    String getMentor();

    void setMentor(String mentor);

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
