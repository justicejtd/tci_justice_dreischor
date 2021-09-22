import java.util.*;

public class Chapter {
    private final String name;
    private final int number;
    private final Chapter parent;
    private final Set<Chapter> chapters = new HashSet<>();

    /**
     * @param name
     * @param number
     * @param parent
     * @should uniquely be identified by name and number
     * @should add parent chapter to the current chapter and vice versa when parent is available
     * @should not allowed duplicate elements in the collection of sub-chapters
     */
    public Chapter(String name, int number, Chapter parent) throws IllegalArgumentException {
        this.name = name;
        this.number = number;
        this.parent = parent;
        // How to test if parent is being invoked on null
        if (parent != null) {
            parent.addSubChapter(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chapter)) return false;
        Chapter chapter = (Chapter) o;
        return number == chapter.number && name.equals(chapter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public Chapter getParent() {
        return parent;
    }

    public Collection<Chapter> getSubChapters() {
        return chapters;
    }

    public void addSubChapter(Chapter subChapter) {
        chapters.add(subChapter);
    }
}
