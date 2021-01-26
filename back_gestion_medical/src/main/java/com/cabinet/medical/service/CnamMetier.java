package com.cabinet.medical.service;


import java.util.List;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.model.CNAM;
public interface CnamMetier {
	public CNAM saveCnam(CNAM c);
	public CNAM getCnam(String mat) throws EntiteNotFoundException;
	public List<CNAM> listCnam();
	public CNAM updateValCnam(CNAM cnam);
	public void deleteCnam(String mat);
	

}
