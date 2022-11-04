package com.softuni.bookshop.services.category;

import com.softuni.bookshop.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories(List<Category> categories);

    Set<Category> getRandomCategory();
}
