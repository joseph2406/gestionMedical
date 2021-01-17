package com.cabinet.medical.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabinet.medical.model.Medicament;

@Repository
public interface IMedicamentDao extends JpaRepository<Medicament, String> {
	public Medicament findByNummed(long nummed);

	@Query("select m from Medicament m ")
	public Page<Medicament> listMedicaments(Pageable pageable);
}
