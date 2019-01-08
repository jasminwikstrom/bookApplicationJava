package se.jasmin.bookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jasmin.bookapp.api.dto.CategoryDto;
import se.jasmin.bookapp.repository.entity.Category;
import se.jasmin.bookapp.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {




    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(CategoryDto categoryDto) {

            if (categoryDto.getText() == null) {
                throw new RuntimeException("add the name of the category");

            }





        var category = new Category();
            category.setText(categoryDto.getText());

        return categoryRepository.save(category);


    }






}
