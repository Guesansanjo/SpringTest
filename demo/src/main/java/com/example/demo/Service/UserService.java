package com.example.demo.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    void addUSer(User user);


    List<User> getUsers();

    User getUser(Integer id);

    void updateUser(Integer id, User user);

    void deleteUser(Integer id);

    void updateName(Integer id, UserDTO userDTO);
}
