package project.models.course;

import project.models.assessment.ClassSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<ClassSession> lessons;

    public Schedule() {
        this.lessons = new ArrayList<>();
    }

    public void addLesson(ClassSession session) {
        lessons.add(session);
    }

    public List<ClassSession> getLessons() {
        return lessons;
    }

    public List<ClassSession> getSessionsByCourse(Course course) {
        List<ClassSession> result = new ArrayList<>();
        for (ClassSession s : lessons) {
            if (s.getCourse().getId() == course.getId()) {
                result.add(s);
            }
        }
        return result;
    }
    public List<ClassSession> getSessionsByDate(LocalDate date) {
        List<ClassSession> result = new ArrayList<>();
        for (ClassSession s : lessons) {
            if (s.getDate().equals(date)) {
                result.add(s);
            }
        }
        return result;
    }
    public void printSchedule() {
        System.out.println("\n── Schedule ──");
        if (lessons.isEmpty()) {
            System.out.println("  (no lessons)");
            return;
        }
        for (ClassSession s : lessons) {
            System.out.println("  " + s);
        }
    }
}