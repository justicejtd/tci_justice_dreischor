import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ChapterTest {
    private final String name = "ChapterName";
    private final int number = 1;

    /**
     * @verifies uniquely be identified by name and number
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldUniquelyBeIdentifiedByNameAndNumber() {
        // Arrange
        Chapter chapter1 = new Chapter(name, number, null);
        Chapter chapter2 = new Chapter(name, number, null);

        // Assert
        assertThat(chapter1).isEqualTo(chapter2);
        assertThat(chapter1).hasSameHashCodeAs(chapter2);
    }

    /**
     * @verifies add parent chapter to the current chapter and vice versa when parent is available
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldAddParentChapterToTheCurrentChapterAndViceVersaWhenParentIsAvailable() {
        // Arrange
        Chapter parent = new Chapter(name, number, null);
        Chapter subChapter = new Chapter(name, number, parent);

        // Assert
        assertThat(subChapter.getParent()).isEqualTo(parent);
        assertThat(parent.getSubChapters()).contains(subChapter);
    }

    /**
     * @verifies not allowed duplicate elements in the collection of sub-chapters
     * @see Chapter#Chapter(String, int, Chapter)
     */
    @Test
    public void Chapter_shouldNotAllowedDuplicateElementsInTheCollectionOfSubchapters() {
        // Arrange
        Chapter chapter1 = new Chapter(name, number, null);
        Chapter subChapter1 = new Chapter(name, number, chapter1);
        new Chapter(name, number, chapter1);

        // Act
        assertThat(chapter1.getSubChapters()).containsOnlyOnce(subChapter1);
    }
}
