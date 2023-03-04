package com.example.demo.Service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    void addUSer(User user);


    List<User> getUsers();

    User getUser(Integer id);
}
