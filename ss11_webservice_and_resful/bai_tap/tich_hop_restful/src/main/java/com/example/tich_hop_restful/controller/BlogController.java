package com.example.tich_hop_restful.controller;

import com.example.tich_hop_restful.model.Blog;
import com.example.tich_hop_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/more/{number}")
    public ResponseEntity<?> getAll(@PathVariable Integer number) {
        return new ResponseEntity<>(blogService.getAll(number), HttpStatus.OK) ;
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
    @CrossOrigin("*")
    public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
        if (blogService.getById(id) != null) {
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping("/search/{name}")
    public ResponseEntity<List<Blog>> searchByName(@PathVariable String name) {
        if (blogService.searchByName(name).size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogService.searchByName(name), HttpStatus.OK);
    }
}
