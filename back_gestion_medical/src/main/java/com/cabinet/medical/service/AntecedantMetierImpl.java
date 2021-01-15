package com.cabinet.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabinet.medical.model.Antecedant;
import com.cabinet.medical.model.Patient;
import com.cabinet.medical.repository.IAntecedantDao;

@Service
@Transactional
public class AntecedantMetierImpl implements AntecedantMetier {

	@Autowired
	IAntecedantDao antecedantDao;

	@Override
	public Antecedant createAntecedant(Antecedant antecedant) {
		return antecedantDao.save(antecedant);
	}

	@Override
	public List<Antecedant> getAll() {
		return antecedantDao.findAll();
	}

	@Override
	public void update(Antecedant ant) {
		antecedantDao.save(ant);
	}

	@Override
	public void remove(Antecedant ant) {
		antecedantDao.delete(ant);
	}

	@Override
	public List<Antecedant> getByCategorie(String categorie) {
		return antecedantDao.findByCategant(categorie);
	}

	@Override
	public Antecedant getByDesc(String description) {
		return (Antecedant) antecedantDao.findByDescant(description);
	}

	@Override
	public List<Antecedant> getByPatient(Patient patient) {
		return antecedantDao.findByPatients(patient);
	}

}
