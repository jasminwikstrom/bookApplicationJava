package se.jasmin.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jasmin.bookapp.repository.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
