package com.cabinet.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabinet.medical.model.APCI;
import com.cabinet.medical.service.ApciMetier;

@RestController
public class ApciRestController {
@Autowired
ApciMetier apciMetier;
@RequestMapping(value = "/apci", method = RequestMethod.POST)
public APCI saveApci(@RequestBody APCI c) {
	// TODO Auto-generated method stub
	return apciMetier.saveApci(c);
}
@RequestMapping(value = "/apci/{code}", method = RequestMethod.GET)
public APCI getApci(@PathVariable String code) {
	// TODO Auto-generated method stub
	return apciMetier.getApci(code);
}
}
