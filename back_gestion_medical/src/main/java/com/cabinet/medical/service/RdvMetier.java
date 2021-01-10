package com.cabinet.medical.service;

import com.cabinet.medical.exception.EntiteNotFoundException;
import com.cabinet.medical.model.RDV;

public interface RdvMetier {
public RDV saveRDV(RDV r);
public RDV getRDV(long id) throws EntiteNotFoundException;
}
