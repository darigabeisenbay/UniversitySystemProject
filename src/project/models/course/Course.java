package project.models.course;

import project.models.assessment.ClassSession;
import project.models.infrastructure.Database;
import project.models.user.Student;
import project.models.user.Teacher;
import project.models.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {

    private int    id;
    private String name;
    private int    credits;

    private List<ClassSession> sessions;
    private List<Teacher> teachers;

    public Course(int id, String name, int credits) {
        this.id       = id;
        this.name     = name;
        this.credits  = credits;
        this.sessions = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public int    getId()      { return id; }
    public String getName()    { return name; }
    public int    getCredits() { return credits; }
    public List<ClassSession> getSessions() { return sessions; }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addSession(ClassSession session) {
        if (!sessions.contains(session)) {
            sessions.add(session);
        }
    }

    public void addTeacher(Teacher teacher) {
        if (teacher != null && !teachers.contains(teacher)) {
            teachers.add(teacher);
            System.out.println("Teacher " + teacher.getName() + " was added to course " + this.name);
        } else if (teacher != null) {
            System.out.println("Teacher already has this subject");
        }
    }

    public List<Student> getStudents() {
        List<Student> enrolledStudents = new ArrayList<>();
        for (User user : Database.getInstance().getUsers()) {
            if (user instanceof Student student) { // Pattern matching (Java 16+)
                boolean isEnrolled = student.getRegisteredCourses().stream()
                        .anyMatch(c -> c.getId() == this.id);
                if (isEnrolled) {
                    enrolledStudents.add(student);
                }
            }
        }
        return enrolledStudents;
    }

    public void printSessions() {
        System.out.println("Course lessons \"" + name + "\":");
        if (sessions.isEmpty()) {
            System.out.println("  (no lessons)");
        }
        for (ClassSession s : sessions) {
            System.out.println("  " + s);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{id=" + id + ", name='" + name + "', credits=" + credits + "}";
    }
}