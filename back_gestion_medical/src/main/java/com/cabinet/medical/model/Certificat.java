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
@Table(name = "Certificat")
public class Certificat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMCERT")
	private Long numcert;
	@Column(name = "DATECERT")
	private Date datecert;
	@Column(name = "COMCERT")
	private String comcert;
	@Column(name = "NBRJ")
	private int nbrj;
	@Column(name = "DATEREPOS")
	private Date daterepos;
	@Column(name = "ETATSANTE")
	private String etatsante;
	@Column(name = "PROFESSION")
	private String profession;
	@Column(name = "TYPCERT")
	private String typcert;
	@OneToOne
	@JoinColumn(name = "numcons")
	private Consultation consultation;
	public Certificat(Long numcert, Date datecert, String comcert, int nbrj, Date daterepos, String etatsante,
			String profession, String typcert) {
		super();
		this.numcert = numcert;
		this.datecert = datecert;
		this.comcert = comcert;
		this.nbrj = nbrj;
		this.daterepos = daterepos;
		this.etatsante = etatsante;
		this.profession = profession;
		this.typcert = typcert;
	}
	public Certificat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumcert() {
		return numcert;
	}
	public void setNumcert(Long numcert) {
		this.numcert = numcert;
	}
	public Date getDatecert() {
		return datecert;
	}
	public void setDatecert(Date datecert) {
		this.datecert = datecert;
	}
	public String getComcert() {
		return comcert;
	}
	public void setComcert(String comcert) {
		this.comcert = comcert;
	}
	public int getNbrj() {
		return nbrj;
	}
	public void setNbrj(int nbrj) {
		this.nbrj = nbrj;
	}
	public Date getDaterepos() {
		return daterepos;
	}
	public void setDaterepos(Date daterepos) {
		this.daterepos = daterepos;
	}
	public String getEtatsante() {
		return etatsante;
	}
	public void setEtatsante(String etatsante) {
		this.etatsante = etatsante;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getTypcert() {
		return typcert;
	}
	public void setTypcert(String typcert) {
		this.typcert = typcert;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	

}
