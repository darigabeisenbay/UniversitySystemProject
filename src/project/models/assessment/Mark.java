package project.models.assessment;

import project.models.course.Course;
import project.models.user.Student;

public class Mark {

    private int     id;
    private double  att1;
    private double  att2;
    private double  finalExam;
    private double  total;
    private Course course;
    private Student student;

    public Mark(int id, Course course, Student student) {
        this.id      = id;
        this.course  = course;
        this.student = student;
        this.att1      = 0;
        this.att2      = 0;
        this.finalExam = 0;
        this.total     = 0;
    }

    public Mark(Student student, Course course, double firstAttestation, double secondAttestation, double finalExam) {
    }


    public int    getId()       { return id; }
    public double getAtt1()     { return att1; }
    public double getAtt2()     { return att2; }
    public double getFinalExam(){ return finalExam; }
    public double getTotal()    { return total; }
    public Course  getCourse()  { return course; }
    public Student getStudent() { return student; }

    public void setAtt1(double att1) {
        this.att1 = att1;
        calculateFinal();
    }

    public void setAtt2(double att2) {
        this.att2 = att2;
        calculateFinal();
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
        calculateFinal();
    }

    public void calculateFinal() {
        this.total = att1 * 0.3 + att2 * 0.3 + finalExam * 0.4;
    }

    public String getLetterGrade() {
        if (total >= 95) return "A";
        if (total >= 90) return "A-";
        if (total >= 85) return "B+";
        if (total >= 80) return "B";
        if (total >= 75) return "B-";
        if (total >= 70) return "C+";
        if (total >= 65) return "C";
        if (total >= 60) return "C-";
        if (total >= 55) return "D+";
        if (total >= 50) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return String.format(
            "Mark{course='%s', student='%s', att1=%.1f, att2=%.1f, final=%.1f, total=%.1f (%s)}",
            course.getName(), student.getUsername(),
            att1, att2, finalExam, total, getLetterGrade()
        );
    }

    public int getTotalScore() {
        return (int) Math.round(total);
    }
}