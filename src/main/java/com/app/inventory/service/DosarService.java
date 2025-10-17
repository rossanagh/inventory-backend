package com.app.inventory.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.inventory.model.Compartiment;
import com.app.inventory.model.Dosar;
import com.app.inventory.repository.DosarRepository;

@Service
public class DosarService {

    private final DosarRepository dosarRepository;
    public List<Dosar> getAllDosare() {
        return dosarRepository.findAll();
    }
    public DosarService(DosarRepository dosarRepository) {
        this.dosarRepository = dosarRepository;
    }

   

    public List<Dosar> getByInventarId(Long inventarId) {
        return dosarRepository.findByInventar_Id(inventarId);
    }

    public List<Dosar> getAll() {
        return dosarRepository.findAll();
    }

    public Dosar save(Dosar dosar) {
        Long inventarId = dosar.getInventar() != null ? dosar.getInventar().getId() : null;
        String nr = dosar.getNumarCriteriu();

        if (inventarId == null || nr == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inventar și numărCriteriu sunt obligatorii.");
        }

        if (existsNumarCriteriu(inventarId, nr)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Număr criteriu există deja pe acest inventar.");
        }

        return dosarRepository.save(dosar);
    }

    // restul metodelor rămân ca la tine...


    public void delete(Long id) {
        dosarRepository.deleteById(id);
    }
    public List<Dosar> getDosareByInventarId(Long inventarId) {
        List<Dosar> lista = dosarRepository.findByInventar_Id(inventarId);
        System.out.println(">> Dosare găsite pentru inventar " + inventarId + ": " + lista.size());
        return lista;
    }

    public Optional<Dosar> getById(Long id) {
        return dosarRepository.findById(id);
    }

    public List<Integer> existingNumsIn(Long inventarId, Collection<Integer> nums) {
        if (inventarId == null || nums == null || nums.isEmpty()) return List.of();
        return dosarRepository.findExistingNumarCriteriuIn(inventarId, nums);
    }


    
    public Dosar update(Long id, Dosar updated) {
        return dosarRepository.findById(id)
            .map(dosar -> {
                dosar.setIndicativNomenclator(updated.getIndicativNomenclator());
                dosar.setContinut(updated.getContinut());
                dosar.setDataStart(updated.getDataStart());
                dosar.setDataEnd(updated.getDataEnd());
                dosar.setObservatii(updated.getObservatii());
                dosar.setInventar(updated.getInventar());
                dosar.setCutie(updated.getCutie());
                return dosarRepository.save(dosar);
            })
            .orElseThrow(() -> new RuntimeException("Dosar not found with id " + id));
    }
    
    public boolean existsNumarCriteriu(Long inventarId, String numarCriteriu) {
        // dacă vrei global: return dosarRepository.existsByNumarCriteriu(numarCriteriu);
        return dosarRepository.existsByInventar_IdAndNumarCriteriu(inventarId, numarCriteriu);
    }
    
    
    
}
