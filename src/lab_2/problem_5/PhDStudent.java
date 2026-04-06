package lab_2.problem_5;

import java.util.Objects;

public class PhDStudent extends Person{
    private String major;
    private String university;
    public PhDStudent(String name, int age, String major, String university){
        super(name, age);
        this.major = major;
        this.university = university;
    }
    public String getOccupation(){
        return university;
    };

    public PhDStudent(String name, int age, String university) {
        super(name, age);
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhDStudent that = (PhDStudent) o;
        return Objects.equals(university, that.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university);
    }

    @Override
    public String toString() {
        return "PhDStudent{" +
                "university='" + university + '\'' +
                "} " + super.toString();
    }
    @Override
    public void assignPet(Animal pet) {
        if (pet instanceof Dog) {
            System.out.println("ALERT: PhD Student " + getName() + " cannot take a Dog! Too high maintenance.");
        } else {
            super.assignPet(pet);
        }
    }
}
