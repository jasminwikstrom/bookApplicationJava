package se.jasmin.bookapp.repository;

import se.jasmin.bookapp.modelEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
