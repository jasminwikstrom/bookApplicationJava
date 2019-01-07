package se.jasmin.bookapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import se.jasmin.bookapp.modelEntity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}






