package com.cabinet.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrdonnanceMed")
public class OrdonnanceMed implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMEDORD")
	private long idmedord;
	@ManyToOne
	@JoinColumn(name = "numord")
	private Ordonnance ordonnance;
	@ManyToOne
	@JoinColumn(name = "nummed")
	private Medicament medicament;
	@Column(name = "NBRFOISMED")
	private int nbrfoismed;
	@Column(name = "TYPEMED")
	private String typeMed;
	@Column(name = "QTEMED")
	private int qteMed;
	
	public OrdonnanceMed(long idmedord, int nbrfoismed, String typeMed,	int qteMed) {
		super();
		this.idmedord = idmedord;
		this.nbrfoismed = nbrfoismed;
		this.typeMed = typeMed;
		this.qteMed = qteMed;
	}

	public OrdonnanceMed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdmedord() {
		return idmedord;
	}

	public void setIdmedord(long idmedord) {
		this.idmedord = idmedord;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public int getNbrfoismed() {
		return nbrfoismed;
	}

	public void setNbrfoismed(int nbrfoismed) {
		this.nbrfoismed = nbrfoismed;
	}

	public String getTypeMed() {
		return typeMed;
	}

	public void setTypeMed(String typeMed) {
		this.typeMed = typeMed;
	}

	public int getQteMed() {
		return qteMed;
	}

	public void setQteMed(int qteMed) {
		this.qteMed = qteMed;
	}

}
