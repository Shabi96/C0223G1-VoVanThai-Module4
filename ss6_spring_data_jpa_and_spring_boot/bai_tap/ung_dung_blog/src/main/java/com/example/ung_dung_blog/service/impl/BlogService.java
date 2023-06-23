package com.example.ung_dung_blog.service.impl;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.repository.IBlogRepository;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> getAllBlog(Pageable pageable) {
        return blogRepository.getAllByFlagDeleteIsFalse(pageable);
    }

    @Override
    public void addNewBlog(Blog blog) {
        blog.setFlagDelete(false);
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findByIdAndFlagDeleteIsFalse(id);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        Blog deleteBlog = this.findById(id);
        deleteBlog.setFlagDelete(true);
        blogRepository.save(deleteBlog);
    }

    @Override
    public Page<Blog> searchByName(String name, Pageable pageable) {
        return blogRepository.findByNameContainingAndFlagDeleteIsFalse(name, pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Integer id, Pageable pageable) {
        return blogRepository.findByCategoryIdAndFlagDeleteIsFalse(id, pageable);
    }
}
