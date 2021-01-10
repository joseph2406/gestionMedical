package com.cabinet.medical.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.model.CNAM;
import com.cabinet.medical.service.CnamMetier;
@RestController
public class CnamRestController {

	@Autowired
	private CnamMetier cnamMetier;

	@RequestMapping(value = "/cnam", method = RequestMethod.POST)
	public CNAM saveCnam(@RequestBody CNAM c) throws EntiteTransactionException {
		// TODO Auto-generated method stub
		return cnamMetier.saveCnam(c);
	}
	@RequestMapping(value = "/cnam/{mat}", method = RequestMethod.GET)
	public CNAM getCnam(@PathVariable String mat) throws EntiteNotFoundException {
		// TODO Auto-generated method stub
		return cnamMetier.getCnam(mat);
	}
}
