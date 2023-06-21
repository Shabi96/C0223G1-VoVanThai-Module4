package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping()
    public String getProductList(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "list";
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/createProduct")
    public String addNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addNewProduct(product);
        redirectAttributes.addFlashAttribute("message", "Add new successfully!!");
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(Model model, @PathVariable Integer id, RedirectAttributes redirectAttributes) {
        if (productService.findId(id) >= 0) {
            model.addAttribute("product", productService.getProductById(id));
            return "update";
        } else {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!");
            return "redirect:/product";
        }
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product, product.getId());
        redirectAttributes.addFlashAttribute("message", "Update successfully!!!");
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("idDelete") Integer id, RedirectAttributes redirectAttributes) {
        if (productService.findId(id) >= 0) {
            productService.deleteProduct(id);
            redirectAttributes.addFlashAttribute("message", "Delete successfully!!!");
        } else {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!");
        }
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String showDetailForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if(productService.getProductById(id) != null) {
            model.addAttribute("product", productService.getProductById(id));
            return "detail";
        } else {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!");
            return "redirect:/product";
        }
    }

    @GetMapping("search")
    public String searchProduct(Model model, @RequestParam("name") String name) {
        model.addAttribute("products", productService.searchByName(name));
        return "list";
    }
}
