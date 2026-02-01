package fi.haagahelia.backend.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fi.haagahelia.backend.bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    List<Book> books = new ArrayList<>();

    @GetMapping({ "/", "/index" })
    public String index(Model model) {
        if (books.isEmpty()) { // avoid adding duplicates on each request
            books.add(new Book("Book 1", "Author A", 2020, "123456", 19.99));
            books.add(new Book("Book 2", "Author B", 2021, "987654", 29.99));
        }
        model.addAttribute("books", books);
        return "index";

    }

    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
    private final fi.haagahelia.backend.bookstore.domain.BookRepository bookRepository;
    public BookController(fi.haagahelia.backend.bookstore.domain.BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
}
