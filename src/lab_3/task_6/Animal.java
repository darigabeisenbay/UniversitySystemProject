package lab_3.task_6;

import java.util.Objects;

public abstract class Animal implements Comparable<Animal>, Cloneable {

    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getSound();

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public int compareTo(Animal other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public Animal clone() {
        try {
            return (Animal) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone failed", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal a = (Animal) o;
        return age == a.age && Objects.equals(name, a.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name, age); }

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{name='" + name + "', age=" + age
                + ", sound='" + getSound() + "'}";
    }
}