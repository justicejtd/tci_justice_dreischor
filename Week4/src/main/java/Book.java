import java.util.ArrayList;

public class Book {
    private String name;
    private String author;
    private ArrayList<Chapter> chapters = new ArrayList<>();

    /**
     * @should throw IllegalArgumentException if book does not have a name or an author
     * @should check if instance of chapters initialized properly
     * @should have zero or more chapters
     */
    public Book(String name, String author) {
        if (name.isBlank() || author.isBlank()) {
            throw new IllegalArgumentException("Book must have a name and author!");
        }
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }
}
