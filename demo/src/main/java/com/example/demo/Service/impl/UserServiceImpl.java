package com.example.demo.Service.impl;

import com.example.demo.Service.UserService;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUSer(User user) {
    userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Integer id) {
        User user = userRepository.
                findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id" + id));
        return user;
    }

    @Override
    public void updateUser(Integer id, User user) {
    //check user by id db

        userRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid id" + id));
        user.setId(id);

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid id" + id));

        userRepository.delete(user);
    }

    @Override
    public void updateName(Integer id, UserDTO userDTO) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid id" + id));

    user.setName(userDTO.getName());
    userRepository.save(user);
    }


}
