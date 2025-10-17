package com.app.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.inventory.model.Inventar;
import com.app.inventory.repository.InventarRepository;

@Service
public class InventarService {

    private final InventarRepository inventarRepository;

    public InventarService(InventarRepository inventarRepository) {
        this.inventarRepository = inventarRepository;
    }

    public List<Inventar> getAll() {
        return inventarRepository.findAll();
    }

    public Optional<Inventar> getById(Long id) {
        return inventarRepository.findById(id);
    }

    public List<Inventar> getByCompartimentId(Long compartimentId) {
        return inventarRepository.findByCompartimentId(compartimentId);
    }

    public Inventar save(Inventar inventar) {
        return inventarRepository.save(inventar);
    }

    public void delete(Long id) {
        inventarRepository.deleteById(id);
    }
    
    

    public Inventar update(Long id, Inventar updatedInventar) {
        return inventarRepository.findById(id)
            .map(inventar -> {
                inventar.setAn(updatedInventar.getAn());
                inventar.setPastrare(updatedInventar.getPastrare());
                inventar.setCompartiment(updatedInventar.getCompartiment()); // important!
                return inventarRepository.save(inventar);
            })
            .orElseThrow(() -> new RuntimeException("Inventar not found with id " + id));
    }
}