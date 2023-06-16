package com.example.chuyen_doi_tien_te.controller;

import com.example.chuyen_doi_tien_te.service.IChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoneyController {
    @Autowired
    private IChangeMoneyService changeMoneyService;

    @GetMapping("")
    public String formChange() {
        return "change_money";
    }

    @PostMapping("/change")
    public String getPrice(@RequestParam("inputMoney") Double inputMoney, @RequestParam("rate") Double rate, Model model) {
        Double result = changeMoneyService.convert(inputMoney, rate);
        model.addAttribute("result", result);
        return "change_money";
    }
}
