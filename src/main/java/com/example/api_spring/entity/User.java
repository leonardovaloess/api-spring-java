package com.example.api_spring.entity;

import org.checkerframework.common.aliasing.qual.Unique;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;


    private String name;
  
    @Unique private String email;

    private String password;

    private int user_type_id;

    // Getters e Setters 

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public int getUserTypeId() {
        return user_type_id;
    }

    public void setUserTypeId(int user_type_id) {
        this.user_type_id = user_type_id;
    }
}