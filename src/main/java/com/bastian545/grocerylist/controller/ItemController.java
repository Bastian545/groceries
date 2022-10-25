package com.bastian545.grocerylist.controller;


import com.bastian545.grocerylist.exception.ItemNotFoundException;
import com.bastian545.grocerylist.model.Item;
import com.bastian545.grocerylist.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    private ItemRepo itemRepo;

    @GetMapping("/items")
    List<Item> findAll() {
        return itemRepo.findAll();
    }

    @GetMapping("/items/{id}")
    Item findByid(@PathVariable Long id) {
        return itemRepo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PostMapping("/items")
    Item newItem(@RequestBody Item newItem) {
        return itemRepo.save(newItem);
    }

    @PutMapping("/items/{id}")
    Item editItem(@RequestBody Item newItem, @PathVariable Long id) {
        return itemRepo.findById(id).map(item -> {
                    item.setName(newItem.getName());
                    item.setQuantity(newItem.getQuantity());
                    item.setNotes(newItem.getNotes());
                    return itemRepo.save(item);
                })

                .orElseGet(() -> {
                    newItem.setId(id);
                    return itemRepo.save(newItem);
                });
    }

    @DeleteMapping ("/items/{id}")
    void deleteItem (@PathVariable Long id){
        itemRepo.deleteById(id);
    }


}
