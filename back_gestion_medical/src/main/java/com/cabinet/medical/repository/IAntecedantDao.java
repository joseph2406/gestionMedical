package com.cabinet.medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabinet.medical.model.Antecedant;
import com.cabinet.medical.model.Patient;
@Repository
public interface IAntecedantDao extends JpaRepository<Antecedant, Long> {

	public Antecedant findByCategant(String categant);
	public List<Antecedant> findByDescant(String descant);
	public List<Antecedant> findByPatients(String cinPatient);

	
	
}
