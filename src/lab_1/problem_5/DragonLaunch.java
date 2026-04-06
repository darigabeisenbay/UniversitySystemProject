package lab_1.problem_5;
import java.util.Vector;
import java.util.Scanner;

enum Gender { B, G }

class Person {
    private Gender gender;
    public Person(Gender gender) { this.gender = gender; }
    public Gender getGender() { return gender; }
    public String toString() { return gender.toString(); }
}
public class DragonLaunch {
    private Vector<Person> line = new Vector<>();

    public void kidnap(Person p) {
        line.add(p);
}
    public boolean willDragonEatOrNot() {
        int boysWaiting = 0;
        for (Person p : line) {
            if (p.getGender() == Gender.B) {
                boysWaiting++;
            } else {
                if (boysWaiting > 0) {
                    boysWaiting--;
                } else {
                    return true;
                }
            }
        }
        return boysWaiting != 0;
    }

    public static void main(String[] args) {
        DragonLaunch dl = new DragonLaunch();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите последовательность студентов (B для мальчиков, G для девочек).");
        System.out.println("Введите 'exit' или любую другую строку, чтобы закончить ввод:");

        while (sc.hasNext()) {
            String input = sc.next().toUpperCase();

            if (input.equals("B")) {
                dl.kidnap(new Person(Gender.B));
            } else if (input.equals("G")) {
                dl.kidnap(new Person(Gender.G));
            } else {
                break;
            }
        }

        if (dl.willDragonEatOrNot()) {
            System.out.println("Дракон пообедает! (Кто-то остался в очереди)");
        } else {
            System.out.println("Дракон останется голодным. (Все пары исчезли)");
        }

        sc.close();
    }
}
