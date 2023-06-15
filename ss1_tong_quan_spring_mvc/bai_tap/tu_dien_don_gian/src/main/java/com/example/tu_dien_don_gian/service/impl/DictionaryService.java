package com.example.tu_dien_don_gian.service.impl;

import com.example.tu_dien_don_gian.repository.IDictionaryRepository;
import com.example.tu_dien_don_gian.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String getWord(String word) {
        return dictionaryRepository.getWord(word);
    }
}
