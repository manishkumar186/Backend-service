package com.example.Medilife_backend.Category.Service;

import com.example.Medilife_backend.Category.Entity.Category;
import com.example.Medilife_backend.Category.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;


    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }


    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }
}
