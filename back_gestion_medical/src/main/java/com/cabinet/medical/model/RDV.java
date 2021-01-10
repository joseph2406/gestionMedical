package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "RDV")
public class RDV implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDRDV")
	private long idredv;
	@Column(name = "DATERDV")
	private Date daterdv;
	@Column(name = "HEURERDV")
	private Date heure;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cin")
	@JsonIgnoreProperties("rdv")
	private Patient patient;
	public RDV(long idredv, Date daterdv, Date heure,Patient patient) {
		this.idredv = idredv;
		this.daterdv = daterdv;
		this.heure = heure;
		this.patient=patient;
	}
	public RDV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getIdredv() {
		return idredv;
	}
	public void setIdredv(long idredv) {
		this.idredv = idredv;
	}
	public Date getDaterdv() {
		return daterdv;
	}
	public void setDaterdv(Date daterdv) {
		this.daterdv = daterdv;
	}
	public Date getHeure() {
		return heure;
	}
	public void setHeure(Date heure) {
		this.heure = heure;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
