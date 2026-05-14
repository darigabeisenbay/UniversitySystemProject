package project.models.course;

import project.models.infrastructure.Room;
import project.models.user.Teacher;

import java.time.LocalTime;
import java.util.Objects;


public class Lesson {
    private String lessonId;
    private Course course;
    private Teacher teacher;
    private LessonType type;
    private Room room;
    private String dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public Lesson(String lessonId, Course course, Teacher teacher, LessonType type, 
                  Room room, String dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.lessonId = lessonId;
        this.course = course;
        this.teacher = teacher;
        this.type = type;
        this.room = room;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }



    public String getLessonId() { return lessonId; }
    
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public LessonType getType() { return type; }
    
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }

    public String getDayOfWeek() { return dayOfWeek; }
    
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }


    public boolean conflictsWith(Lesson other) {
        if (!this.dayOfWeek.equals(other.dayOfWeek)) return false;
        return (this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime));
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | %s | %s %s-%s | Room: %d",
                lessonId, 
                course.getName(), 
                type, 
                teacher.getUsername(),
                dayOfWeek, 
                startTime, 
                endTime, 
                room.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(lessonId, lesson.lessonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessonId);
    }
}