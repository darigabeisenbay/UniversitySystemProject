package lab_3.task_6;

import java.util.Objects;

class Employee extends Person {

    private String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String title) { this.jobTitle = title; }

    @Override
    public String getOccupation() { return "Employee – " + jobTitle; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Employee e = (Employee) o;
        return Objects.equals(jobTitle, e.jobTitle);
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), jobTitle); }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age
                + ", jobTitle='" + jobTitle + "'"
                + ", pet=" + (hasPet() ? pet : "none") + '}';
    }
}

class Student extends Person {

    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    public String getMajor() { return major; }
    public void setMajor(String m) { this.major = m; }

    @Override
    public String getOccupation() { return "Student – major: " + major; }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Student s = (Student) o;
        return Objects.equals(major, s.major);
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), major); }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age
                + ", major='" + major + "'"
                + ", pet=" + (hasPet() ? pet : "none") + '}';
    }
}

class PhDStudent extends Person {

    private String researchField;

    public PhDStudent(String name, int age, String researchField) {
        super(name, age);
        this.researchField = researchField;
    }

    public String getResearchField() { return researchField; }
    public void setResearchField(String rf) { this.researchField = rf; }

    @Override
    public String getOccupation() { return "PhD Student – research: " + researchField; }

    @Override
    public void assignPet(Animal pet) {
        if (pet instanceof Dog) {
            System.out.println("⚠  " + name + " is a PhD student and cannot look after a Dog – too demanding!");
            return;
        }
        super.assignPet(pet);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        PhDStudent p = (PhDStudent) o;
        return Objects.equals(researchField, p.researchField);
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), researchField); }

    @Override
    public String toString() {
        return "PhDStudent{name='" + name + "', age=" + age
                + ", research='" + researchField + "'"
                + ", pet=" + (hasPet() ? pet : "none") + '}';
    }
}