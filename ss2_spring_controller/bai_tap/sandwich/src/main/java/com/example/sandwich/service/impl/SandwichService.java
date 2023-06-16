package com.example.sandwich.service.impl;

import com.example.sandwich.service.ISandwichService;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {
    @Override
    public String[] getCondiments(String[] condiments) {
        return condiments;
    }
}
