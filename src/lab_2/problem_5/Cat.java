package lab_2.problem_5;

public class Cat extends Animal{
    public Cat(int age, String name){
        super(age,  name, AnimalType.CAT);
    }
    @Override
    public void getSound(){
        System.out.println("meow meow meow");
    }


}
