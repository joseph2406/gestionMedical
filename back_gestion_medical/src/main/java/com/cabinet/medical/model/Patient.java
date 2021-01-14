package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.ws.rs.ext.ParamConverter.Lazy;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@Table(name = "PATIENT")
public class Patient implements Serializable {
	@Id
	@Column(name = "CIN")
	String cin;
	@Column(name = "NOMP")
	String nomp;
	@Column(name = "PRENOMP")
	String prenomp;
	@Column(name = "DATENAISSP")
	Date datenaissp;
	@Column(name = "DATECREAD")
	Date datecreaD;
	@Column(name = "SEXEP")
	String sexep;
	@Column(name = "PROFESSIONP")
	String professionp;
	@Column(name = "ADRESSEP")
	String adressep;
	@Column(name = "NUMTELP")
	String numtelp;
	@Column(name = "VALID")
	boolean valid;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("patient")
	private Collection<RDV> rdv;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("patient")
	private Collection<APCI> apci;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
	@JsonManagedReference
	private CNAM cnam;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "patient_antecedants")
	private Collection<Antecedant> antecedants;



	public Patient(String cin, String nomp, String prenomp, Date datenaissp, Date datecreaD, String sexep,
			String professionp, String adressep, String numtelp,boolean valid) {
		super();
		this.cin = cin;
		this.nomp = nomp;
		this.prenomp = prenomp;
		this.datenaissp = datenaissp;
		this.datecreaD = datecreaD;
		this.sexep = sexep;
		this.professionp = professionp;
		this.adressep = adressep;
		this.numtelp = numtelp;
		this.valid=valid;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNomp() {
		return nomp;
	}

	public void setNomp(String nomp) {
		this.nomp = nomp;
	}

	public String getPrenomp() {
		return prenomp;
	}

	public void setPrenomp(String prenomp) {
		this.prenomp = prenomp;
	}

	public Date getDatenaissp() {
		return datenaissp;
	}

	public void setDatenaissp(Date datenaissp) {
		this.datenaissp = datenaissp;
	}

	public Date getDatecreaD() {
		return datecreaD;
	}

	public void setDatecreaD(Date datecreaD) {
		this.datecreaD = datecreaD;
	}

	public String getSexep() {
		return sexep;
	}

	public void setSexep(String sexep) {
		this.sexep = sexep;
	}

	public String getProfessionp() {
		return professionp;
	}

	public void setProfessionp(String professionp) {
		this.professionp = professionp;
	}

	public String getAdressep() {
		return adressep;
	}

	public void setAdressep(String adressep) {
		this.adressep = adressep;
	}

	public String getNumtelp() {
		return numtelp;
	}

	public void setNumtelp(String numtelp) {
		this.numtelp = numtelp;
	}
	public Collection<RDV> getRdv() {
		return rdv;
	}

	public void setRdv(Collection<RDV> rdv) {
		this.rdv = rdv;
	}

	public Collection<APCI> getApci() {
		return apci;
	}

	public void setApci(Collection<APCI> apci) {
		this.apci = apci;
	}
	public CNAM getCnam() {
		return cnam;
	}
	public void setCnam(CNAM cnam) {
		this.cnam = cnam;
	}

	public Collection<Antecedant> getAntecedants() {
		return antecedants;
	}

	public void setAntecedants(Collection<Antecedant> antecedants) {
		this.antecedants = antecedants;
	}
	
	
}
