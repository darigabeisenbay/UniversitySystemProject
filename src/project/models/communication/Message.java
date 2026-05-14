package project.models.communication;


import project.models.user.Employee;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private Employee sender;
    private Employee receiver;
    private String text;
    private LocalDateTime timestamp;

    public Message(Employee sender, Employee receiver, String text) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.timestamp = LocalDateTime.now();
    }

    public Employee getSender() { return sender; }
    public Employee getReceiver() { return receiver; }
    public String getText() { return text; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return String.format("[%s] From: %s | Message: %s",
                timestamp.toLocalTime(), sender.getFullName(), text);
    }
}
