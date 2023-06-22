package com.example.ung_dung_blog.service.impl;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.repository.IBlogRepository;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void addNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).
                orElse(null);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> searchByName(String name) {
        return blogRepository.findByNameContaining(name);
    }
}
