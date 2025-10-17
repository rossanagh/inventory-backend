package com.app.inventory.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compartiment")
@CrossOrigin(origins = "http://localhost:4200")
public class Compartiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    @ManyToOne
    @JoinColumn(name = "fond_id", nullable = false)
    private Fond fond;

    public Compartiment() {
    }

    public Compartiment(Long id, String nume, Fond fond) {
        this.id = id;
        this.nume = nume;
        this.fond = fond;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Fond getFond() {
        return fond;
    }

    public void setFond(Fond fond) {
        this.fond = fond;
    }

    @Override
    public String toString() {
        return "Compartiment [id=" + id + ", nume=" + nume + ", fond=" + fond.getId() + "]";
    }
}