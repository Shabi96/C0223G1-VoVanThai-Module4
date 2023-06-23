package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Blog;
import com.example.ung_dung_blog.service.IBlogService;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String getAllBlog(@PageableDefault(size = 3) Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.getAllBlog(pageable));
        model.addAttribute("categories", categoryService.getAll());
        return "/blogs/view";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.getAll());
        return "blogs/create";
    }

    @PostMapping("/create")
    public String addNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(LocalDateTime.now());
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Add new success fully!!!");
        return "redirect:/blogs/view";
    }

    @GetMapping("/detail/{id}")
    public String showDetailBlog(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
            return "redirect:/blogs/view";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            model.addAttribute("categories", categoryService.getAll());
            return "blogs/read";
        }
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
            return "redirect:/blogs/view";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            model.addAttribute("categories", categoryService.getAll());
            return "blogs/edit";
        }
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
            return "redirect:/blogs/view";
        }
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("message", "Update success fully!!");
        return "redirect:/blogs/view";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Blog is not exist!!!");
        } else {
            blogService.deleteBlog(id);
            redirectAttributes.addFlashAttribute("message", "Delete success fully!!!");
        }
        return "redirect:/blogs/view";
    }

    @GetMapping("/search")
    public String searchByName(@PageableDefault(size = 3) Pageable pageable, @RequestParam("name") String name, Model model) {
        model.addAttribute("blogs", blogService.searchByName(name, pageable));
        return "blogs/view";
    }

    @GetMapping("/category/{id}")
    public String searchByCategory(@PageableDefault(size = 3) Pageable pageable, @PathVariable Integer id,
                                   Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.findByIdAndFlagDeleteIsFalse(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Category not found!!!");
            return "redirect:/blogs/view";
        }
        model.addAttribute("blogs", blogService.findByCategoryId(id, pageable));
        model.addAttribute("categories", categoryService.getAll());
        return "blogs/view";
    }

}
