package lab_3.task_5;

public class Main {

    public static void main(String[] args) {
        Chocolate twix     = new Chocolate("Twix",     58.0);
        Chocolate snickers = new Chocolate("Snickers", 50.0);
        System.out.println("Twix(58g).compareTo(Snickers(50g)) = " + twix.compareTo(snickers));
        System.out.println("Snickers(50g).compareTo(Twix(58g)) = " + snickers.compareTo(twix));

        Time t1 = new Time(1, 0, 0);
        Time t2 = new Time(0, 59, 59);
        System.out.println("01:00:00 vs 00:59:59 → " + t1.compareTo(t2));
        System.out.println("00:59:59 vs 01:00:00 → " + t2.compareTo(t1));
        System.out.println("01:00:00 vs 01:00:00 → " + t1.compareTo(new Time(1, 0, 0)));

        Chocolate[] chocs = {
                new Chocolate("Twix",     58.0),
                new Chocolate("Snickers", 50.0),
                new Chocolate("KitKat",   45.0),
                new Chocolate("Bounty",   57.0),
                new Chocolate("Mars",     51.0)
        };
        Sort.bubbleSort(chocs);
        System.out.println("\nSorted chocolates:");
        for (Chocolate c : chocs) System.out.println(c);

        Time[] times = {
                new Time(14, 30,  0),
                new Time( 9,  5, 45),
                new Time(23, 59, 59),
                new Time( 0,  0,  1),
                new Time( 7, 15, 30)
        };
        Sort.bubbleSort(times);
        System.out.println("\nSorted times:");
        for (Time t : times) System.out.println(t);
    }
}