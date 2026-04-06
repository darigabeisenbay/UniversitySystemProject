package lab_3.task_6;

public class Main {

    private static void section(String title) {
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("  " + title);
        System.out.println("══════════════════════════════════════════════════");
    }

    public static void main(String[] args) {

        section("Sample Interaction from assignment");

        Person john  = new Employee("John", 30, "Engineer");
        Person alice = new PhDStudent("Alice", 26, "Comp. Science");
        Animal murka = new Cat("Murka", 5);

        john.assignPet(murka);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);

        System.out.println("\n--- John goes on vacation and leaves Murka with Alice ---");
        john.leavePetWith(alice);

        System.out.println("\nRegistry reflects that Alice is taking care of Murka:");
        System.out.println(registry);

        System.out.println("--- John returns and retrieves Murka ---");
        john.retrievePetFrom(alice);

        System.out.println("\nRegistry reflects that John has his cat back:");
        System.out.println(registry);

        section("PhDStudent Dog restriction");

        Person bob = new Employee("Bob", 35, "Manager");
        Animal rex = new Dog("Rex", 3);
        bob.assignPet(rex);

        System.out.println("\nBob tries to leave Rex with Alice (PhDStudent):");
        bob.leavePetWith(alice);
        bob.assignPet(rex);

        section("Animal sounds (getSound)");

        Animal[] animals = {
            new Cat("Whiskers", 2),
            new Dog("Buddy",    4),
            new Fish("Nemo",    1),
            new Bird("Tweety",  3)
        };
        for (Animal a : animals)
            System.out.println(a.getName() + " says: " + a.getSound());

        section("Animal Comparable – sort by age");

        java.util.Arrays.sort(animals);
        for (Animal a : animals)
            System.out.println(a);

        section("Animal clone");

        Animal original = new Cat("Luna", 3);
        Animal cloned   = original.clone();
        System.out.println("Original : " + original);
        System.out.println("Cloned   : " + cloned);
        System.out.println("equals   : " + original.equals(cloned));
        System.out.println("same ref : " + (original == cloned));

        section("Person Comparable – sort by age");

        Person[] people = {
            new Employee("Zara",  40, "Director"),
            new Student("Tim",    19, "Physics"),
            new PhDStudent("Eva", 28, "Biology")
        };
        java.util.Arrays.sort(people);
        for (Person p : people)
            System.out.println(p.getName() + " (age " + p.getAge() + ")");

        section("Person clone (deep – pet is also cloned)");

        Animal bird   = new Bird("Kiwi", 2);
        Person student = new Student("Sam", 22, "Art");
        student.assignPet(bird);

        Person studentClone = student.clone();
        System.out.println("Original : " + student);
        System.out.println("Cloned   : " + studentClone);
        System.out.println("Pet same ref? " + (student.getPet() == studentClone.getPet()));

        section("Registry – with/without pets");

        PersonRegistry reg2 = new PersonRegistry();
        reg2.addPerson(john);
        reg2.addPerson(alice);
        reg2.addPerson(bob);
        reg2.addPerson(student);

        System.out.println("\nPeople WITH pets:");
        reg2.getPeopleWithPets().forEach(p -> System.out.println("  " + p.getName()));

        System.out.println("People WITHOUT pets:");
        reg2.getPeopleWithoutPets().forEach(p -> System.out.println("  " + p.getName()));

        section("equals & hashCode");

        Person john2 = new Employee("John", 30, "Engineer");
        System.out.println("john.equals(john2)  → " + john.equals(john2));
        System.out.println("john.equals(alice)  → " + john.equals(alice));
        System.out.println("Same hashCode?      → " + (john.hashCode() == john2.hashCode()));

        section("Vacation edge cases");

        Person noPet = new Student("Leo", 20, "Music");
        System.out.print("Leo (no pet) tries to leave a pet: ");
        noPet.leavePetWith(alice);

        System.out.print("Alice (no pet) retrieved from Leo: ");
        alice.retrievePetFrom(noPet);
    }
}