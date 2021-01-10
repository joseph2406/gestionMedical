package com.cabinet.medical.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.model.CNAM;
import com.cabinet.medical.repository.ICnamDao;
@Service
@Transactional
public class CnamMetierImpl implements CnamMetier{
@Autowired
private ICnamDao cnamdao;
	@Override
	public CNAM saveCnam(CNAM c) throws EntiteTransactionException{
		// TODO Auto-generated method stub
		if(cnamdao.findById(c.getMatcnam())!=null){
			throw new EntiteTransactionException(c.getMatcnam());
		}
		return cnamdao.save(c);
	}

	@Override
	public CNAM getCnam(String cin) throws EntiteNotFoundException{
		// TODO Auto-generated method stub
		return cnamdao.findById(cin).orElseThrow(() -> new EntiteNotFoundException("Cnam"));
	}

}
