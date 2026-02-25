package fi.haagahelia.backend.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(@Param("title") String title);
}
