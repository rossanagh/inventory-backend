package com.app.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.inventory.model.Fond;
import com.app.inventory.repository.FondRepository;

@Service
public class FondService {

    private final FondRepository fondRepository;

    public FondService(FondRepository fondRepository) {
        this.fondRepository = fondRepository;
    }

    public List<Fond> getAll() {
        return fondRepository.findAll();
    }

    public Optional<Fond> getById(Long id) {
        return fondRepository.findById(id);
    }

    public Fond save(Fond fond) {
        return fondRepository.save(fond);
    }

    public void delete(Long id) {
        fondRepository.deleteById(id);
    }
    
    public Fond update(Long id, Fond fond) {
        Optional<Fond> existingFond = fondRepository.findById(id);
        if (existingFond.isPresent()) {
            Fond updatedFond = existingFond.get();
            updatedFond.setNume(fond.getNume()); // Actualizează doar câmpul `nume`
            return fondRepository.save(updatedFond); // Salvează fondul actualizat
        } else {
            throw new RuntimeException("Fondul cu ID-ul " + id + " nu a fost găsit.");
        }
    }

	
}