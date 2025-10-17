package com.app.inventory.controller;

import com.app.inventory.model.Dosar;
import com.app.inventory.model.TipPastrare;
import com.app.inventory.service.TipPastrareService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.OneToMany;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tip-pastrare")
@CrossOrigin(origins = "http://localhost:4200")
public class TipPastrareController {

    private final TipPastrareService service;
    @OneToMany(mappedBy = "tipPastrare")
    @JsonIgnore
    private List<Dosar> dosare;

    public TipPastrareController(TipPastrareService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipPastrare> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TipPastrare save(@RequestBody TipPastrare tipPastrare) {
        return service.save(tipPastrare);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}