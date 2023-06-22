package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();

    void addNewBlog(Blog blog);

    Blog findById(Integer id);

    void updateBlog(Blog blog);

    void deleteBlog(Integer id);

    List<Blog> searchByName(String name);
}
