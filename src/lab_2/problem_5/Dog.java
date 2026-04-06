package lab_2.problem_5;

public class Dog extends Animal{
    public Dog(int age, String name){
        super(age, name, AnimalType.DOG);
    }
    @Override
    public void getSound(){
        System.out.println("woof woof");
    }


}
