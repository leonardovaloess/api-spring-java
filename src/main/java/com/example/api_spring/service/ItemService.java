package com.example.api_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_spring.entity.Item;
import com.example.api_spring.repository.ItemRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id){
        return itemRepository.findById(id);
    }

    public Item createItem(Item item){
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails){
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));

        if (itemDetails.getName() != null) {
            item.setName(itemDetails.getName());
        }
        if (itemDetails.getDescription() != null) {
            item.setDescription(itemDetails.getDescription());
        }
        if (itemDetails.getQuantity() != 0) {
            item.setQuantity(itemDetails.getQuantity());
        }
        if (itemDetails.getPrice() != 0) { 
            item.setPrice(itemDetails.getPrice());
        }
        return itemRepository.save(item);
    }

    public void deleteItem(Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        itemRepository.delete(item);
    }

}
