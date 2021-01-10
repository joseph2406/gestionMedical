package com.cabinet.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabinet.medical.model.RDV;
@Repository
public interface IRdvDao extends JpaRepository<RDV, Long> {

	
}
