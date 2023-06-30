package com.example.tich_hop_restful.service.impl;

import com.example.tich_hop_restful.model.Category;
import com.example.tich_hop_restful.repository.ICategoryRepository;
import com.example.tich_hop_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.getCategoryByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.getCategoryByIdAndFlagDeleteIsFalse(id);
        category.setFlagDelete(true);
        categoryRepository.save(category);
    }
}
