package lab_3.task_4;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Employee extends Person implements Comparable<Employee>, Cloneable {

    protected double salary;
    protected Date   hireDate;
    protected String insuranceNumber;

    public Employee(String name) {
        super(name);
    }

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public Employee(String name, double salary, Date hireDate, String insuranceNumber) {
        super(name);
        this.salary          = salary;
        this.hireDate        = hireDate;
        this.insuranceNumber = insuranceNumber;
    }

    public double getSalary()                       { return salary; }
    public void   setSalary(double salary)          { this.salary = salary; }

    public Date   getHireDate()                     { return hireDate; }
    public void   setHireDate(Date hireDate)        { this.hireDate = hireDate; }

    public String getInsuranceNumber()              { return insuranceNumber; }
    public void   setInsuranceNumber(String num)    { this.insuranceNumber = num; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee other = (Employee) o;
        return Double.compare(salary, other.salary) == 0
                && Objects.equals(hireDate,        other.hireDate)
                && Objects.equals(insuranceNumber, other.insuranceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary, hireDate, insuranceNumber);
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='"           + name            + '\''
                + ", salary="        + salary
                + ", hireDate="      + hireDate
                + ", insurance='"    + insuranceNumber  + '\''
                + '}';
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }
    public static final Comparator<Employee> BY_NAME =
            Comparator.comparing(e -> e.name.toLowerCase());

    public static final Comparator<Employee> BY_HIRE_DATE =
            Comparator.comparing(Employee::getHireDate,
                    Comparator.nullsLast(Comparator.naturalOrder()));

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            if (this.hireDate != null) {
                copy.hireDate = (Date) this.hireDate.clone();
            }
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone failed – should never happen", e);
        }
    }
}