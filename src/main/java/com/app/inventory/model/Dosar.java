package com.app.inventory.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@CrossOrigin(origins = "http://localhost:4200")
@Table(name = "dosar")
public class Dosar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numar_criteriu")
    private String numarCriteriu;

    
    @ManyToOne
    @JoinColumn(name = "inventar_id")
    private Inventar inventar;

    @Column(name = "indicativ_nomenclator")
    private String indicativNomenclator;

    @Column(columnDefinition = "continut")
    private String continut;

    @Column(name = "data_start")
    private LocalDate dataStart;

    @Column(name = "data_end")
    private String dataEnd;

    @Column(columnDefinition = "observatii")
    private String observatii;




    @Column(name = "cutie")
    private Integer cutie;

    
    public Dosar() {
        // Constructor implicit necesar pentru Hibernate
    }


    @Column(name = "numar_file")
    private Integer numarFile;

    public Integer getNumarFile() { return numarFile; }
    public void setNumarFile(Integer numarFile) { this.numarFile = numarFile; }



	@Override
	public String toString() {
		return "Dosar [id=" + id + ", numarCriteriu=" + numarCriteriu + ", inventar=" + inventar
				+ ", indicativNomenclator=" + indicativNomenclator + ", continut=" + continut + ", dataStart="
				+ dataStart + ", dataEnd=" + dataEnd + ", observatii=" + observatii + ", cutie=" + cutie
				+ ", numarFile=" + numarFile + "]";
	}

	public String getNumarCriteriu() {
		return numarCriteriu;
	}
	public void setNumarCriteriu(String numarCriteriu) {
		this.numarCriteriu = numarCriteriu;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Inventar getInventar() {
		return inventar;
	}


	public void setInventar(Inventar inventar) {
		this.inventar = inventar;
	}


	public String getIndicativNomenclator() {
		return indicativNomenclator;
	}


	public void setIndicativNomenclator(String indicativNomenclator) {
		this.indicativNomenclator = indicativNomenclator;
	}


	public String getContinut() {
		return continut;
	}


	public void setContinut(String continut) {
		this.continut = continut;
	}


	public LocalDate getDataStart() {
		return dataStart;
	}


	public void setDataStart(LocalDate dataStart) {
		this.dataStart = dataStart;
	}





	public String getDataEnd() {
		return dataEnd;
	}
	public void setDataEnd(String dataEnd) {
		this.dataEnd = dataEnd;
	}


	public String getObservatii() {
		return observatii;
	}


	public void setObservatii(String observatii) {
		this.observatii = observatii;
	}








	public Integer getCutie() {
		return cutie;
	}


	public void setCutie(Integer cutie) {
		this.cutie = cutie;
	}


	public Dosar(Long id, String numarCriteriu, Inventar inventar, String indicativNomenclator, String continut, LocalDate dataStart,
			String dataEnd, String observatii,  Integer cutie) {
		super();
		this.id = id;
		this.numarCriteriu = numarCriteriu;
		this.inventar = inventar;
		this.indicativNomenclator = indicativNomenclator;
		this.continut = continut;
		this.dataStart = dataStart;
		this.dataEnd = dataEnd;
		this.observatii = observatii;
		
		this.cutie = cutie;
	}


   
}
