package com.cabinet.medical.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabinet.medical.model.CNAM;
@Repository
public interface ICnamDao extends JpaRepository<CNAM, String> {
//public CNAM findByMatcnam(String mat);
}
