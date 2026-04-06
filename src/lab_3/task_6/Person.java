package lab_3.task_6;

import java.util.Objects;

public abstract class Person implements Petable, VacationReady, Comparable<Person>, Cloneable {

    protected String name;
    protected int age;
    protected Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getOccupation();

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public void assignPet(Animal pet) {
        this.pet = pet;
        System.out.println(name + " now owns " + pet.getName() + " the " + pet.getClass().getSimpleName());
    }

    @Override
    public void removePet() {
        if (pet != null) {
            System.out.println(name + " no longer owns " + pet.getName());
            pet = null;
        } else {
            System.out.println(name + " has no pet to remove.");
        }
    }

    @Override
    public boolean hasPet() { return pet != null; }

    @Override
    public Animal getPet() { return pet; }

    @Override
    public void leavePetWith(Person caretaker) {
        if (!hasPet()) {
            System.out.println(name + " has no pet to leave.");
            return;
        }
        Animal toLeave = this.pet;
        this.pet = null;
        caretaker.assignPet(toLeave);
        System.out.println(name + " left " + toLeave.getName()
                + " with " + caretaker.getName() + " while on vacation.");
    }

    @Override
    public void retrievePetFrom(Person caretaker) {
        if (!caretaker.hasPet()) {
            System.out.println(caretaker.getName() + " is not holding a pet for " + name);
            return;
        }
        Animal returned = caretaker.getPet();
        caretaker.removePet();
        this.assignPet(returned);
        System.out.println(name + " retrieved " + returned.getName()
                + " from " + caretaker.getName() + ".");
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public Person clone() {
        try {
            Person copy = (Person) super.clone();
            if (this.pet != null) copy.pet = this.pet.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clone failed", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return age == p.age && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name, age); }

    @Override
    public String toString() {
        String petInfo = hasPet() ? pet.toString() : "none";
        return getClass().getSimpleName()
                + "{name='" + name + "', age=" + age
                + ", occupation='" + getOccupation() + "'"
                + ", pet=" + petInfo + '}';
    }
}