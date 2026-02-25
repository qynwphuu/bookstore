package fi.haagahelia.backend.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import fi.haagahelia.backend.bookstore.domain.Book;
import fi.haagahelia.backend.bookstore.domain.BookRepository;

@RestController

public class BookRestController {
    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/{id}")
    public List<Book> bookListRest() {
        return bookRepository.findAll();
    }
}
