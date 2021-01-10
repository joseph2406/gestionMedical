package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CONSULTATION")

public class Consultation implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMCONS")
	private Long numcons;
	@Column(name = "MOTIF")
	private String motif;
	@Column(name = "DATECONS")
	private Date datecons;
	@Column(name = "POIDS")
	private int poids;
	@Column(name = "TEMPERATURE")
	private double temperature;
	@Column(name = "TENSION")
	private double tension;
	@Column(name = "PERIMETRE")
	private double perimetre;
	@Column(name = "RESEXAMEN")
	private String resexamen;
	@OneToOne(mappedBy = "consultation")
	private Ordonnance ordonnance;
	@OneToOne(mappedBy = "consultation")
	private Recette recette;
	@OneToOne(mappedBy = "consultation")
	private LettreConfrere lettreConfrere;
	@OneToMany(mappedBy = "consultation")
	private Collection<Certificat> certificats;

	public Consultation(Long numcons, String motif, Date datecons, int poids, double temperature, double tension,
			double perimetre, String resexamen) {
		super();
		this.numcons = numcons;
		this.motif = motif;
		this.datecons = datecons;
		this.poids = poids;
		this.temperature = temperature;
		this.tension = tension;
		this.perimetre = perimetre;
		this.resexamen = resexamen;
	}

	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNumcons() {
		return numcons;
	}

	public void setNumcons(Long numcons) {
		this.numcons = numcons;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Date getDatecons() {
		return datecons;
	}

	public void setDatecons(Date datecons) {
		this.datecons = datecons;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getTension() {
		return tension;
	}

	public void setTension(double tension) {
		this.tension = tension;
	}

	public double getPerimetre() {
		return perimetre;
	}

	public void setPerimetre(double perimetre) {
		this.perimetre = perimetre;
	}

	public String getResexamen() {
		return resexamen;
	}

	public void setResexamen(String resexamen) {
		this.resexamen = resexamen;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public LettreConfrere getLettreConfrere() {
		return lettreConfrere;
	}

	public void setLettreConfrere(LettreConfrere lettreConfrere) {
		this.lettreConfrere = lettreConfrere;
	}

	public Collection<Certificat> getCertificats() {
		return certificats;
	}

	public void setCertificats(Collection<Certificat> certificats) {
		this.certificats = certificats;
	}

}
