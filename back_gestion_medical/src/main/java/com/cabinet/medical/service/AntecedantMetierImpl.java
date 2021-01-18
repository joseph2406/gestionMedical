package com.cabinet.medical.service;

import java.util.List;
import java.util.Optional;

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
	public void remove(long id) {
		antecedantDao.deleteById(id);
	}

	@Override
	public Optional<Antecedant> getByIdant(long id) {
		return antecedantDao.findById(id);
	}

	@Override
	public Antecedant getByDesc(String description) {
		return (Antecedant) antecedantDao.findByDescant(description);
	}

	@Override
	public List<Antecedant> getByPatient(String cinPatient) {
	
		return antecedantDao.findByPatients(cinPatient);
	}

}
