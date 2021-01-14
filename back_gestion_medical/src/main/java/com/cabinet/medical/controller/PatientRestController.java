package com.cabinet.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.exception.NoDataFoundException;
import com.cabinet.medical.model.Patient;
import com.cabinet.medical.service.PatientMetier;
@CrossOrigin(origins = "*")
@RestController
public class PatientRestController {
	@Autowired
	PatientMetier patientservice;

	@RequestMapping(value = "/patients", method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient p) throws EntiteTransactionException {
		return patientservice.savePatient(p);
	}
	@RequestMapping(value = "/patients", method = RequestMethod.GET)

	public Page<Patient> listPatient(@RequestParam(name = "page", defaultValue = "0") int page,
	@RequestParam(name = "size", defaultValue = "5") int size) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return patientservice.listPatientValid(PageRequest.of(page, size));
	}
	@RequestMapping(value = "/patients/{cin}", method = RequestMethod.GET)
	public Patient getPatient(@PathVariable String cin) throws EntiteNotFoundException {
		return patientservice.getPatient(cin);
	}
	@RequestMapping(value = "/patients/{cin}", method = RequestMethod.DELETE)
	public void deletePatient(@PathVariable String cin) {
		patientservice.deletePatient(cin);
	}
	@RequestMapping(value = "/patients", method = RequestMethod.PUT)
	public Patient updatePatient(@RequestBody Patient p) {
		return patientservice.updatePatient(p);
	}
}

