import java.io.*;
public class Students implements Serializable{

    private Long id;
    private String lastName;
    private String firstName;
    private int course;
    private double gpa;

    public Students(){}

    public Students(Long id, String lastName, String firstName, int course, double gpa) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.gpa = gpa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", course=" + course +
                ", gpa=" + gpa +
                '}';
    }

}