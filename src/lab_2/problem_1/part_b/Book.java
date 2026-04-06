package lab_2.problem_1.part_b;

import java.util.Objects;

public class Book extends LibraryItem {
    private int numberOfPages;
    private String cover;
    private String type;

    public Book(String title, String author, int year, int pages) {
        super(title, author, year);
        this.numberOfPages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(cover, book.cover) && Objects.equals(type, book.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfPages, cover, type);
    }

    public Book(String title, String author, int publicationYear, int numberOfPages, String cover, String type) {
        super(title, author, publicationYear);
        this.numberOfPages = numberOfPages;
        this.cover = cover;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "numberOfPages=" + numberOfPages +
                ", cover='" + cover + '\'' +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
