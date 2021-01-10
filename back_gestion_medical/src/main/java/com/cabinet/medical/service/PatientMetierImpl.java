package com.cabinet.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.exception.NoDataFoundException;
import com.cabinet.medical.model.Patient;
import com.cabinet.medical.repository.IPatientDao;

@Service
@Transactional
public class PatientMetierImpl implements PatientMetier {
	@Autowired
	private IPatientDao patientdao;

	@Override
	public Patient savePatient(Patient p) throws EntiteTransactionException {
		// TODO Auto-generated method stub
		
		  if (patientdao.findByCin(p.getCin())!=null) { throw new
		  EntiteTransactionException(p.getPrenomp()); }
		 
		return patientdao.save(p);
	}

	@Override
	public List<Patient> listPatient() throws NoDataFoundException{
		// TODO Auto-generated method stub
		List<Patient> lp=patientdao.findAll();
		 if (lp.isEmpty()) {

	            throw new NoDataFoundException();
	        }
		 return lp;
	}

	@Override
	public Patient getPatient(String cin) throws EntiteNotFoundException {
		// TODO Auto-generated method stub
		return patientdao.findById(cin).orElseThrow(() -> new EntiteNotFoundException("patient"));
		
	}

	@Override
	public void deletePatient(String cin) {
		// TODO Auto-generated method stub
		patientdao.deleteById(cin);
		
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientdao.save(patient);
	}
}
