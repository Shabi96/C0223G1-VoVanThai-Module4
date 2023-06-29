package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.Borrow;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping()
    public String getAllBook(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "view";
    }

    @GetMapping("/borrow/{id}")
    public String showFormBorrow(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        if (bookService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Book is not exist!!!!");
        }
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }
}
