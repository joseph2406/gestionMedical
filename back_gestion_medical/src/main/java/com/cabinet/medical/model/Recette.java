package com.cabinet.medical.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "RECETTE")
public class Recette implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMMOUV")
	private long nummouv;
	@Column(name = "TARIF")
	private int tarif;
	@Column(name = "TOTCONS")
	private int totcons;
	@OneToOne
	@JoinColumn(name = "numcons")
	private Consultation consultation;
	public Recette(long nummouv, int tarif, int totcons) {
		super();
		this.nummouv = nummouv;
		this.tarif = tarif;
		this.totcons = totcons;
	}
	public Recette() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getNummouv() {
		return nummouv;
	}
	public void setNummouv(long nummouv) {
		this.nummouv = nummouv;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public int getTotcons() {
		return totcons;
	}
	public void setTotcons(int totcons) {
		this.totcons = totcons;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	
}