package com.cabinet.medical.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.medical.model.APCI;
import com.cabinet.medical.repository.IApciDao;
@Service
@Transactional
public class ApciMetierImpl implements ApciMetier {
@Autowired
IApciDao apcidao;
	@Override
	public APCI saveApci(APCI apci) {
		// TODO Auto-generated method stub
		return apcidao.save(apci);
	}

	@Override
	public APCI getApci(String code) {
		// TODO Auto-generated method stub
		return apcidao.findById(code).get();
	}

	@Override
	public APCI updateAPCI(APCI apci) {
		// TODO Auto-generated method stub
		return apcidao.save(apci);
	}

}
