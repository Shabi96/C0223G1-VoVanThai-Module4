package com.example.hom_thu_dien_tu.repository.impl;

import com.example.hom_thu_dien_tu.model.MailBox;
import com.example.hom_thu_dien_tu.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements IMailBoxRepository {
    private static final MailBox mailBox = new MailBox();
    static {
        mailBox.setLanguages("Vietnamese");
        mailBox.setPageSize(5);
        mailBox.setFilter(true);
        mailBox.setSignature("Thor");
    }

    @Override
    public MailBox getMailBox() {
        return mailBox;
    }

    @Override
    public MailBox setMailBox(MailBox mailBox) {
        return mailBox;
    }
}
