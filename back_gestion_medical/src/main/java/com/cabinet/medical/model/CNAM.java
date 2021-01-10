package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "CNAM")

public class CNAM implements Serializable {

	@Id
	@Column(name = "MATCNAM")
	private String matcnam;
	@Column(name = "DATEDEBVALID")
	private Date datedebvalid;
	@Column(name = "DATEFINVALID")
	private Date datefinvalid;
	@Column(name = "TYPECNAM")
	private String typecnam;
	@Column(name = "AFF")
	private String aff;
	@OneToOne
	@JoinColumn(name = "cin")
	@JsonBackReference
	private Patient patient;
	public CNAM(String matcnam, Date datedebvalid, Date datefinvalid, String typecnam, String aff, Patient patient) {
		this.matcnam = matcnam;
		this.datedebvalid = datedebvalid;
		this.datefinvalid = datefinvalid;
		this.typecnam = typecnam;
		this.aff = aff;
		this.patient=patient;
	}
	public CNAM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMatcnam() {
		return matcnam;
	}
	public void setMatcnam(String matcnam) {
		this.matcnam = matcnam;
	}
	public Date getDatedebvalid() {
		return datedebvalid;
	}
	public void setDatedebvalid(Date datedebvalid) {
		this.datedebvalid = datedebvalid;
	}
	public Date getDatefinvalid() {
		return datefinvalid;
	}
	public void setDatefinvalid(Date datefinvalid) {
		this.datefinvalid = datefinvalid;
	}
	public String getTypecnam() {
		return typecnam;
	}
	public void setTypecnam(String typecnam) {
		this.typecnam = typecnam;
	}
	public String getAff() {
		return aff;
	}
	public void setAff(String aff) {
		this.aff = aff;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	

}
