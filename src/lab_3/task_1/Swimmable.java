package lab_3.task_1;
// We use interface when we want to say what object does, without saying how it does
public interface Swimmable {
    void swim();
}
class Fish implements Swimmable{
    public void swim(){
        System.out.println("Fish can swim");
    }

}
class Boat implements Swimmable{
    public void swim(){
        System.out.println("Boat can swim");
    }
}
