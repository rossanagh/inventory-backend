package com.app.inventory.model;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cutie")
@CrossOrigin(origins = "http://localhost:4200")
public class Cutie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cod; // ex: "C1", "C2"

 
 



    public Cutie() {
        // Constructor implicit necesar pentru Hibernate
    }
	

	@Override
	public String toString() {
		return "Cutie [id=" + id + ", cod=" + cod + "]";
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

	

	public Cutie(Long id, String cod, List<Dosar> dosare) {
		super();
		this.id = id;
		this.cod = cod;
	
	}
    
    
}