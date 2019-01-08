package se.jasmin.bookapp.service;

import se.jasmin.bookapp.api.dto.CategoryDto;
import se.jasmin.bookapp.repository.entity.Category;

public interface CategoryService {

    Category saveCategory(CategoryDto category);
}

