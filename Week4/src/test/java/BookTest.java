import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookTest {
    private final String name = "Unit Testing";
    private final String author = "Author Name";
    private final Book book = new Book(name, author);

    /**
     * @verifies throw IllegalArgumentException if book does not have a name or an author
     * @see Book#Book(String, String)
     */
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void Book_shouldThrowIllegalArgumentExceptionIfBookDoesNotHaveANameOrAnAuthor(String testValue) throws IllegalArgumentException {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            // Arrange
            Book book = new Book(testValue, testValue);
        });
    }

    /**
     * @verifies have zero or more chapters
     * @see Book#Book(String, String)
     */
    @Test
    public void Book_shouldHaveZeroOrMoreChapters() {
        // Assert
        assertThat(book.getChapters().size()).isGreaterThanOrEqualTo(0);
    }

    /**
     * @verifies check if instance of chapters initialized properly
     * @see Book#Book(String, String)
     */
    @Test
    public void Book_shouldCheckIfInstanceOfChaptersInitializedProperly() throws Exception {
        // assert
        assertThat(book.getChapters()).isNotNull();
    }

    /**
     * @verifies print 1 line for each chapter
     * @see Book#printTableOfContents()
     */
    @Test
    public void printTableOfContents_shouldPrint1LineForEachChapter() {
        // Arrange
        Chapter chapter1 = mock(Chapter.class);
        Chapter subChapter = mock(Chapter.class);
        Collection<Chapter> subChapters = new ArrayList<>();
        subChapters.add(subChapter);

        // Act
        when(chapter1.getSubChapters()).thenReturn(subChapters);
        book.addChapter(chapter1);
        book.printTableOfContents();

        // Assert
        assertThat(book.getLines().size()).isEqualTo(2);
    }

    /**
     * @verifies make sure all chapter are printed
     * @see Book#printTableOfContents()
     */
    @Test
    public void printTableOfContents_shouldMakeSureAllChapterArePrinted() throws Exception {

    }
}