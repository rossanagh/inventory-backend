package com.app.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.inventory.model.Compartiment;
import com.app.inventory.repository.CompartimentRepository;

@Service
public class CompartimentService {

    private final CompartimentRepository compartimentRepository;

    public CompartimentService(CompartimentRepository compartimentRepository) {
        this.compartimentRepository = compartimentRepository;
    }

    public List<Compartiment> getAll() {
        return compartimentRepository.findAll();
    }

    public Optional<Compartiment> getById(Long id) {
        return compartimentRepository.findById(id);
    }

    public Compartiment save(Compartiment compartiment) {
        return compartimentRepository.save(compartiment);
    }

    public void delete(Long id) {
        compartimentRepository.deleteById(id);
    }

    public Compartiment update(Long id, Compartiment updatedCompartiment) {
        return compartimentRepository.findById(id)
            .map(compartiment -> {
                compartiment.setNume(updatedCompartiment.getNume());
                compartiment.setFond(updatedCompartiment.getFond()); // important!
                return compartimentRepository.save(compartiment);
            })
            .orElseThrow(() -> new RuntimeException("Compartiment not found with id " + id));
    }

   

}
