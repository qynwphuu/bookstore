package fi.haagahelia.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.backend.bookstore.domain.Book;
import fi.haagahelia.backend.bookstore.domain.BookRepository;
import fi.haagahelia.backend.bookstore.domain.Category;
import fi.haagahelia.backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(BookRepository repository) {
		return args -> {
			repository.save(new Book(
					"A Farewell to Arms",
					"Ernest Hemingway",
					1929,
					"1232323-21",
					19.99));

			repository.save(new Book(
					"Animal Farm",
					"George Orwell",
					1945,
					"2212343-5",
					29.99));
		};
	}

	@Bean
	CommandLineRunner demo(CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("IT"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("History"));
		};
	}

}
