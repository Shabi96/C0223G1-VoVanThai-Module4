package com.example.thuc_hanh_2.service.impl;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;
import com.example.thuc_hanh_2.repository.IUserRepository;
import com.example.thuc_hanh_2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
