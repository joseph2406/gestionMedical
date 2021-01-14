package com.cabinet.medical.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabinet.medical.model.Patient;
@Repository
public interface IPatientDao extends JpaRepository<Patient, String> {
public Patient findByCin(String cin);
@Query("select p from Patient p where p.valid=true")
public Page<Patient> listPatientValid(Pageable pageable);
}
