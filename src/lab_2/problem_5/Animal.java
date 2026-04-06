package lab_2.problem_5;
enum AnimalType{
    CAT, DOG, BIRD, FISH
}
public abstract class Animal {
    private int age;
    private String name;
    private AnimalType type;

    public Animal(int age, String name, AnimalType type) {
        this.age = age;
        this.name = name;
        this.type = type;
    }
    public abstract void getSound();

    public String getName() {
        return name;
    }

}
