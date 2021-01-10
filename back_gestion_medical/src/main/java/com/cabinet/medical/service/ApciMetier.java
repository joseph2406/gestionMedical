package com.cabinet.medical.service;

import com.cabinet.medical.model.APCI;

public interface ApciMetier {
	public APCI saveApci(APCI apci);
	public APCI getApci(String code);
	public APCI updateAPCI(APCI apci);
}
