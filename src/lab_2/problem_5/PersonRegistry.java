package lab_2.problem_5;
import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {
    private List<Person> people = new ArrayList<>();

    public void addPerson(Person p) { people.add(p); }

    public void removePerson(Person p) { people.remove(p); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--- Registry Status ---\n");
        for (Person p : people) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}