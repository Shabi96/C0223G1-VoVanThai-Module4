package com.example.tu_dien_don_gian.repository.impl;

import com.example.tu_dien_don_gian.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    @Override
    public String getWord(String word) {
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
        return result;
    }
}
