package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.LoginRequest;
import com.example.BookMyShow.dto.UserRequest;
import com.example.BookMyShow.entity.User;
import com.example.BookMyShow.service.UserService;
import com.example.BookMyShow.service.impl.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceInterface userService;


    @PostMapping("/register")
    private ResponseEntity<User> register(@RequestBody UserRequest request)
    {
        return  ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    private ResponseEntity<User> login(@RequestBody LoginRequest request)
    {
        return  ResponseEntity.ok(userService.login(request));
    }

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers()
    {
        return  ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        return  ResponseEntity.ok(userService.getUserById(id));
    }
}
