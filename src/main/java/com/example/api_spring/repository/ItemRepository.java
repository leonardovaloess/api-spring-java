package com.example.api_spring.repository;

// Importando entity

import com.example.api_spring.entity.Item;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    
    
} 
