package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculator(Double num1, Double num2, String count) {
        switch (count) {
            case "addition":
                return String.valueOf(num1 + num2);
            case "subtraction":
                return String.valueOf(num1 - num2);
            case "multiplication":
                return String.valueOf(num1 * num2);
            case "division":
                if (num2 == 0) {
                    return "Can't division by 0!!!";
                }
                return String.valueOf(num1 / num2);
            default:
                return "Not selected!!";
        }
    }
}
