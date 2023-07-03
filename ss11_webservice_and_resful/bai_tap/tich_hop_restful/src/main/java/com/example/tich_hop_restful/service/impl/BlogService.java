package com.example.tich_hop_restful.service.impl;

import com.example.tich_hop_restful.model.Blog;
import com.example.tich_hop_restful.repository.IBlogRepository;
import com.example.tich_hop_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getAll(Integer number) {
        return blogRepository.getAllByFlagDeleteIsFalse(number);
    }

    @Override
    public Blog getById(Integer id) {
        return blogRepository.getBlogByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public void createBlog(Blog blog) {
        blog.setDate(LocalDateTime.now());
        blogRepository.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        Blog blog = blogRepository.getBlogByIdAndFlagDeleteIsFalse(id);
        blog.setFlagDelete(true);
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getByCategoryId(Integer id) {
        return blogRepository.getBlogByCategoryIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public List<Blog> searchByName(String name) {
        return blogRepository.getBlogByNameContainsIgnoreCaseAndFlagDeleteIsFalse(name);
    }
}
