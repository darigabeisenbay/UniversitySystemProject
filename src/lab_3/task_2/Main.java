package lab_3.task_2;

public class Main {
    public static void main(String[] args) {
        Oyster oyster = new Oyster();
        oyster.move(2, 8);
        oyster.swim();

        Ship ship = new Ship();
        ship.move(0, 255);
        ship.swim();
    }
}
