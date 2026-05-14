package project.models.user;

import project.models.infrastructure.Database;

import java.util.*;

public class Admin extends Employee {
    private static final long serialVersionUID = 1L;
    public Admin(String id, String username, String password, String fullName,
                 String email, double salary, String department) {
        super(id, username, password, fullName, email, salary, department);
    }
    public void addUser(User user) {
        if (user != null) {
            Database.getInstance().addUser(user);
            System.out.println("User added to system: " + user.getUsername());
        }
    }

    public void removeUser(User user) {
        if (user != null) {
            Database.getInstance().getUsers().remove(user);
            System.out.println("User removed from system: " + user.getUsername());
        }
    }

    public void updateUser(User oldUser, User newUser) {
        List<User> users = Database.getInstance().getUsers();
        int index = users.indexOf(oldUser);
        if (index != -1) {
            users.set(index, newUser);
            System.out.println("User updated: " + newUser.getUsername());
        } else {
            System.out.println("User not found.");
        }
    }

    public void viewLogs() {
        System.out.println("Viewing system logs... (Log history is currently empty)");
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public String toString() {
        return super.toString() + " [Role: System Administrator]";
    }
}