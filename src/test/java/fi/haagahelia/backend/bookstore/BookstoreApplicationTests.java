package fi.haagahelia.backend.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	private BookstoreApplication application;

	@Test
	public void contextLoads() throws Exception {
		assertThat(application).isNotNull();
	}

}
