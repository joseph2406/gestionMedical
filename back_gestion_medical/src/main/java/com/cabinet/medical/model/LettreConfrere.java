package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "LettreConfrere")
public class LettreConfrere implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMCONF")
	private long numconf;
	@Column(name = "NOMCONF")
	private String nomconf;
	@Column(name = "PRECONF")
	private String preconf;
	@Column(name = "ADRESSECONF")
	private String adresseconf;
	@Column(name = "NUMTELCONF")
	private String numtelconf;
	@Column(name = "SPEC")
	private String spec;
	@Column(name = "ETATPAT")
	private String etatpat;
	@Column(name = "DATECONF")
	private Date dateconf;
	@OneToOne
	@JoinColumn(name = "numcons")
	private Consultation consultation;
	public LettreConfrere(long numconf, String nomconf, String preconf, String adresseconf, String numtelconf,
			String spec, String etatpat, Date dateconf) {
		super();
		this.numconf = numconf;
		this.nomconf = nomconf;
		this.preconf = preconf;
		this.adresseconf = adresseconf;
		this.numtelconf = numtelconf;
		this.spec = spec;
		this.etatpat = etatpat;
		this.dateconf = dateconf;
	}
	public LettreConfrere() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getNumconf() {
		return numconf;
	}
	public void setNumconf(long numconf) {
		this.numconf = numconf;
	}
	public String getNomconf() {
		return nomconf;
	}
	public void setNomconf(String nomconf) {
		this.nomconf = nomconf;
	}
	public String getPreconf() {
		return preconf;
	}
	public void setPreconf(String preconf) {
		this.preconf = preconf;
	}
	public String getAdresseconf() {
		return adresseconf;
	}
	public void setAdresseconf(String adresseconf) {
		this.adresseconf = adresseconf;
	}
	public String getNumtelconf() {
		return numtelconf;
	}
	public void setNumtelconf(String numtelconf) {
		this.numtelconf = numtelconf;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getEtatpat() {
		return etatpat;
	}
	public void setEtatpat(String etatpat) {
		this.etatpat = etatpat;
	}
	public Date getDateconf() {
		return dateconf;
	}
	public void setDateconf(Date dateconf) {
		this.dateconf = dateconf;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

}
