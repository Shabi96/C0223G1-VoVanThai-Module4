package com.example.chuyen_doi_tien_te.service.impl;

import com.example.chuyen_doi_tien_te.service.IChangeMoneyService;
import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyService implements IChangeMoneyService {
    @Override
    public Double convert(Double money, Double rate) {
        return money * rate;
    }
}
