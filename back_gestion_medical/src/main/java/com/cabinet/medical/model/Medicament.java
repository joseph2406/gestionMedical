package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Medicament")
public class Medicament implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMMED")
	private long nummed;
	@Column(name = "NOMMED")
	private String nommed;
	@Column(name = "DOSAGE")
	private String dosage;
	@Column(name = "CONTRIND")
	private String contrind;

	@OneToMany(mappedBy = "medicament")
	private Collection<OrdonnanceMed> medicamentsOrd;

	public Medicament(long nummed, String nommed, String dosage, String contrind) {
		super();
		this.nummed = nummed;
		this.nommed = nommed;
		this.dosage = dosage;
		this.contrind = contrind;
	}

	public Medicament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNummed() {
		return nummed;
	}

	public void setNummed(long nummed) {
		this.nummed = nummed;
	}

	public String getNommed() {
		return nommed;
	}

	public void setNommed(String nommed) {
		this.nommed = nommed;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getContrind() {
		return contrind;
	}

	public void setContrind(String contrind) {
		this.contrind = contrind;
	}

	public Collection<OrdonnanceMed> getMedicamentsOrd() {
		return medicamentsOrd;
	}

	public void setMedicamentsOrd(Collection<OrdonnanceMed> medicamentsOrd) {
		this.medicamentsOrd = medicamentsOrd;
	}
	
}
