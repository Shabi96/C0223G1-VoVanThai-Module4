package com.example.hom_thu_dien_tu.repository.impl;

import com.example.hom_thu_dien_tu.model.MailBox;
import com.example.hom_thu_dien_tu.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MailBoxRepository implements IMailBoxRepository {
    private static final MailBox mailBox = new MailBox();

    static {
        mailBox.setLanguages("Vietnamese");
        mailBox.setPageSize(5);
        mailBox.setFilter(true);
        mailBox.setSignature("Thor");

    }

    private static List<String> languageList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }

    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<String> getLanguageList() {
        return languageList;
    }

    @Override
    public List<Integer> getPageSizeList() {
        return pageSizeList;
    }

    @Override
    public MailBox getMailBox() {
        return mailBox;
    }

    @Override
    public MailBox setMailBox(MailBox mailBoxUpdate) {
        mailBox.setLanguages(mailBoxUpdate.getLanguages());
        mailBox.setPageSize(mailBoxUpdate.getPageSize());
        mailBox.setFilter(mailBoxUpdate.isFilter());
        mailBox.setSignature(mailBoxUpdate.getSignature());
        return mailBox;
    }
}
