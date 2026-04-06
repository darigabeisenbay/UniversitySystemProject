package lab_1.problem_4;

import practice_2.Student;

import java.util.Collections;
import java.util.List;


public class GradeBook {

    private Course course;
    private List<Student> students;
    private List<Integer> grades;

    public GradeBook() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "GradeBook{" +
                "course=" + course +
                ", students=" + students +
                ", grades=" + grades +
                '}';
    }

    public void displayMessage() {
        System.out.println("Welcome to the grade book for CS101 Object-oriented Programming and Design!\n\n" +
                "Please, input grades for students:");
    }

    public void displayGradeReport() {
        int sum = 0;
        int minIndex = 0, min = 0;
        int maxIndex = 0, max = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
            if (max < grades.get(i)) {
                max = grades.get(i);
                maxIndex = i;
            }
            if (min > grades.get(i)) {
                min = grades.get(i);
                minIndex = i;
            }
        }
        int avg = sum / (grades.size());
        min = Collections.min(grades);
        max = Collections.max(grades);

        System.out.println("Class average is " + avg);
        System.out.println("Lowest grade is " + min + ". " + students.get(minIndex).toString());
        System.out.println("Highest grade is " + max + ". " + students.get(maxIndex).toString());

        printDistribution(grades);
    }

    public static void printDistribution(List<Integer> grades) {
        int[] counts = new int[11];

        for (int grade : grades) {
            if (grade == 100) {
                counts[10]++;
            } else if (grade >= 0 && grade <= 99) {
                counts[grade / 10]++;
            }
        }

        System.out.println("Grades distribution:");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
            printStars(counts[i]);
        }

        System.out.print("100: ");
        printStars(counts[10]);
    }

    private static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}
