package com.cabinet.medical.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.model.RDV;
import com.cabinet.medical.repository.IRdvDao;
@Service
@Transactional
public class RdvMetierImpl implements RdvMetier {
@Autowired
	private IRdvDao rdvdao;
	@Override
	public RDV saveRDV(RDV r){
		// TODO Auto-generated method stub
		return rdvdao.save(r);
	}

	@Override
	public RDV getRDV(long id) throws EntiteNotFoundException{
		// TODO Auto-generated method stub
		return rdvdao.findById(id).orElseThrow(() -> new EntiteNotFoundException("RendezVous"));
	}

}
