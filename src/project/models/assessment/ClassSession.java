package project.models.assessment;

import project.models.course.Course;
import project.models.course.LessonType;
import project.models.infrastructure.Room;
import project.models.user.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ClassSession {

    private int         id;
    private LessonType type;
    private Course course;
    private LocalDate   date;
    private LocalTime   startTime;
    private LocalTime   endTime;
    private Room room;

    private List<Attendance> attendanceList;

    public ClassSession(int id, LessonType type, Course course,
                        LocalDate date, LocalTime startTime, LocalTime endTime,
                        Room room) {
        this.id             = id;
        this.type           = type;
        this.course         = course;
        this.date           = date;
        this.startTime      = startTime;
        this.endTime        = endTime;
        this.room           = room;
        this.attendanceList = new ArrayList<Attendance>();
    }


    public int        getId()        { return id; }
    public LessonType getType()      { return type; }
    public Course     getCourse()    { return course; }
    public LocalDate  getDate()      { return date; }
    public LocalTime  getStartTime() { return startTime; }
    public LocalTime  getEndTime()   { return endTime; }
    public Room       getRoom()      { return room; }
    public List<Attendance> getAttendanceList() { return attendanceList; }


    public void markAttendance(Student student, AttType status) {
        for (Attendance a : attendanceList) {
            if (a.getStudent().equals(student)) {
                a.setStatus(status);
                System.out.println("Attendance was renewed: " + student.getUsername()
                                   + " → " + status);
                return;
            }
        }
        attendanceList.add(new Attendance(student, this, status));
        System.out.println("✓ Attendance was marked: " + student.getUsername()
                           + " → " + status);
    }

    public void printAttendance() {
        System.out.println("Attendance — " + this);
        for (Attendance a : attendanceList) {
            System.out.println("  " + a.getStudent().getUsername() + ": " + a.getStatus());
        }
    }

    @Override
    public String toString() {
        return String.format(
            "ClassSession{id=%d, type=%s, course='%s', date=%s, time=%s-%s, room=%s}",
            id, type, course.getName(), date, startTime, endTime, room.getId()
        );
    }
}