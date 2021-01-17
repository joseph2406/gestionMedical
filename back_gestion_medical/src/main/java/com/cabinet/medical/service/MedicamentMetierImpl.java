package com.cabinet.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.exception.EntiteTransactionException;
import com.cabinet.medical.exception.NoDataFoundException;
import com.cabinet.medical.model.Medicament;
import com.cabinet.medical.model.Patient;
import com.cabinet.medical.repository.IMedicamentDao;

@Service
@Transactional
public class MedicamentMetierImpl implements IMedicamentMetier {
	@Autowired
	private IMedicamentDao medicamentDao;

	@Override
	public Medicament saveMedicament(Medicament m) throws EntiteTransactionException {
		if (medicamentDao.findByNummed(m.getNummed()) != null) {
			throw new EntiteTransactionException(m.getNommed());
		}

		return medicamentDao.save(m);
	}

	@Override
	public Page<Medicament> listMedicaments(Pageable pageable) throws NoDataFoundException {
		Page<Medicament> lp = medicamentDao.listMedicaments(pageable);
		if (lp.isEmpty()) {

			throw new NoDataFoundException();
		}
		return lp;
	}

	@Override
	public Medicament getMedicament(long numMed) throws EntiteNotFoundException {
		if (medicamentDao.findByNummed(numMed) == null) {
			throw new EntiteNotFoundException("Medicament");
		} else
			return medicamentDao.findByNummed(numMed);
	}

	@Override
	public void deleteMedicament(long numMed)  {
		Medicament medicament = null;
		try {
			medicament = getMedicament(numMed);
		} catch (EntiteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (medicament != null) {
			 
			medicamentDao.delete(medicament);
		}
		 

		 
	}

	@Override
	public Medicament updateMedicament(Medicament m) {
		return medicamentDao.save(m);
	}

}