package lab_3.task_2;

public interface Moveable {
    void move(int x, int y);
}

interface Swimmable extends Moveable {
    void swim();
}

class Oyster implements  Swimmable{
    @Override
    public void move(int x ,int y){
        System.out.println("Start position was " + x + " and end position is " + y);
    }
    @Override
    public void swim(){
        System.out.println("It can swim by its own!");
    }
}

class Ship implements Swimmable{
    @Override
    public void move(int x ,int y){
        System.out.println("It started with " + x + " kilometers and ended with " + y + " kilometers");
    }
    @Override
    public void swim(){
        System.out.println("It can swim by captain's managing");
    }
}