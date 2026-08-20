package com.example.BookMyShow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig  {

    @Bean
    public WebMvcConfigurer corsConfigMapping() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
<<<<<<< HEAD
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
=======
                        .allowedOrigins("https://bookourshownow.netlify.app")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
>>>>>>> 289f7c17909343a66cf2793be941998ba9c5b0d1
                        .allowedHeaders("*");
            };
        };
    }


}

