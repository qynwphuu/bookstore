package fi.haagahelia.backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.backend.bookstore.domain.Book;
import fi.haagahelia.backend.bookstore.domain.BookRepository;
import fi.haagahelia.backend.bookstore.domain.Category;
import fi.haagahelia.backend.bookstore.domain.CategoryRepository;
import fi.haagahelia.backend.bookstore.domain.User;
import fi.haagahelia.backend.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(BookRepository repository, CategoryRepository crepository) {
		return args -> {
			Category history = crepository.findByName("History").stream().findFirst().orElse(null);
			if (history == null) {
				history = crepository.save(new Category("History"));
			}

			if (repository.findByIsbn("1232323-21").isEmpty()) {
				Book firstBook = new Book(
						"A Farewell to Arms",
						"Ernest Hemingway",
						1929,
						"1232323-21",
						19.99);
				firstBook.setCategory(history);
				repository.save(firstBook);
			}

			if (repository.findByIsbn("2212343-5").isEmpty()) {
				Book secondBook = new Book(
						"Animal Farm",
						"George Orwell",
						1945,
						"2212343-5",
						29.99);
				secondBook.setCategory(history);
				repository.save(secondBook);
			}
		};
	}

	@Bean
	CommandLineRunner initCategories(CategoryRepository crepository) {
		return (args) -> {
			if (crepository.findByName("Science Fiction").isEmpty()) {
				crepository.save(new Category("Science Fiction"));
			}
			if (crepository.findByName("Fantasy").isEmpty()) {
				crepository.save(new Category("Fantasy"));
			}
			if (crepository.findByName("History").isEmpty()) {
				crepository.save(new Category("History"));
			}
		};
	}

	@Bean
	public CommandLineRunner initUsers(UserRepository repository) {
		return args -> {
			if (repository.findByUsername("user") == null) {
				User user1 = new User("user", "user@example.com",
						"$2a$12$j/SgoiwjvY2ssbp5G/PbnuAamMAqGrc4hriMxvpFqjsyA77aFnXAe", "USER");
				// pass is "password"
				repository.save(user1);
			}

			if (repository.findByUsername("admin") == null) {
				User user2 = new User("admin", "admin@example.com",
						"$2a$12$loeJmqaj30YeodKSDhiAHuGfBRhGuIouZPUvg0IjxHKnP765KArTa", "ADMIN");
				// pass is "admin"
				repository.save(user2);
			}
		};
	}

}
