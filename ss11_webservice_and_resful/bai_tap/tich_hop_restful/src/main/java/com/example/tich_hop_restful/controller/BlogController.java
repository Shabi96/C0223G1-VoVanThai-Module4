package com.example.tich_hop_restful.controller;

import com.example.tich_hop_restful.model.Blog;
import com.example.tich_hop_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(blogService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> detailBlog(@PathVariable Integer id) {
        if (blogService.getById(id) != null) {
            return new ResponseEntity<>(blogService.getById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        if (blogService.getById(blog.getId()) != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        blogService.createBlog(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        if(blogService.getById(id) != null) {
            blogService.updateBlog(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        if (blogService.getById(id) != null) {
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
