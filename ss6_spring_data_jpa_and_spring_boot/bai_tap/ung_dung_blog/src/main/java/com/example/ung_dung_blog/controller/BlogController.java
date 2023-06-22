package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String getAllBlog(Model model) {
        model.addAttribute("blogs", blogService.getAllBlog());
        return "blog";
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/createBlog")
    public String addNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(LocalDateTime.now());
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Add new success fully!!!");
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showDetailBlog(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            return "read";
        }
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            return "edit";
        }
    }

    @PostMapping("/updateBlog")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(LocalDateTime.now());
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Update success fully!!");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
        } else {
            blogService.deleteBlog(id);
            redirectAttributes.addFlashAttribute("message", "Delete success fully!!!");
        }
        return "redirect:/blog";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("name") String name, Model model) {
        model.addAttribute("blogs", blogService.searchByName(name));
        return "blog";
    }
}
