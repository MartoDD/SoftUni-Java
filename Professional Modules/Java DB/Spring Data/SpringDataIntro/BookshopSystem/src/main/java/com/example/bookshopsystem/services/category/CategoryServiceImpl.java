package com.example.bookshopsystem.services.category;

import com.example.bookshopsystem.entities.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(List<Category> categories) {

        this.categoryRepository.saveAll(categories);

    }

    @Override
    public Set<Category> getRandomCategory() {
        Set<Category> categories=new HashSet<>();
        Random random = new Random();

      //  int randomNumber=random.nextInt(0,(int)this.categoryRepository.count())+1;

        categories.add(categoryRepository.findById(2).orElse(null));
        return categories;
    }
}
