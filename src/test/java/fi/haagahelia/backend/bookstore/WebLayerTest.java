package fi.haagahelia.backend.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fi.haagahelia.backend.bookstore.domain.BookRepository;
import fi.haagahelia.backend.bookstore.domain.CategoryRepository;
import fi.haagahelia.backend.bookstore.domain.UserRepository;
import fi.haagahelia.backend.bookstore.web.BookController;

@WebMvcTest(BookController.class)
public class WebLayerTest {
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
    public void getBooksReturnsOK() throws Exception {
        this.mockMvc.perform(get("/booklist")).andExpect(status().isOk());
    }
}
