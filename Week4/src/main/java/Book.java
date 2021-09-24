import java.util.ArrayList;
import java.util.Collection;

/*
A table of contents (TOC) of a book can be created, which prints 1 line per chapter:
The line consists of the chapter id and chapter name. A chapter id are the chapter numbers of all parent chapters of a chapter,
 and the chapter number itself, separated by a '. ' .
 For instance:  chapter 3 "ch3 title", which is a subchapter of chapter 1 "the beginning", and chapter 1 is a chapter in the book,
 gets a line in the TOC like:                                      1.3 "ch3 title"
 */
public class Book {
    private String name;
    private String author;
    private final ArrayList<Chapter> chapters = new ArrayList<>();
    private final Collection<String> lines = new ArrayList<>();

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

    /**
     * @should print 1 line for each chapter
     * @should print chapter id and name for each line
     * @should print id which are the chapter numbers of all parent chapters of a chapter and the chapter number itself is seperated by a '. '
     */
    public void printTableOfContents() {
        for (Chapter chapter: chapters) {
            lines.add(chapter.getNumber() + ". " + chapter.getName());
            if (chapter.getSubChapters().size() > 0) {
                for (Chapter subChapter: chapter.getSubChapters()) {
                    lines.add(chapter.getNumber() + "." + subChapter.getNumber() + " " + subChapter.getName());
                    if (subChapter.getSubChapters().size() > 0) {
                        printTableOfContents();
                    }
                }
            }
        }
    }

    /**
     * @should add a new chapter properly
     * @param chapter
     */
    public void addChapter(Chapter chapter) {
        getChapters().add(chapter);
    }

    public Collection<String> getLines() {
        return lines;
    }
}
