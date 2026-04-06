package lab_2.problem_5;

public class TestProgram {
    public static void main(String[] args) {
        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science", "AI");

        Animal murka = new Cat(5, "Murka");
        Animal rex = new Dog(3, "Rex");

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);

        System.out.println("--- Initial State ---");
        john.assignPet(murka);
        System.out.println(registry);

        System.out.println("--- PhD Restriction Test ---");
        alice.assignPet(rex);

        System.out.println("\n--- Vacation Start ---");
        john.leavePetWith(alice);

        System.out.println("\n" + registry);

        System.out.println("--- Vacation End ---");
        john.retrievePetFrom(alice);

        System.out.println("\n" + registry);

        System.out.print("Murka says: ");
        murka.getSound();
    }
}