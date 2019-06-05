package com.bvlsh.audit.ui.services;

import java.util.List;

import com.bvlsh.audit.ui.api.clients.OfficerClient;
import com.bvlsh.audit.ui.models.OfficerDTO;

public class OfficerService {
	
	public List<OfficerDTO> queryOfficer(String nameSurname) {
		return new OfficerClient().queryOfficer(nameSurname);
	}
	
	public List<OfficerDTO> searchOfficer(String name,String surname) {
		return new OfficerClient().searchOfficer(name, surname);
	}

}
