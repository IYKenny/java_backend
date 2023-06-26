package com.example.demo.controllers;

import com.example.demo.models.Quantity;
import com.example.demo.services.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/quantities")
public class QuantityController {
    @Autowired
    private QuantityService quantityService;

    @GetMapping
    public List<Quantity> getAllQuantities() {
        return quantityService.getAllQuantities();
    }

    @GetMapping("/{id}")
    public Quantity getQuantityById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return quantityService.getQuantityById(id);
    }

    @PostMapping
    public Quantity addQuantity(@RequestBody Quantity quantity) {
        return quantityService.addQuantity(quantity);
    }

    @PutMapping("/{id}")
    public Quantity updateQuantity(@PathVariable Long id, @RequestBody Quantity quantity) throws ChangeSetPersister.NotFoundException {
        return quantityService.updateQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteQuantity(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        quantityService.deleteQuantity(id);
    }
}
