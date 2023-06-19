package com.example.thuc_hanh_2.repository.impl;

import com.example.thuc_hanh_2.model.Login;
import com.example.thuc_hanh_2.model.User;
import com.example.thuc_hanh_2.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
    private static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("nampc", "123","nam", "mail", 26));
        userList.add(new User("hunglv", "123","hung", "mail", 26));
        userList.add(new User("hoahoa", "123","hoa", "mail", 23));
    }

    @Override
    public User checkLogin(Login login) {
        for (User u : userList) {
            if(u.getAccount().equals(login.getAccount()) && u.getPassword().equals(login.getPassword())) {
                return u;
            }
        }
        return null;
    }
}
