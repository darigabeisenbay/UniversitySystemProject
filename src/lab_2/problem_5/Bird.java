package lab_2.problem_5;

public class Bird extends Animal{
    public Bird(int age, String name){
        super(age, name, AnimalType.BIRD);
    }
    @Override
    public void getSound(){
        System.out.println("wsk wsk wsk");
    }
}