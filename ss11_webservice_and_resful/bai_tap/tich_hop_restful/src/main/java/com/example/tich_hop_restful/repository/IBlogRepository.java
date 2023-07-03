package com.example.tich_hop_restful.repository;

import com.example.tich_hop_restful.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(nativeQuery = true, value = "select * from  blog where is_delete = 0 limit :number")
    List<Blog> getAllByFlagDeleteIsFalse(@Param("number") Integer number);
    Blog getBlogByIdAndFlagDeleteIsFalse(Integer id);
    List<Blog> getBlogByCategoryIdAndFlagDeleteIsFalse(Integer id);
    List<Blog> getBlogByNameContainsIgnoreCaseAndFlagDeleteIsFalse(String name);
}
