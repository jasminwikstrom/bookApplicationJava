package se.jasmin.bookapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.jasmin.bookapp.repository.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}






