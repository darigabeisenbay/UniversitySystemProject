package lab_2.problem_1.part_b;

public class TestClass {
    public static void main(String[] args) {
        LibraryItem libraryitem = new Book("The Hobbit", "Tolkin", 1989, 328,"hardcover","physical");
        System.out.println(libraryitem.getPublicationYear());
        System.out.println(libraryitem.getAuthor());
        System.out.println(libraryitem.getTitle());

    }
}
