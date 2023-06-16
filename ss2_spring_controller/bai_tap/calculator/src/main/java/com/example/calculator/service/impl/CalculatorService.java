package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double addition(Double num1, Double num2) {
        return num1 + num2;
    }

    @Override
    public double subtraction(Double num1, Double num2) {
        return num1 - num2;
    }

    @Override
    public double multiplication(Double num1, Double num2) {
        return num1 * num2;
    }

    @Override
    public double division(Double num1, Double num2) {
        return num1 / num2;
    }
}
