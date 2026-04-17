package com.example.BookMyShow.repository;

import com.example.BookMyShow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    User findUserById(Long userId);
}
