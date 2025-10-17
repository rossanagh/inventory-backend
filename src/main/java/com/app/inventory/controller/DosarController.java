package com.app.inventory.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.inventory.model.Dosar;
import com.app.inventory.service.AuditLogService;
import com.app.inventory.service.DosarService;

@RestController
@RequestMapping("/api/dosare")
@CrossOrigin(origins = {
		  "https://rossanagh.github.io",
		  "https://rossanagh.github.io/inventory"
		})
public class DosarController {

    private final DosarService dosarService;
    @Autowired
    private AuditLogService auditLogService;

    public DosarController(DosarService dosarService) {
        this.dosarService = dosarService;
    }

    @GetMapping
    public List<Dosar> getAll() {
        return dosarService.getAll();
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> exists(
        @RequestParam Long inventarId,
        @RequestParam String numarCriteriu
    ) {
        return ResponseEntity.ok(dosarService.existsNumarCriteriu(inventarId, numarCriteriu));
    }

    @PostMapping
    public Dosar save(@RequestBody Dosar dosar, Principal principal) {
        Dosar saved = dosarService.save(dosar);
        if (principal != null) {
            auditLogService.log(principal.getName(), "A adăugat dosarul " + saved.getIndicativNomenclator());
        }
        return saved;
    }


    @PutMapping("/{id}")
    public Dosar update(@PathVariable Long id, @RequestBody Dosar dosar) {
        return dosarService.update(id, dosar);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dosarService.delete(id);
    }
    
    @PostMapping("/dosare")
    public ResponseEntity<?> addDosar(@RequestBody Dosar dosar, Principal principal) {
        dosarService.save(dosar);
        auditLogService.log(principal.getName(), "A adăugat dosarul " + dosar.getIndicativNomenclator());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/exists-batch")
    public List<Integer> existsBatch(
        @RequestParam Long inventarId,
        @RequestBody List<Integer> nums
    ) {
        return dosarService.existingNumsIn(inventarId, nums);
    }
}
