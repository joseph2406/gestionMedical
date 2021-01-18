package com.cabinet.medical.service;

import java.util.List;
import java.util.Optional;

import com.cabinet.medical.model.Antecedant;

public interface AntecedantMetier {

	public Antecedant createAntecedant(Antecedant antecedant);

	public List<Antecedant> getAll();

	public void update(Antecedant ant);

	public void remove(long id);

	public Optional<Antecedant> getByIdant(long id);

	public Antecedant getByDesc(String description);

	public List<Antecedant> getByPatient(String cin);
}
