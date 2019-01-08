package se.jasmin.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.jasmin.bookapp.repository.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value =
            "SELECT b FROM Book b " +
                    "JOIN b.author a " +
                    "JOIN b.category c " +
                    "WHERE (:title IS NULL OR b.title = :title) " +
                    "AND (:author IS NULL OR a.name = :author)")
    List<Book> findByQuery(
            @Param("title") String title,
            @Param("author") String author);
}
