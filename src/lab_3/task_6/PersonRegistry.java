package lab_3.task_6;

import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {

    private final List<Person> people = new ArrayList<>();

    public void addPerson(Person p) {
        people.add(p);
        System.out.println("Registered: " + p.getName());
    }

    public void removePerson(Person p) {
        if (people.remove(p))
            System.out.println("Removed: " + p.getName());
        else
            System.out.println(p.getName() + " not found in registry.");
    }

    public List<Person> getPeopleWithPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people)
            if (p.hasPet()) result.add(p);
        return result;
    }

    public List<Person> getPeopleWithoutPets() {
        List<Person> result = new ArrayList<>();
        for (Person p : people)
            if (!p.hasPet()) result.add(p);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("═══ PersonRegistry (").append(people.size()).append(" people) ═══\n");
        for (Person p : people)
            sb.append("  ").append(p).append('\n');
        return sb.toString();
    }
}