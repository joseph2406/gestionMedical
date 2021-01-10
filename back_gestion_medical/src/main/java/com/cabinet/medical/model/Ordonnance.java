package com.cabinet.medical.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ordonnance")

public class Ordonnance implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NUMORD")
	private long numord;
	@Column(name = "DATEORD")
	private Date dateord;
	@OneToOne
	@JoinColumn(name = "numcons")
	private Consultation consultation;

	@OneToMany(mappedBy = "ordonnance")
	private Collection<OrdonnanceMed> medicamentsOrd;

	public Ordonnance(Long numord, Date dateord) {
		super();
		this.numord = numord;
		this.dateord = dateord;
	}

	public Ordonnance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getNumord() {
		return numord;
	}

	public void setNumord(long numord) {
		this.numord = numord;
	}

	public Date getDateord() {
		return dateord;
	}

	public void setDateord(Date dateord) {
		this.dateord = dateord;
	}

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	public Collection<OrdonnanceMed> getMedicamentsOrd() {
		return medicamentsOrd;
	}

	public void setMedicamentsOrd(Collection<OrdonnanceMed> medicamentsOrd) {
		this.medicamentsOrd = medicamentsOrd;
	}

}
