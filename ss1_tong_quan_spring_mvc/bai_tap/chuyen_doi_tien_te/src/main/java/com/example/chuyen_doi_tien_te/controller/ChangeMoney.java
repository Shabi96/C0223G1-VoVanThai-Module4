package com.example.chuyen_doi_tien_te.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/money")
public class ChangeMoney {
    @GetMapping()
    public String formChange() {
        return "change_money";
    }

    @PostMapping()
    public String getPrice(@RequestParam("inputMoney") double inputMoney, @RequestParam("rate") double rate, Model model) {
        double result = inputMoney * rate;
        model.addAttribute("result", result);
        return "change_money";
    }
}
