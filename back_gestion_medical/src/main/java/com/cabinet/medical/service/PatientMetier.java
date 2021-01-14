package com.cabinet.medical.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.exception.NoDataFoundException;
import com.cabinet.medical.model.Patient;

public interface PatientMetier {
	
	public Patient savePatient(Patient p) throws EntiteTransactionException;
	public Page<Patient>listPatient(Pageable pageable) throws NoDataFoundException;
	public Patient getPatient(String cin) throws EntiteNotFoundException;
	public void deletePatient(String cin);
	public Patient updatePatient(Patient patient);
	public Page<Patient>listPatientValid(Pageable pageable) throws NoDataFoundException;
}
