package project.models.user;

import project.models.assessment.AttType;
import project.models.assessment.ClassSession;
import project.models.assessment.Mark;
import project.models.communication.Rating;
import project.models.course.Course;
import project.models.infrastructure.TeacherTitle;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee {
    private static final long serialVersionUID = 1L;
    private String name;
    private TeacherTitle title;
    private List<Course> courses = new ArrayList<>();
    private List<Rating> ratings = new ArrayList<>();

    public Teacher(int id, String username, String password, String name,
                   String email, double salary, String department, TeacherTitle title) {
        super(String.valueOf(id), username, password, name, email, salary, department);
        this.name = name;
        this.title = title;
    }

    @Override
    public String getRole() { return "Teacher"; }

    public String getName()            { return name; }
    public TeacherTitle getTitle()     { return title; }
    public List<Rating> getRatings()   { return ratings; }
    public List<Course> getCourses()   { return courses; }

    public Mark putMark(Student student, Course course,
                        double att1, double att2, double finalExam) {
        Mark mark = new Mark((int)(Math.random() * 10000), course, student);
        mark.setAtt1(att1);
        mark.setAtt2(att2);
        mark.setFinalExam(finalExam);
        student.addMark(mark);
        System.out.println(" Mark was published: " + mark);
        return mark;
    }

    public void markAttendance(ClassSession session, Student student, AttType status) {
        session.markAttendance(student, status);
    }

    public void viewStudents(Course course) {
        System.out.println("Студенты курса \"" + course.getName() + "\" — " + name);
        List<ClassSession> sessions = course.getSessions();
        if (sessions.isEmpty()) {
            System.out.println("  (нет занятий)");
            return;
        }
        sessions.get(0).printAttendance();
    }

    public void viewSchedule(ClassSession session) {
        System.out.println("Lesson: " + session);
    }

    public void viewAttendance(ClassSession session) {
        session.printAttendance();
    }

    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
            System.out.println("Course " + course.getName() + " successfully added to " + getUsername());
        } else {
            System.out.println("Course cannot be added or already exists.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", title=" + title + ", name='" + name + "'";
    }
}