package com.bvlsh.audit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvlsh.audit.assemblers.Assembler;
import com.bvlsh.audit.dao.OfficerDAO;
import com.bvlsh.audit.dao.sql.OfficerSQL;
import com.bvlsh.audit.dto.OfficerDTO;



@Service
public class OfficerService {


	@Autowired OfficerDAO officerDAO;
	
	public List<OfficerDTO> searchOfficer(String name, String surname) {
		OfficerSQL criterias = new OfficerSQL();
		criterias.setName(name);
		criterias.setSurname(surname);
		return new Assembler().officerListToDto(officerDAO.search(criterias));
	}

	 public List<OfficerDTO> queryOfficer(String query) {
	 		return new Assembler().officerListToDto(officerDAO.queryOfficer(query));
	 	}
}
