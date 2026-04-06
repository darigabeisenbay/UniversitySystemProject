package lab_2.problem_5;

import java.util.Objects;

public class Student extends Person{
    private String major;
    public Student(String name, int age, Animal pet, String major){
        super( name, age, pet);
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }
    public String getOccupation(){
        return major;
    };

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major);
    }

    @Override
    public String toString() {
        return "Student{" +
                "major='" + major + '\'' +
                "} " + super.toString();
    }
}
