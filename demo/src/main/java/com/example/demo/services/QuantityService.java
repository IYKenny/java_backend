package com.example.demo.services;
import com.example.demo.models.Quantity;
import com.example.demo.repositories.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityService {
    @Autowired
    private QuantityRepository quantityRepository;

    public List<Quantity> getAllQuantities() {
        return quantityRepository.findAll();
    }

    public Quantity getQuantityById(Long id) throws ChangeSetPersister.NotFoundException {
        return quantityRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public Quantity addQuantity(Quantity quantity) {
        return quantityRepository.save(quantity);
    }

    public Quantity updateQuantity(Long id, Quantity quantity) throws ChangeSetPersister.NotFoundException {
        Quantity existingQuantity = getQuantityById(id);
        existingQuantity.setId(quantity.getId());
        existingQuantity.setQuantity(quantity.getQuantity());
        existingQuantity.setOperation(quantity.getOperation());
        existingQuantity.setDate(quantity.getDate());
        return quantityRepository.save(existingQuantity);
    }

    public void deleteQuantity(Long id) throws ChangeSetPersister.NotFoundException {
        Quantity quantity = getQuantityById(id);
        quantityRepository.delete(quantity);
    }
}
