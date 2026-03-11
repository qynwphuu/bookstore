package fi.haagahelia.backend.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import java.util.List;
import fi.haagahelia.backend.bookstore.domain.Book;
import fi.haagahelia.backend.bookstore.domain.BookRepository;
import fi.haagahelia.backend.bookstore.domain.CategoryRepository;
import fi.haagahelia.backend.bookstore.domain.UserRepository;
import fi.haagahelia.backend.bookstore.web.BookRestController;

@WebMvcTest(BookRestController.class)
class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookRepository bookRepository;

    @MockitoBean
    private CategoryRepository categoryRepository;

    @MockitoBean
    private UserRepository userRepository;

    @Test
    @WithMockUser
    void getAllBooksReturnsJson() throws Exception {
        when(bookRepository.findAll())
                .thenReturn(List.of(new Book("Test", "Author", 2020, "1234567890", 9.99)));

        this.mockMvc.perform(get("/books/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(
                        "[{'title':'Test','author':'Author','publicationYear':2020,'isbn':'1234567890','price':9.99}]"));
    }
}
