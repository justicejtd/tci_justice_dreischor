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
        // Arrange
        Chapter chapter1 = mock(Chapter.class);
        Chapter subChapter = mock(Chapter.class);
        Collection<Chapter> subChapters = new ArrayList<>();
        subChapters.add(subChapter);

        // Act
        when(chapter1.getSubChapters()).thenReturn(subChapters);
        when(chapter1.getName()).thenReturn("chapter1");
        when(chapter1.getNumber()).thenReturn(1);
        when(subChapter.getName()).thenReturn("chapter2");
        when(subChapter.getNumber()).thenReturn(2);
        book.addChapter(chapter1);
        book.printTableOfContents();

        // Assert
        assertThat(book.getLines()).contains("chapter1").contains("chapter2");
    }

    /**
     * @verifies print id which are the chapter numbers of all parent chapters of a chapter and the chapter number itself is seperated by a '. '
     * @see Book#printTableOfContents()
     */
    @Test
    public void printTableOfContents_shouldPrintIdWhichAreTheChapterNumbersOfAllParentChaptersOfAChapterAndTheChapterNumberItselfIsSeperatedByA() {
        // Arrange
        String expectedPrint1 = "1. Chapter1";
        String expectedPrint2 = "1.2 Chapter2";
        String expectedPrint3 = "1.2.3 Chapter3";
        Chapter chapter1 = mock(Chapter.class);
        Chapter subChapter = mock(Chapter.class);
        Chapter subChapter2 = mock(Chapter.class);
        Collection<Chapter> subChapters = new ArrayList<>();
        subChapters.add(subChapter);
        Collection<Chapter> subChapters2 = new ArrayList<>();
        subChapters.add(subChapter2);

        // Act
        when(chapter1.getSubChapters()).thenReturn(subChapters);
        when(subChapter2.getSubChapters()).thenReturn(subChapters2);
        when(chapter1.getName()).thenReturn("Chapter1");
        when(chapter1.getNumber()).thenReturn(1);
        when(subChapter.getName()).thenReturn("Chapter2");
        when(subChapter.getNumber()).thenReturn(2);
        when(subChapter2.getName()).thenReturn("Chapter3");
        when(subChapter2.getNumber()).thenReturn(3);
        book.addChapter(chapter1);
        book.printTableOfContents();

        // Assert
        assertThat(book.getLines()).contains(expectedPrint1).contains(expectedPrint2).contains(expectedPrint3);
    }
}