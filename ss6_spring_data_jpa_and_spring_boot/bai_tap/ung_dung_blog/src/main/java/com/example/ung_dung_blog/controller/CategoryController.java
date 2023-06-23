package com.example.ung_dung_blog.controller;

import com.example.ung_dung_blog.model.Category;
import com.example.ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService ICategoryService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("category", ICategoryService.getAll());
        return "category/view";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }

    @PostMapping("/create")
    public String addNewCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("message", "Add new success fully!!!");
        ICategoryService.addNewCategory(category);
        return "redirect:/category/view";
    }

    @GetMapping("/update/{id}")
    public String updateCategory(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (ICategoryService.findByIdAndFlagDeleteIsFalse(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Category is not exist!!!");
            return "redirect:/category/view";
        }
        model.addAttribute("category", ICategoryService.findByIdAndFlagDeleteIsFalse(id));
        return "category/edit";
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, Model model, RedirectAttributes redirectAttributes) {
        if (ICategoryService.findByIdAndFlagDeleteIsFalse(category.getId()) == null) {
            redirectAttributes.addFlashAttribute("message", "Category is not exist!!!");
            return "redirect:/category/view";
        }
        ICategoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Update success fully!!!");
        return "redirect:/category/view";
    }

    @PostMapping("delete")
    public String deleteCategory(@RequestParam("id") Integer id, RedirectAttributes redirectAttributes) {
        if (ICategoryService.findByIdAndFlagDeleteIsFalse(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Category is not exist!!!");
            return "redirect:/category/view";
        }
        ICategoryService.deleteCategory(id);
        redirectAttributes.addFlashAttribute("message", "Delete success fully!!!!!");
        return "redirect:/category/view";
    }
}
