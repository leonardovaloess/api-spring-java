package com.example.api_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_spring.custom_responses.ResourceNotFoundException;
import com.example.api_spring.custom_responses.BadRequestException;

import com.example.api_spring.entity.User;
import com.example.api_spring.repository.UserRepository;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public User getUserByEmail(String email) {
        System.out.println("email: " + email);

        User userToReturn = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + email));

        System.out.println("user localizado por email: " + userToReturn);

        return userToReturn;
    }

    public User createUser(User payload) {
        try {
            // Validação de dados pode ser feita aqui
            
            if (payload.getEmail() == null || payload.getName() == null ) {
                throw new BadRequestException("Invalid user data");
            }
            return userRepository.save(payload);
        } catch (Exception e) {
            throw new BadRequestException("Error while creating user: " + e.getMessage());
        }
    }

    public User updateUser(Long id, User userEditPayload) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        if (userEditPayload.getName() != null) {
            user.setName(userEditPayload.getName());
        }
        if (userEditPayload.getEmail() != null) {
            user.setEmail(userEditPayload.getEmail());
        }
        if (userEditPayload.getPassword() != null) {
            user.setPassword(userEditPayload.getPassword());
        }
        if (userEditPayload.getUserTypeId() != 0) {
            user.setUserTypeId(userEditPayload.getUserTypeId());
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}