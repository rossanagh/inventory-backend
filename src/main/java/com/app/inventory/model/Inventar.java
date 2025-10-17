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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventar")
@CrossOrigin(origins = "http://localhost:4200")
public class Inventar {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private int an;
	    
	    @Column(name = "pastrare")
	    private String pastrare;

	    @ManyToOne
	    @JoinColumn(name = "compartiment_id")
	    private Compartiment compartiment;
//	    @OneToMany(mappedBy = "inventar")
//	    @JsonIgnore
//	    private List<Dosar> dosare;

	    
	    public Inventar() {}
	    
	    
	    @Override
		public String toString() {
			return "Inventar [id=" + id + ", an=" + an + ", pastrare=" + pastrare + ", compartiment=" +  compartiment.getId() +
					 "]";
		}


		// Getteri și setteri
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public int getAn() { return an; }
	    public void setAn(int an) { this.an = an; }

	    public String getPastrare() { return pastrare; }
	    public void setPastrare(String pastrare) { this.pastrare = pastrare; }
	    
	    public Compartiment getCompartiment() { return compartiment; }
	    public void setCompartiment(Compartiment compartiment) { this.compartiment = compartiment; }
	}
