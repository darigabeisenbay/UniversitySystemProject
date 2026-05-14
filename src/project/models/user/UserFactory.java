package project.models.user;


import project.models.infrastructure.TeacherTitle;

public class UserFactory {
    public static User createUser(String type, int id, String username, String password, String name, String email) {
        if (type.equalsIgnoreCase("STUDENT")) {
            return new Student(id, username, password, name, email, 0.0, 1, 0);
        } else if (type.equalsIgnoreCase("TEACHER")) {
            return new Teacher(id, username, password, name, email, 200000.0, "FIT", TeacherTitle.TUTOR);
        }
        return null;
    }
}