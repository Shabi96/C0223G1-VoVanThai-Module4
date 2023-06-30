package com.example.tich_hop_restful.service;

import com.example.tich_hop_restful.model.Blog;
import com.example.tich_hop_restful.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAll();

    void createCategory(Category category);

    void updateCategory(Category category);

    Category findById(Integer id);

    void deleteCategory(Integer id);

}
