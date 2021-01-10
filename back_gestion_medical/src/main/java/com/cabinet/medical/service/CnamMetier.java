package com.cabinet.medical.service;


import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.model.CNAM;
public interface CnamMetier {
	public CNAM saveCnam(CNAM c) throws EntiteTransactionException;
	public CNAM getCnam(String c) throws EntiteNotFoundException;

}
