import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

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
}