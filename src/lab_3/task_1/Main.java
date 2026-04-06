package lab_3.task_1;

public class Main {
    public static void main(String[] args) {
        Shape square = new Square("violet", 4);
        System.out.println(square.area());
        System.out.println(square.perimeter());
        System.out.println(square.showColor());

        Swimmable fish = new Fish();
        fish.swim();

        Boat boat = new Boat();
        boat.swim();

    }
}
