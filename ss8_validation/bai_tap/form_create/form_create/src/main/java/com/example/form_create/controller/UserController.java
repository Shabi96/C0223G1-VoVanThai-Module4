package com.example.form_create.controller;

import com.example.form_create.dto.UserDto;
import com.example.form_create.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping()
    public String showCreateForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "view";
    }

    @PostMapping("create")
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "view";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        model.addAttribute("message", "Create success fully!!!!");
        return "result";
    }
}
