package com.app.inventory.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fond")
@CrossOrigin(origins = "http://localhost:4200")
public class Fond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;  // Schimbat denumire cu nume

	@Override
	public String toString() {
		return "Fond [id=" + id + ", nume=" + nume + "]";
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

	public Fond(Long id, String nume) {
		super();
		this.id = id;
		this.nume = nume;
	}
	 public Fond() {
	        // constructor implicit obligatoriu pentru Hibernate
	    }


}
