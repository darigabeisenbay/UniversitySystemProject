package lab_3.task_4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Date d2018 = new GregorianCalendar(2018, Calendar.MARCH,  15).getTime();
        Date d2020 = new GregorianCalendar(2020, Calendar.JUNE,   1).getTime();
        Date d2015 = new GregorianCalendar(2015, Calendar.JANUARY, 7).getTime();
        Date d2022 = new GregorianCalendar(2022, Calendar.NOVEMBER,20).getTime();


        Employee alice = new Employee("Alice", 55_000, d2018, "NI-111");
        Employee bob   = new Employee("Bob",   72_000, d2020, "NI-222");
        Employee carol = new Employee("Carol", 48_000, d2015, "NI-333");
        Employee dave  = new Employee("Dave",  72_000, d2022, "NI-444");

        System.out.println(alice);
        System.out.println(bob);
        System.out.println(carol);
        System.out.println(dave);


        Employee aliceCopy = new Employee("Alice", 55_000, d2018, "NI-111");
        System.out.println("alice.equals(aliceCopy) → " + alice.equals(aliceCopy)); // true
        System.out.println("alice.equals(bob)       → " + alice.equals(bob));       // false
        System.out.println("alice hashCode == copy? → " + (alice.hashCode() == aliceCopy.hashCode())); // true


        System.out.println("alice vs bob   (55k vs 72k): " + alice.compareTo(bob));   // negative
        System.out.println("bob   vs alice (72k vs 55k): " + bob.compareTo(alice));   // positive
        System.out.println("bob   vs dave  (72k vs 72k): " + bob.compareTo(dave));    // zero


        Manager mgr1 = new Manager("Eve",   90_000, d2015, "NI-555", 15_000);
        Manager mgr2 = new Manager("Frank", 90_000, d2020, "NI-666", 20_000);
        Manager mgr1Copy = new Manager("Eve", 90_000, d2015, "NI-555", 15_000);

        mgr1.addTeamMember(alice);
        mgr1.addTeamMember(carol);
        mgr2.addTeamMember(bob);
        mgr2.addTeamMember(dave);

        System.out.println(mgr1);
        System.out.println(mgr2);
        System.out.println("mgr1.equals(mgr1Copy) → " + mgr1.equals(mgr1Copy));
        System.out.println("mgr1.equals(mgr2)     → " + mgr1.equals(mgr2));


        System.out.println("mgr2 vs mgr1 (same salary, bonus 20k vs 15k): " + mgr2.compareTo(mgr1));
        System.out.println("mgr1 vs mgr2 (same salary, bonus 15k vs 20k): " + mgr1.compareTo(mgr2));

        Employee highPaid = new Employee("Zara", 90_000, d2022, "NI-999");
        System.out.println("mgr1 vs highPaid (same salary, no bonus):     " + mgr1.compareTo(highPaid));


        List<Employee> byName = new ArrayList<>(Arrays.asList(alice, bob, carol, dave, mgr1, mgr2));
        byName.sort(Employee.BY_NAME);
        byName.forEach(System.out::println);


        List<Employee> byDate = new ArrayList<>(Arrays.asList(alice, bob, carol, dave, mgr1, mgr2));
        byDate.sort(Employee.BY_HIRE_DATE);
        byDate.forEach(System.out::println);


        Employee aliceClone = alice.clone();
        System.out.println("Original : " + alice);
        System.out.println("Clone    : " + aliceClone);
        System.out.println("equals   : " + alice.equals(aliceClone));
        System.out.println("same ref : " + (alice == aliceClone));

        aliceClone.getHireDate().setTime(0L);
        System.out.println("After mutating clone's date:");
        System.out.println("  Original hireDate : " + alice.getHireDate());
        System.out.println("  Clone    hireDate : " + aliceClone.getHireDate());


        Manager mgr1Clone = mgr1.clone();
        System.out.println("Original team size: " + mgr1.getTeam().size());
        System.out.println("Clone    team size: " + mgr1Clone.getTeam().size());

        mgr1Clone.addTeamMember(dave);
        System.out.println("After adding to clone's team:");
        System.out.println("  Original team size: " + mgr1.getTeam().size());
        System.out.println("  Clone    team size: " + mgr1Clone.getTeam().size());


        Employee temp = new Employee("Temp");
        temp.setSalary(60_000);
        temp.setHireDate(d2022);
        temp.setInsuranceNumber("NI-TMP");
        System.out.println("After setters: " + temp);
        System.out.println("getSalary()   : " + temp.getSalary());
        System.out.println("getHireDate() : " + temp.getHireDate());
        System.out.println("getInsurance(): " + temp.getInsuranceNumber());

        Manager tempMgr = new Manager("TempMgr", 100_000);
        tempMgr.setBonus(5_000);
        tempMgr.addTeamMember(temp);
        System.out.println("Manager bonus : " + tempMgr.getBonus());
        System.out.println("Team members  : " + tempMgr.getTeam().size());
        tempMgr.removeTeamMember(temp);
        System.out.println("After remove  : " + tempMgr.getTeam().size());
    }
}