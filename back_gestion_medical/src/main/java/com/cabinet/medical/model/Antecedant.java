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
@Table(name = "ANTECEDANT")
public class Antecedant implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDANT")
	private Long idant;
	@Column(name = "CATEGANT")
	private String categant;
	@Column(name = "DESCANT",unique = true )
	private String descant;
	@JsonIgnore
	@ManyToMany(mappedBy = "antecedants")
	private Collection<Patient>patients;
	public Antecedant(Long idant, String categant, String descant) {
		super();
		this.idant = idant;
		this.categant = categant;
		this.descant = descant;
	}
	public Antecedant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdant() {
		return idant;
	}
	public void setIdant(Long idant) {
		this.idant = idant;
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
