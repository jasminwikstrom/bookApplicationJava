package se.jasmin.bookapp.service;

import se.jasmin.bookapp.model.CategoryDto;
import se.jasmin.bookapp.modelEntity.Category;

public interface CategoryService {

    Category saveCategory(CategoryDto category);
}

