package project.models.communication;

import project.models.user.Student;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;

    private int score;
    private String comment;
    private Student student;
    private LocalDateTime date;

    public Rating(int score, String comment, Student student) {
        if (score < 1 || score > 5) {
            throw new IllegalArgumentException("The range is between 1 to 5");
        }
        this.score = score;
        this.comment = comment;
        this.student = student;
        this.date = LocalDateTime.now();
    }
    public int getScore() { return score; }
    public String getComment() { return comment; }
    public Student getStudent() { return student; }
    public LocalDateTime getDate() { return date; }

    @Override
    public String toString() {
        return "Rating{" +
                "score=" + score +
                ", student=" + (student != null ? student.getUsername() : "Anonymous") +
                ", comment='" + comment + '\'' +
                '}';
    }
}