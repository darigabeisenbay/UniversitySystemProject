package project.models.course;

import project.models.infrastructure.StatusType;
import project.models.user.Student;

public class CourseRegistration {

    private int        id;
    private StatusType status;
    private Student student;
    private Course course;

    public CourseRegistration(int id, Student student, Course course) {
        this.id      = id;
        this.student = student;
        this.course  = course;
        this.status  = StatusType.PENDING;
    }

    public int        getId()      { return id; }
    public StatusType getStatus()  { return status; }
    public Student    getStudent() { return student; }
    public Course     getCourse()  { return course; }
    public void approve() {
        this.status = StatusType.RESOLVED;
        System.out.println("Registration approved: "
                           + student.getUsername() + " → " + course.getName());
    }

    public void reject() {
        this.status = StatusType.REJECTED;
        System.out.println("Registration rejected: "
                           + student.getUsername() + " → " + course.getName());
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CourseRegistration{id=" + id
               + ", student='" + student.getUsername()
               + "', course='" + course.getName()
               + "', status=" + status + "}";
    }
}