package com.app.inventory.controller;

import com.app.inventory.model.Fond;
import com.app.inventory.service.FondService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fonduri")
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})
public class FondController {

    private final FondService fondService;

    public FondController(FondService fondService) {
        this.fondService = fondService;
    }

    @GetMapping
    public List<Fond> getAll() {
        return fondService.getAll();
    }

    @PutMapping("/{id}")
    public Fond update(@PathVariable Long id, @RequestBody Fond fond) {
        return fondService.update(id, fond);
    }
    
    @PostMapping
    public Fond save(@RequestBody Fond fond) {
        return fondService.save(fond);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fondService.delete(id);
    }
}