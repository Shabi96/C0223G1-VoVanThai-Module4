package com.example.hom_thu_dien_tu.controller;

import com.example.hom_thu_dien_tu.model.MailBox;
import com.example.hom_thu_dien_tu.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailBoxController {

    @Autowired
    private IMailBoxService mailBoxService;

    @GetMapping()
    public String showForm(Model model) {
        model.addAttribute("mail", mailBoxService.getMailBox());
        return "show";
    }

    @GetMapping("/setting")
    public String getFormSetting(Model model) {
        model.addAttribute("mail", new MailBox());
        return "index";
    }

    @PostMapping("/update")
    public String saveForm(@ModelAttribute MailBox mailBox, Model model) {
        model.addAttribute("mail",mailBoxService.setMailBox(mailBox));
        return "show";
    }

}
