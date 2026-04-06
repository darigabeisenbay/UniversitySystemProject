package lab_3.task_4;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class Manager extends Employee {

    private double bonus;
    private Vector<Employee> team;

    public Manager(String name) {
        super(name);
        this.team = new Vector<>();
    }

    public Manager(String name, double salary) {
        super(name, salary);
        this.team = new Vector<>();
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
        this.team  = new Vector<>();
    }

    public Manager(String name, double salary, Date hireDate,
                   String insuranceNumber, double bonus) {
        super(name, salary, hireDate, insuranceNumber);
        this.bonus = bonus;
        this.team  = new Vector<>();
    }

    public double           getBonus()              { return bonus; }
    public void             setBonus(double bonus)  { this.bonus = bonus; }

    public Vector<Employee> getTeam()               { return team; }

    public void addTeamMember(Employee e)           { team.add(e); }

    public boolean removeTeamMember(Employee e)     { return team.remove(e); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(bonus, manager.bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return "Manager{"
                + "name='"        + name   + '\''
                + ", salary="     + salary
                + ", bonus="      + bonus
                + ", hireDate="   + hireDate
                + ", insurance='" + insuranceNumber + '\''
                + ", teamSize="   + team.size()
                + '}';
    }


    @Override
    public int compareTo(Employee other) {
        int cmp = Double.compare(this.salary, other.salary);
        if (cmp != 0) return cmp;

        if (other instanceof Manager otherManager) {
            return Double.compare(this.bonus, otherManager.bonus);
        }
        return 0;
    }


    @Override
    public Manager clone() {
        Manager copy = (Manager) super.clone();

        copy.team = new Vector<>();
        for (Employee member : this.team) {
            copy.team.add(member.clone());
        }
        return copy;
    }
}