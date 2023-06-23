package com.example.ung_dung_blog.service.impl;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.repository.CategoryRepository;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findCategoryByFlagDeleteIsFalse();
    }

    @Override
    public void addNewCategory(Category category) {
        category.setDelete(false);
        categoryRepository.save(category);
    }

    @Override
    public Category findByIdAndFlagDeleteIsFalse(Integer id) {
        return categoryRepository.findByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = this.findByIdAndFlagDeleteIsFalse(id);
        category.setDelete(true);
        categoryRepository.save(category);
    }
}
