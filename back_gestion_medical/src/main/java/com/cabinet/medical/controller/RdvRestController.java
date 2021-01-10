package com.cabinet.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.model.RDV;
import com.cabinet.medical.service.RdvMetier;

@RestController
public class RdvRestController {
	@Autowired
private RdvMetier rdvMetier;
@RequestMapping(value = "/rendezvous", method = RequestMethod.POST)
public RDV saveRDV(@RequestBody RDV r) {
	// TODO Auto-generated method stub
	return rdvMetier.saveRDV(r);
}
@RequestMapping(value = "/rendezvous/{id}", method = RequestMethod.GET)
public RDV getRDV(@PathVariable Long id) throws EntiteNotFoundException {
	// TODO Auto-generated method stub
	return rdvMetier.getRDV(id);
}
}
