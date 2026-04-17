package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.dto.LoginRequest;
import com.example.BookMyShow.dto.UserRequest;
import com.example.BookMyShow.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public User register(UserRequest request);
    public User login(LoginRequest request);
    public List<User> getAllUser();
    public User getUserById(Long id);
}
