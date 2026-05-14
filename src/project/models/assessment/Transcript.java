package project.models.assessment;

import project.models.assessment.Mark;
import project.models.user.Student;

import java.util.ArrayList;
import java.util.List;

public class Transcript {

    private Student student;
    private double     gpa;
    private List<Mark> marks;

    public Transcript(Student student) {
        this.student = student;
        this.marks   = new ArrayList<>();
        this.gpa     = 0.0;
    }

    public Student    getStudent() { return student; }
    public double     getGpa()     { return gpa; }
    public List<Mark> getMarks()   { return marks; }

    public void addMark(Mark mark) {
        marks.add(mark);
        calculateGPA();
    }
    public void calculateGPA() {
        if (marks.isEmpty()) {
            this.gpa = 0.0;
            return;
        }
        double sum = 0;
        for (Mark m : marks) {
            sum += m.getTotal();
        }
        double avg = sum / marks.size();
        this.gpa = (avg / 100.0) * 4.0;
    }
    public void print() {
        System.out.println("\n══ Transcript: " + student.getUsername() + " ══");
        for (Mark m : marks) {
            System.out.printf("  %-30s | att1=%.1f | att2=%.1f | exam=%.1f | total=%.1f (%s)%n",
                m.getCourse().getName(),
                m.getAtt1(), m.getAtt2(), m.getFinalExam(),
                m.getTotal(), m.getLetterGrade());
        }
        System.out.printf("  GPA: %.2f%n", gpa);
    }
}