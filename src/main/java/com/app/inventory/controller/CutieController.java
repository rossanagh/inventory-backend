package com.app.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.service.CutieService;
import com.app.inventory.model.Cutie;

@RestController
@RequestMapping("/api/cutii")
@CrossOrigin(origins = "http://localhost:4200")
public class CutieController {

    private final CutieService service;
    

    public CutieController(CutieService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cutie> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Cutie save(@RequestBody Cutie cutie) {
        return service.save(cutie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}