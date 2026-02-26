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
	CommandLineRunner initCategories(CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Science Fiction"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("History"));
		};
	}

	@Bean
	public CommandLineRunner initUsers(UserRepository repository) {
		return args -> {
			User user1 = new User("user", "$2a$12$j/SgoiwjvY2ssbp5G/PbnuAamMAqGrc4hriMxvpFqjsyA77aFnXAe", "USER");
			// pass is "password"
			User user2 = new User("admin", "$2a$12$loeJmqaj30YeodKSDhiAHuGfBRhGuIouZPUvg0IjxHKnP765KArTa", "ADMIN");
			// pass is "admin"
			repository.save(user1);
			repository.save(user2);
		};
	}

}
