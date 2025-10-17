package com.app.inventory.controller;


import com.app.inventory.model.Compartiment;
import com.app.inventory.service.CompartimentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compartimente")
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})
public class CompartimentController {

    private final CompartimentService compartimentService;

    public CompartimentController(CompartimentService compartimentService) {
        this.compartimentService = compartimentService;
    }

    @GetMapping
    public List<Compartiment> getAll() {
        return compartimentService.getAll();
    }
    

    @PutMapping("/{id}")
    public Compartiment update(@PathVariable Long id, @RequestBody Compartiment updatedCompartiment) {
        return compartimentService.update(id, updatedCompartiment);
    }


    @PostMapping
    public Compartiment save(@RequestBody Compartiment compartiment) {
        return compartimentService.save(compartiment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        compartimentService.delete(id);
    }
}
