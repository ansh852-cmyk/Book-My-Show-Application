package com.example.BookMyShow.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@Builder   // object creation ko simplify karna .....
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    private String phone;
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
}
