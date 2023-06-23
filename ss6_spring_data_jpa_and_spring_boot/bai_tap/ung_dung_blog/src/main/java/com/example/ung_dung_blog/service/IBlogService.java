package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {
    Page<Blog> getAllBlog(Pageable pageable);

    void addNewBlog(Blog blog);

    Blog findById(Integer id);

    void updateBlog(Blog blog);

    void deleteBlog(Integer id);

    Page<Blog> searchByName(String name, Pageable pageable);

    Page<Blog> findByCategoryId(Integer id, Pageable pageable);
}
