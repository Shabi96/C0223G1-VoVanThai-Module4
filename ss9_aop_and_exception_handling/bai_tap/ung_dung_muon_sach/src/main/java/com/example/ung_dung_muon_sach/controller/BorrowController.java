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
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IBookService bookService;
    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("borrows", borrowService.getAll());
        return "borrow";
    }
    @PostMapping("/newBorrow")
    public String borrowBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        if (book.getAmount() > 0) {
            bookService.updateBook(book);
            redirectAttributes.addFlashAttribute("message", borrowService.addNewBorrow(book));
            return "redirect:/book";
        }
        redirectAttributes.addFlashAttribute("message", "Can't borrow because book's amount it's over!!!");
        return "redirect:/book";
    }

    @PostMapping("/giveBack")
    public String giveBackBook(@RequestParam("code") Integer code,
                               RedirectAttributes redirectAttributes, Model model) {
        if (borrowService.findByCode(code)) {
            model.addAttribute("borrowDelete", borrowService.getByCode(code));
            return "confirm";
        } else {
            redirectAttributes.addFlashAttribute("message", "Book is not exist!!");
        }
        return "redirect:/book";
    }

    @PostMapping("/confirm")
    public String deleteBorrow(@ModelAttribute Borrow borrow, RedirectAttributes redirectAttributes) {
        borrowService.deleteBorrowBook(borrow.getId());
        bookService.giveBook(borrowService.findByIdAndFlagIsTrue(borrow.getId()).getBook());
        redirectAttributes.addFlashAttribute("message", "Give back success fully!!!!");
        return "redirect:/book";
    }
}
