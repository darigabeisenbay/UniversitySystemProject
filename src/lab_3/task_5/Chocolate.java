package lab_3.task_5;

import java.util.Objects;


public class Chocolate implements Comparable<Chocolate> {

    private String name;
    private double weight;

    public Chocolate(String name, double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.name   = name;
        this.weight = weight;
    }

    public String getName()           { return name; }
    public void   setName(String n)   { this.name = n; }

    public double getWeight()         { return weight; }
    public void   setWeight(double w) { this.weight = w;}

    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chocolate c = (Chocolate) o;
        return Double.compare(weight, c.weight) == 0 && Objects.equals(name, c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "Chocolate{name='" + name + "', weight=" + weight + "g}";
    }
}