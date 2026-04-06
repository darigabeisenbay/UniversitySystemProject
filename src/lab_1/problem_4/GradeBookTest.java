package lab_1.problem_4;

import practice_2.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeBookTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GradeBook gradebook = new GradeBook();
        Course course = new Course("CS101", "computer engineering", 5, "ADS");

        Student A = new Student("A", "1");
        Student B = new Student("B", "2");
        Student C = new Student("C", "3");
        Student D = new Student("D", "4");
        Student E = new Student("E", "5");
        Student F = new Student("F", "6");
        Student G = new Student("G", "7");
        Student H = new Student("H", "8");
        Student I = new Student("I", "9");
        Student J = new Student("J", "10");

        gradebook.displayMessage();

        List <Student> students = new ArrayList<>();
        students.add(A);
        students.add(B);
        students.add(C);
        students.add(D);
        students.add(E);
        students.add(F);
        students.add(G);
        students.add(H);
        students.add(I);
        students.add(J);

        List<Integer> grades = new ArrayList<>();
        char a = 'A';
        for (int i = 0; i < students.size(); i++) {
            System.out.print("Student " + (char)(a + i) + ": ");
            grades.add(sc.nextInt());
        }

        gradebook.setCourse(course);
        gradebook.setStudents(students);
        gradebook.setGrades(grades);

        gradebook.displayGradeReport();



    }
}
