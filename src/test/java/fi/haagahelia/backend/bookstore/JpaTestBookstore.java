package fi.haagahelia.backend.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import fi.haagahelia.backend.bookstore.domain.BookRepository;
import fi.haagahelia.backend.bookstore.domain.Book;

@DataJpaTest
public class JpaTestBookstore {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findByTitleShouldReturnBook() {
        bookRepository.save(new Book("Test", "Author", 2020, "1234567890", 19.99));
        List<Book> books = bookRepository.findByTitle("Test");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Author");
    }

    @Test
    public void createNewBook() {
        Book book = new Book("Test", "Author", 2020, "1234567890", 19.99);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        bookRepository.save(new Book("Test", "Author", 2020, "1234567890", 19.99));
        List<Book> books = bookRepository.findByTitle("Test");
        Book book = books.get(0);
        bookRepository.delete(book);
        List<Book> deletedBooks = bookRepository.findByTitle("Test");
        assertThat(deletedBooks).isEmpty();
    }
}
