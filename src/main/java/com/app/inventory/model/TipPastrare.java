package com.app.inventory.model;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tip_pastrare")
@CrossOrigin(origins = "http://localhost:4200")
public class TipPastrare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cod") 
    private String cod;  // Ex: TP1, TP2, TP3, Permanent
    @Column(name = "descriere") 
    private String descriere;  // Ex: "10 ani", "permanent"

    @Override
    public String toString() {
        return "TipPastrare [id=" + id + ", cod=" + cod + ", descriere=" + descriere +  "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

  

    public TipPastrare() {
        // Constructor gol
    }
    public TipPastrare(Long id, String cod, String descriere) {
        super();
        this.id = id;
        this.cod = cod;
        this.descriere = descriere;
      
}
}
