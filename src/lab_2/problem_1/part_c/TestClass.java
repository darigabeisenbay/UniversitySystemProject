package lab_2.problem_1.part_c;

import java.util.HashSet;

public class TestClass {
    public static void main(String[] args) {
        Store store1 = new Store("Qulpynai", "Sabira" , "Daria");
        Store store2 = new Store("Qulpynai", "Sabira" , "Daria");
        Bakery bakery1 = new Bakery("Qulpynai", "Sabira" , "Daria", "Medovic" , "chocolate cookies");
        Bakery bakery2 = new Bakery("Qulpynai", "Sabira" , "Daria", "Medovic" , "chocolate cookies");
        HashSet<Store> set = new HashSet<>();
        set.add(store1);
        set.add(store2);
        set.add(bakery1);
        set.add(bakery2);
        System.out.println(set);
        set.remove(bakery1);
        Store store3 = new Store("Kulikov" , "Sabira", "Daria");
        set.add(store3);
        System.out.println(set);


    }
}
