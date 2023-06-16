package com.example.tu_dien_don_gian.repository.impl;

import com.example.tu_dien_don_gian.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> stringMap = new HashMap<>();
    static {
        stringMap.put("book", "quyển sách");
        stringMap.put("computer", "máy tính");
        stringMap.put("mouse", "chuột");
        stringMap.put("phone", "điện thoại");
        stringMap.put("flower", "hoa");
        stringMap.put("water", "nước");
        stringMap.put("fan", "cái quạt");
        stringMap.put("sky", "Sơn Tùng MTP");
        stringMap.put("transaction", "tiến trình");
        stringMap.put("pink", "màu hồng");
    }
    @Override
    public String getWord(String word) {
        String result = null;
        for (String str : stringMap.keySet()) {
            if (str.equals(word.toLowerCase(Locale.ROOT))) {
                result = stringMap.get(str);
                break;
            }
        }
        if (result == null) {
            result = "Không tìm thấy";
        }
        return result;
    }
}
