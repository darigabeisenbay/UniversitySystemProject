package project.models.user;

import project.models.course.Course;
import project.models.course.CourseRegistration;
import project.models.assessment.Mark;
import project.models.assessment.Transcript;
import project.patterns.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User implements Observer {

    private double gpa;
    private int yearOfStudy;
    private int credits;
    private Transcript transcript;
    private List<Course> registeredCourses;
    private List<Mark> marks;
    private Map<Course, Integer> failCounter = new HashMap<>();

    public Student(int id, String username, String password, String fullName, String email,
                   double gpa, int yearOfStudy, int credits) {
        super(String.valueOf(id), username, password, fullName, email);

        this.gpa = gpa;
        this.yearOfStudy = yearOfStudy;
        this.credits = credits;
        this.registeredCourses = new ArrayList<>();
        this.marks = new ArrayList<>();
        this.transcript = new Transcript(this);
    }


    public double      getGpa()         { return gpa; }
    public int         getYearOfStudy() { return yearOfStudy; }
    public int         getCredits()     { return credits; }
    public Transcript  getTranscript()  { return transcript; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }


    public void update(String message) {
        System.out.println("[Notification for " + getUsername() + "]: New News Posted - " + message);
    }
    public void logout() {
        System.out.println(getUsername() + " has quited from system ");
    }

    public CourseRegistration registerCourse(Course course) {
        CourseRegistration reg = new CourseRegistration(
            (int)(Math.random() * 10000), this, course
        );
        System.out.println("Permission to course \"" + course.getName()
                           + "\" sent, status: PENDING");
        return reg;
    }
    public void addMark(Mark mark) {
        marks.add(mark);
        transcript.addMark(mark);
        this.gpa = transcript.getGpa();
        if (mark.getTotalScore() < 50) {
            Course course = mark.getCourse();
            int fails = failCounter.getOrDefault(course, 0) + 1;
            if (fails > 3) {
                System.err.println("CRITICAL: Student " + getUsername() +
                        " has failed the course " + course.getName() + " more than 3 times!");
            }

            failCounter.put(course, fails);
            System.out.println("Warning: Fail count for " + course.getName() + " is now " + fails);
        }
    }
    public int getFailCount(Course course) {
        return failCounter.getOrDefault(course, 0);
    }
    public void viewCourses() {
        System.out.println("Courses " + getUsername()+ ":");
        for (Course c : registeredCourses) {
            System.out.println("  " + c);
        }
    }

    public void viewMarks() {
        System.out.println("Marks " + getUsername() + ":");
        for (Mark m : marks) {
            System.out.println("  " + m);
        }
    }

    public void viewTranscript() {
        transcript.print();
    }

    public Transcript getTranscriptObject() {
        return transcript;
    }

    @Override
    public String toString() {
        return "Student{  username='" + getUsername()
               + "', gpa=" + String.format("%.2f", gpa) + "}";
    }
    @Override
    public String getRole() {
        return "Student";
    }

    public void addCourse(Course course) {
        if (course != null) {
            if (this.credits + course.getCredits() > 21) {
                System.out.println("Credits number exceeded!");
                return;
            }

            if (!registeredCourses.contains(course)) {
                registeredCourses.add(course);
                this.credits += course.getCredits();
            }
        }
    }
}