package com.example.tich_hop_restful.service;

import com.example.tich_hop_restful.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    Blog getById(Integer id);

    void createBlog(Blog blog);

    void updateBlog(Blog blog);

    void deleteBlog(Integer id);

    List<Blog> getByCategoryId(Integer id);
}
