package com.app.inventory.service;

import com.app.inventory.model.TipPastrare;
import com.app.inventory.repository.TipPastrareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipPastrareService {

    private final TipPastrareRepository repository;

    public TipPastrareService(TipPastrareRepository repository) {
        this.repository = repository;
    }

    public List<TipPastrare> getAll() {
        return repository.findAll();
    }

    public Optional<TipPastrare> getById(Long id) {
        return repository.findById(id);
    }

    public TipPastrare save(TipPastrare tipPastrare) {
        return repository.save(tipPastrare);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}