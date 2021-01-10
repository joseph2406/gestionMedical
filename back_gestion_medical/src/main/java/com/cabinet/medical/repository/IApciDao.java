package com.cabinet.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabinet.medical.model.APCI;
import com.cabinet.medical.model.Patient;
@Repository
public interface IApciDao extends JpaRepository<APCI, String> {
	
}
