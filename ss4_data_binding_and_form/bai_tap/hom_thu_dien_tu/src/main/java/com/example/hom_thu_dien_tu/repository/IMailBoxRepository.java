package com.example.hom_thu_dien_tu.repository;

import com.example.hom_thu_dien_tu.model.MailBox;

import java.util.List;

public interface IMailBoxRepository {
    MailBox getMailBox();
    MailBox setMailBox(MailBox mailBoxUpdate);
    List<String> getLanguageList();
    List<Integer> getPageSizeList();
}
