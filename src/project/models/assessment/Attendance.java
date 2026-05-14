package project.models.assessment;

import project.models.user.Student;

public class Attendance {

    private Student student;
    private ClassSession session;
    private AttType status;

    public Attendance(Student student, ClassSession session, AttType status) {
        this.student = student;
        this.session = session;
        this.status  = status;
    }

    public Student      getStudent() { return student; }
    public ClassSession getSession() { return session; }
    public AttType      getStatus()  { return status; }

    public void setStatus(AttType status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{student='" + student.getUsername()
               + "', session=" + session.getId()
               + ", status=" + status + "}";
    }
}