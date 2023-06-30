package com.example.tich_hop_restful.repository;

import com.example.tich_hop_restful.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByFlagDeleteIsFalse();
    Category getCategoryByIdAndFlagDeleteIsFalse(Integer id);
}
