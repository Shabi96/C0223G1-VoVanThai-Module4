package com.example.hom_thu_dien_tu.service.impl;

import com.example.hom_thu_dien_tu.model.MailBox;
import com.example.hom_thu_dien_tu.repository.IMailBoxRepository;
import com.example.hom_thu_dien_tu.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {
    @Autowired
    private IMailBoxRepository mailBoxRepository;



    @Override
    public MailBox getMailBox() {
        return mailBoxRepository.getMailBox();
    }

    @Override
    public MailBox setMailBox(MailBox mailBoxUpdate) {
        return mailBoxRepository.setMailBox(mailBoxUpdate);
    }

    @Override
    public List<String> getLanguageList() {
        return mailBoxRepository.getLanguageList();
    }

    @Override
    public List<Integer> getPageSizeList() {
        return mailBoxRepository.getPageSizeList();
    }
}
