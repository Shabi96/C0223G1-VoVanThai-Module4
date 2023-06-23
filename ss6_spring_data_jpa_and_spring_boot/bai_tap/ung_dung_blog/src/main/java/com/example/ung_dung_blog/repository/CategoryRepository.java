package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByIdAndFlagDeleteIsFalse(Integer id);
    List<Category> findCategoryByFlagDeleteIsFalse();
}
