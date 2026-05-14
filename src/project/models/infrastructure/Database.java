package project.models.infrastructure;

import project.models.communication.News;
import project.models.course.Course;
import project.models.user.User;
import project.patterns.Observer;

import java.io.*;
import java.util.*;

public class Database implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Database instance;
    private static final String FILE_NAME = "database.ser";

    private List<User> users;
    private List<Course> courses;
    private List<News> news;
    private List<project.patterns.Observer> observers = new ArrayList<>();
    private Database() {
        this.users = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.news = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<News> getNews() {
        return news;
    }
    public void addUser(User user) {
        if (user != null && !users.contains(user)) {
            users.add(user);
        }
    }
    public void addCourse(Course course) {
        if (course != null && !courses.contains(course)) {
            courses.add(course);
        }
    }


    public void subscribe(project.patterns.Observer observer) {
        observers.add(observer);
    }

    public void addNews(News n) {
        if (n != null && !news.contains(n)) {
            news.add(n);
            notifyObservers("Check out our new update: " + n.getTitle());
        }
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    public static void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(instance);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving database: " + e.getMessage());
        }
    }

    private static Database load() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new Database();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Database) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading database, creating new one: " + e.getMessage());
            return new Database();
        }
    }
}