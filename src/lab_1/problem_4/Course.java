package lab_1.problem_4;

public class Course {
    private String name;
    private String description;
    private int numberOfCredits;
    private String prerequisite;

    public Course() {
    }

    public Course(String name, String description, int numberOfCredits, String prerequisite) {
        this.name = name;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
        this.prerequisite = prerequisite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", prerequisite='" + prerequisite + '\'' +
                '}';
    }

}
