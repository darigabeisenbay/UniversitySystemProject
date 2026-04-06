package lab_3.task_3;

public class Main {
    public static void main(String[] args) {
        NaturalNumbers naturalNumbers = new NaturalNumbers ();
        naturalNumbers.add(23);
        naturalNumbers.add(-1);
        naturalNumbers.add(3);
        System.out.println(naturalNumbers.size());
        naturalNumbers.remove(3);
        System.out.println(naturalNumbers.size());
        naturalNumbers.clear();
        System.out.println(naturalNumbers.size());
    }
}
