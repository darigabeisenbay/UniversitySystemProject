package lab_2.problem_5;

import java.util.Objects;

public abstract class Person {
    private String name;
    private int age;
    private Animal pet;

    public Person(String name, int age, Animal pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
        assignPet(pet);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract String getOccupation();

    public void assignPet(Animal pet){
        this.pet = pet;
    }

    public void removePet(){
        this.pet = null;
    }
    public boolean hasPet(){
        return this.pet != null;
    }

    public String getName() {
        return name;
    }

    public Animal getPet() {
        return pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(pet, person.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, pet);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", animal=" + pet +
                '}';
    }
    public void leavePetWith(Person caretaker) {
        if (!this.hasPet()) {
            System.out.println(name + " has no pet to leave.");
            return;
        }

        Animal tempPet = this.pet;
        System.out.println(name + " is leaving " + tempPet.getName() + " with " + caretaker.getName());

        // Пытаемся передать питомца смотрителю
        caretaker.assignPet(tempPet);

        // Если смотритель принял питомца (проверка прошла), удаляем у себя
        if (caretaker.getPet() == tempPet) {
            this.removePet();
        }
    }
    public void retrievePetFrom(Person caretaker) {
        if (caretaker.getPet() != null) {
            Animal returningPet = caretaker.getPet();
            System.out.println(name + " retrieves " + returningPet.getName() + " from " + caretaker.getName());
            this.assignPet(returningPet);
            caretaker.removePet();
        }
    }
}
