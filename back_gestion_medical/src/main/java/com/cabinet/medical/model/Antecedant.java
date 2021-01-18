package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Antecedant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	@Column(name = "CATEGANT")
	private String categant;
	@Column(name = "DESCANT",unique = true )
	private String descant;
	@JsonIgnore
	@ManyToMany(mappedBy = "antecedants")
	private Collection<Patient>patients;
	public Antecedant(long id, String categant, String descant) {
		super();
		this.id = id;
		this.categant = categant;
		this.descant = descant;
	}
	public Antecedant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategant() {
		return categant;
	}
	public void setCategant(String categant) {
		this.categant = categant;
	}
	public String getDescant() {
		return descant;
	}
	public void setDescant(String descant) {
		this.descant = descant;
	}
	public Collection<Patient> getPatients() {
		return patients;
	}
	public void setPatients(Collection<Patient> patients) {
		this.patients = patients;
	}
	
	
}
