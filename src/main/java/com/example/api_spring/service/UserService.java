package com.example.api_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_spring.entity.User;
import com.example.api_spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userEditPayload){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));

        if (userEditPayload.getName() != null) {
            user.setName(userEditPayload.getName());
        }
        if (userEditPayload.getEmail() != null) {
            user.setEmail(userEditPayload.getEmail());
        }
        if (userEditPayload.getPassword() != null) {
            user.setpassword(userEditPayload.getPassword());
        }
        if (userEditPayload.getUserTypeId() != 0) { 
            user.setUserTypeId(userEditPayload.getUserTypeId());
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
        userRepository.delete(user);
    }

}
