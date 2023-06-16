package com.example.calculator.controller;

import com.example.calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String showForm() {
        return "index";
    }

    @Autowired
    private ICalculatorService calculatorService;

    @PostMapping("/calculator")
    public String calculator(@RequestParam(value = "number1", required = false) Double num1,
                             @RequestParam(value = "number2", required = false) Double num2,
                             @RequestParam("count") String count, Model model) {
        if (num1 == null || num2 == null) {
            model.addAttribute("result", "Can not be empty!!!!");
        } else {
            switch (count) {
                case "addition":
                    model.addAttribute("result", calculatorService.addition(num1, num2));
                    break;
                case "subtraction":
                    model.addAttribute("result", calculatorService.subtraction(num1, num2));
                    break;
                case "multiplication":
                    model.addAttribute("result", calculatorService.multiplication(num1, num2));
                    break;
                case "division":
                    if (num2 == 0) {
                        model.addAttribute("result", "Can't division by 0!!");
                    } else {
                        model.addAttribute("result", calculatorService.division(num1, num2));
                    }
                    break;
            }
        }
        return "index";
    }
}
