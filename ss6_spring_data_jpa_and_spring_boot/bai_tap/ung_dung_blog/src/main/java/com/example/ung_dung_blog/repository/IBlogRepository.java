package com.example.ung_dung_blog.repository;

import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContainingAndFlagDeleteIsFalse(String name, Pageable pageable);
    Page<Blog> getAllByFlagDeleteIsFalse(Pageable pageable);
    Blog findByIdAndFlagDeleteIsFalse(Integer id);
    Page<Blog> findByCategoryIdAndFlagDeleteIsFalse(Integer id, Pageable pageable);
}
