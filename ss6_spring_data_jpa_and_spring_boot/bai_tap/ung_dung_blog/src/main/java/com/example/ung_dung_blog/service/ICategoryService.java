package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();
    void addNewCategory(Category category);
    Category findByIdAndFlagDeleteIsFalse(Integer id);
    void save(Category category);
    void deleteCategory(Integer id);
}
