package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "APCI")
public class APCI implements Serializable{
	@Id
	@Column(name = "CODEAP")
	private String codeap;
	@Column(name = "DATEDAP")
	private Date datedap;
	@Column(name = "DATEFAP")
	private Date datefap;
	@Column(name = "DESCRIPTION")
	private String description;
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "cin")
	@JsonIgnoreProperties("apci")
	private Patient patient;
	public APCI(String codeap, Date datedap, Date datefap, String description,Patient patient) {
		this.codeap = codeap;
		this.datedap = datedap;
		this.datefap = datefap;
		this.description = description;
		this.patient=patient;
	}
	public APCI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCodeap() {
		return codeap;
	}
	public void setCodeap(String codeap) {
		this.codeap = codeap;
	}
	public Date getDatedap() {
		return datedap;
	}
	public void setDatedap(Date datedap) {
		this.datedap = datedap;
	}
	public Date getDatefap() {
		return datefap;
	}
	public void setDatefap(Date datefap) {
		this.datefap = datefap;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
}
