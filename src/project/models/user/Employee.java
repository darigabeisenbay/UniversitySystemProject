package project.models.user;

import project.models.communication.Complaint;
import project.models.communication.Message;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends User {
    private static final long serialVersionUID = 1L;

    protected double salary;
    protected String department;
    protected List<Message> messages;
    protected List<Complaint> complaints;

    public Employee(String id, String username, String password, String fullName,
                    String email, double salary, String department) {
        super(id, username, password, fullName, email);
        this.salary = salary;
        this.department = department;
        this.messages = new ArrayList<>();
        this.complaints = new ArrayList<>();
    }
    public void sendMessage(Employee receiver, String text) {
        Message message = new Message(this, receiver, text);
        receiver.receiveMessage(message);
    }

    public void receiveMessage(Message message) {
        messages.add(message);
    }

    public void sendComplaint(String text) {
        complaints.add(new Complaint(this, text));
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", salary=" + salary +
                ", department='" + department + '\'';
    }
}