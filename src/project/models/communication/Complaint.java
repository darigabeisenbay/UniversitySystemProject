package project.models.communication;

import project.models.infrastructure.StatusType;
import project.models.user.User;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Complaint implements Serializable {
    private static final long serialVersionUID = 1L;

    private User sender;
    private String text;
    private StatusType status;
    private LocalDateTime timestamp;

    public Complaint(User sender, String text) {
        this.sender = sender;
        this.text = text;
        this.status = StatusType.PENDING;
        this.timestamp = LocalDateTime.now();
    }
    public User getSender() { return sender; }
    public String getText() { return text; }
    public StatusType getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Complaint[Status: %s] from %s: %s",
                status, sender.getFullName(), text);
    }
}