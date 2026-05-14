package project.models.user;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {
    public static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private boolean authenticated;

    public User(String id, String username, String password, String fullName, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.authenticated = false;
    }

    public boolean authenticate(String username, String password) {
        if (this.username != null && this.username.equals(username) &&
                this.password != null && this.password.equals(password)) {
            authenticated = true;
            return true;
        }
        return false;
    }

    public void logout() { authenticated = false; }
    public boolean isAuthenticated() { return authenticated; }
    public abstract String getRole();

    public String getId() { return id; }
    public  String getUsername() { return username; }
    public  String getFullName() { return fullName; }
    public String getEmail() { return email; }

    @Override
    public int hashCode() { return Objects.hash(id, username); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public String toString() {
        return getRole() + "{id='" + id + "', username='" + username + "'}";
    }


}