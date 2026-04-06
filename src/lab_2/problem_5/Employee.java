package lab_2.problem_5;

import java.util.Objects;

public class Employee extends Person{
    private String profession;
    public Employee(String name, int age, Animal pet, String profession){
        super(name, age,  pet);
        this.profession = profession;
    }

    public Employee(String name, int age, String profession) {
        super(name, age);
        this.profession = profession;
    }
    @Override
    public  String getOccupation(){
        return profession;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(profession, employee.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), profession);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "profession='" + profession + '\'' +
                "} " + super.toString();
    }
}
