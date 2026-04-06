package lab_2.problem_5;

public class Fish extends Animal {
    public Fish(int age, String name){
        super(age, name,  AnimalType.FISH);
    }

    @Override
    public void getSound(){
        System.out.println("bluk bluk ");
    }
}
