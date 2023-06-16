package com.example.tu_dien_don_gian.controller;

import com.example.tu_dien_don_gian.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String formTranslate() {
        return "dictionary";
    }

    @PostMapping("/search")
    public String translate(@RequestParam("word") String word, Model model) {
        String result = dictionaryService.getWord(word);
        model.addAttribute("result", result);
        return "dictionary";
    }
}
