package com.example.hom_thu_dien_tu.service;

import com.example.hom_thu_dien_tu.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    MailBox getMailBox();
    MailBox setMailBox(MailBox mailBoxUpdate);
    List<String> getLanguageList();
    List<Integer> getPageSizeList();
}
