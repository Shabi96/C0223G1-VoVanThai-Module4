package com.example.ung_dung_muon_sach.controller;

import com.example.ung_dung_muon_sach.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private IBorrowService borrowService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("borrows", borrowService.getAll());
        return "borrow";
    }
}
