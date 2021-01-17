package com.cabinet.medical.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.exception.NoDataFoundException;
import com.cabinet.medical.model.Medicament;
import com.cabinet.medical.model.Patient;

public interface IMedicamentMetier {
	public Medicament saveMedicament(Medicament m) throws EntiteTransactionException;

	public Page<Medicament> listMedicaments(Pageable pageable) throws NoDataFoundException;

	public Medicament getMedicament(long numMed) throws EntiteNotFoundException;

	public void deleteMedicament(long numMed);

	public Medicament updateMedicament(Medicament m);

}
