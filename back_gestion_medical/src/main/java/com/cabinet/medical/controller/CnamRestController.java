package com.cabinet.medical.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.model.Antecedant;
import com.cabinet.medical.model.CNAM;
import com.cabinet.medical.service.CnamMetier;
@RestController
@CrossOrigin(origins = "*")
public class CnamRestController {

	@Autowired
	private CnamMetier cnamMetier;

	@RequestMapping(value = "/cnam", method = RequestMethod.POST)
	public CNAM saveCnam(@RequestBody CNAM c) {
		return cnamMetier.saveCnam(c);
	}
	
	
	
	@RequestMapping(value = "/cnam/{mat}", method = RequestMethod.GET)
	public CNAM getCnam(@PathVariable String mat) throws EntiteNotFoundException {
		return cnamMetier.getCnam(mat);
	}
	@RequestMapping(value = "/cnam", method = RequestMethod.GET)
	public List<CNAM> getListCnam(){
		return cnamMetier.listCnam();
	}
	@RequestMapping(value = "/cnam", method = RequestMethod.PUT)
	public CNAM updateCnam(@RequestBody CNAM cnam ) {
		return cnamMetier.updateValCnam(cnam);
	}
	@RequestMapping(value = "/cnam/{mat}", method = RequestMethod.DELETE)
	public void deleteCnam(@PathVariable String mat) {
		cnamMetier.deleteCnam(mat);
	}
}
