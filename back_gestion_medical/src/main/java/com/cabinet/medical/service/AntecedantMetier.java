package com.cabinet.medical.service;

import java.util.List;

import com.cabinet.medical.model.Antecedant;
import com.cabinet.medical.model.Patient;

public interface AntecedantMetier {

	public Antecedant createAntecedant(Antecedant antecedant);

	public List<Antecedant> getAll();

	public void update(Antecedant ant);

	public void remove(Antecedant ant);

	public List<Antecedant> getByCategorie(String categorie);

	public Antecedant getByDesc(String description);

	public List<Antecedant> getByPatient(Patient patient);
}
