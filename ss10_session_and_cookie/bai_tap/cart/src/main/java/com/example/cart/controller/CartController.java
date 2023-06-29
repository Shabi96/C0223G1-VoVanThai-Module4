package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("cart")
@SessionAttributes("cartShopping")
public class CartController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cartShopping")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public String showAll(@ModelAttribute("cartShopping") Cart cart,
                          Model model) {
        model.addAttribute("carts", cart);
        return "cart";
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Integer id, @ModelAttribute("cartShopping") Cart cart,
                            Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product != null) {
            cart.addProduct(product);
            model.addAttribute("carts", cart);
        } else {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!!!");
        }
        return "redirect:/product";
    }

    @GetMapping("quantityMinus/{id}")
    public String minusItem(@PathVariable Integer id, @ModelAttribute("cartShopping") Cart cart,
                            RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!!!");
        }
        cart.quantityMinus(product);
        return "redirect:/cart";
    }

    @GetMapping("quantityPlus/{id}")
    public String plusItem(@PathVariable Integer id, @ModelAttribute("cartShopping") Cart cart,
                           RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!!!");
        }
        cart.quantityPlus(product);
        return "redirect:/cart";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id, @ModelAttribute("cartShopping") Cart cart,
                                RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Product is not exist!!!!");
        }
        cart.deleteProduct(product);
        return "redirect:/cart";
    }

    @GetMapping("payment")
    public String payment(@ModelAttribute("cartShopping") Cart cart, RedirectAttributes redirectAttributes) {
        cart.payment();
        redirectAttributes.addFlashAttribute("message", "Payment success fully!!!!");
        return "redirect:/cart";
    }
}
