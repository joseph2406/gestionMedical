package com.cabinet.medical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.medical.model.Antecedant;
import com.cabinet.medical.model.Patient;
import com.cabinet.medical.service.AntecedantMetier;

@RestController
@CrossOrigin(origins = "*")
public class AntecedantRestController {

	@Autowired
	AntecedantMetier antecedantMetier;

	@RequestMapping(value = "/antecedant", method = RequestMethod.POST)
	public Antecedant addAntecedant(@RequestBody Antecedant ant) {
		return antecedantMetier.createAntecedant(ant);
	}

	@RequestMapping(value = "/antecedant", method = RequestMethod.GET)
	public List<Antecedant> listAntecedant() {
		return antecedantMetier.getAll();
	}

	@RequestMapping(value = "/antecedant/{desc}", method = RequestMethod.GET)
	public Antecedant getbyDescription(@PathVariable String description) {
		return antecedantMetier.getByDesc(description);
	}

	@RequestMapping(value = "/antecedant/{patient}", method = RequestMethod.GET)
	public List<Antecedant> getbyPatient(@PathVariable Patient patient) {
		return antecedantMetier.getByPatient(patient);
	}

	@RequestMapping(value = "/antecedant/{categorie}", method = RequestMethod.GET)
	public List<Antecedant> getbyCategorie(@RequestParam String categorie) {
		return antecedantMetier.getByCategorie(categorie);
	}
}
