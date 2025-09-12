package com.example.JWTProject.model;


import lombok.Data;

@Data
public class AuthResponse {
    private Integer id;
    private String token;

    public AuthResponse(String token, Integer id) {
        this.token = token;
        this.id = id;
    }
}
