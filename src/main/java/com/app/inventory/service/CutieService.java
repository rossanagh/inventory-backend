package com.app.inventory.service;

import com.app.inventory.model.Cutie;
import com.app.inventory.repository.CutieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CutieService {

    private final CutieRepository repository;

    public CutieService(CutieRepository repository) {
        this.repository = repository;
    }

    public List<Cutie> getAll() {
        return repository.findAll();
    }

    public Optional<Cutie> getById(Long id) {
        return repository.findById(id);
    }

    public Cutie save(Cutie cutie) {
        return repository.save(cutie);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}