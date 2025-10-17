package com.app.inventory.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.inventory.model.Inventar;
import com.app.inventory.service.InventarService;

@RestController
@RequestMapping("/api/inventar")
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})
public class InventarController {

	 private final InventarService inventarService;

	    public InventarController(InventarService inventarService) {
	        this.inventarService = inventarService;
	    }

	    @GetMapping
	    public List<Inventar> getAll() {
	        return inventarService.getAll();
	    }

	    @PostMapping
	    public Inventar save(@RequestBody Inventar inventar) {
	        return inventarService.save(inventar);
	    }

	    @PutMapping("/{id}")
	    public Inventar update(@PathVariable Long id, @RequestBody Inventar inventar) {
	        return inventarService.update(id, inventar);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        inventarService.delete(id);
	    }
	    
	    @GetMapping("/compartiment/{compartimentId}")
	    public List<Inventar> getByCompartiment(@PathVariable Long compartimentId) {
	        return inventarService.getByCompartimentId(compartimentId);
	    }
}
