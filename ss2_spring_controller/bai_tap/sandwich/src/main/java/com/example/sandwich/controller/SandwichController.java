package com.example.sandwich.controller;

import com.example.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {

    @Autowired
    private ISandwichService sandwichService;

    @GetMapping()
    public String showForm() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiments, Model model) {
        if(condiments == null) {
            model.addAttribute("result", "Not selected!!");
        } else {
            String[] result = sandwichService.getCondiments(condiments);
            model.addAttribute("result", Arrays.toString(result));
        }
        return "index";
    }
}
