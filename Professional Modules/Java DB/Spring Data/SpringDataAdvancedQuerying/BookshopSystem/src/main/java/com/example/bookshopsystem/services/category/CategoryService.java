package com.example.bookshopsystem.services.category;

import com.example.bookshopsystem.entities.Category;
import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories(List<Category> categories);

    Set<Category> getRandomCategory();
}
