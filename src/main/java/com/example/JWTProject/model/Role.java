package com.example.JWTProject.model;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
}