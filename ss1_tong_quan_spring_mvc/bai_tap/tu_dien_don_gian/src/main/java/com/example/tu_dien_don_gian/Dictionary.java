package com.example.tu_dien_don_gian;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/translate")
public class Dictionary {
    @GetMapping
    public String formTranslate() {
        return "dictionary";
    }

    @PostMapping
    public String translate(@RequestParam("word") String word, Model model) {
        Map<String, String> dictionaryMap = new HashMap<>();
        dictionaryMap.put("book", "quyển sách");
        dictionaryMap.put("computer", "máy tính");
        dictionaryMap.put("mouse", "chuột");
        dictionaryMap.put("phone", "điện thoại");
        dictionaryMap.put("flower", "hoa");
        dictionaryMap.put("water", "nước");
        dictionaryMap.put("fan", "cái quạt");
        dictionaryMap.put("sky", "Sơn Tùng MTP");
        dictionaryMap.put("transaction", "tiến trình");
        dictionaryMap.put("pink", "màu hồng");
        String result = null;
        for (String str : dictionaryMap.keySet()) {
            if (str.equals(word.toLowerCase(Locale.ROOT))) {
                result = dictionaryMap.get(str);
                break;
            }
        }
        if (result == null) {
            result = "Không tìm thấy";
        }
        model.addAttribute("result", result);
        return "dictionary";
    }
}
