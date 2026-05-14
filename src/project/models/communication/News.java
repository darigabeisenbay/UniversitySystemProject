package project.models.communication;

import project.models.infrastructure.Database;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String content;
    private LocalDateTime publishDate;
    private boolean isPinned;

    public News(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishDate = LocalDateTime.now();
        this.isPinned = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    
    @Override
    public String toString() {
        String pinnedStatus = isPinned ? "[Pinned] " : "";
        return String.format("%s%s (%s)\n%s\n", 
            pinnedStatus, title, publishDate, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void publish() {
        this.publishDate = LocalDateTime.now();
        Database db = Database.getInstance();
        db.addNews(this);
        System.out.println("News \"" + title + "\" has been published to the system.");
    }
}