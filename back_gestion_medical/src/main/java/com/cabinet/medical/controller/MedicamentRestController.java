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
import com.cabinet.medical.model.Medicament;
import com.cabinet.medical.service.IMedicamentMetier;

@RestController
public class MedicamentRestController {
	@Autowired
	IMedicamentMetier medicamentservice;

	@RequestMapping(value = "/medicaments", method = RequestMethod.POST)
	public Medicament savePatient(@RequestBody Medicament m) throws EntiteTransactionException {
		return medicamentservice.saveMedicament(m);
	}

	@RequestMapping(value = "/medicaments", method = RequestMethod.GET)

	public Page<Medicament> listMedicaments(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) throws NoDataFoundException {
		// TODO Auto-generated method stub
		return medicamentservice.listMedicaments(PageRequest.of(page, size));
	}

	@RequestMapping(value = "/medicaments/{numMed}", method = RequestMethod.GET)
	public Medicament getPatient(@PathVariable long numMed) throws EntiteNotFoundException {
		return medicamentservice.getMedicament(numMed);
	}

	@RequestMapping(value = "/medicaments", method = RequestMethod.PUT)
	public Medicament updatePatient(@RequestBody Medicament m) {
		return medicamentservice.updateMedicament(m);
	}
}
