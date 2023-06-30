package com.example.tich_hop_restful.repository;

import com.example.tich_hop_restful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> getAllByFlagDeleteIsFalse();
    Blog getBlogByIdAndFlagDeleteIsFalse(Integer id);
    List<Blog> getBlogByCategoryIdAndFlagDeleteIsFalse(Integer id);
}
