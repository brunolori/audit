package com.bvlsh.audit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvlsh.audit.dto.OfficerDTO;
import com.bvlsh.audit.services.OfficerService;


@RestController
@RequestMapping("/api/officer")
public class OfficerApi {
	
	@Autowired OfficerService officerService;
	
	@RequestMapping(value = "/searchOfficer", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> searchOfficer(@RequestParam(name = "name", required=false) String name,
			@RequestParam(name = "surname", required=false) String surname) {
		List<OfficerDTO> o = officerService.searchOfficer(name, surname);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queryOfficer", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> queryOfficer(@RequestParam(name = "query") String query) {
		List<OfficerDTO> o = officerService.queryOfficer(query);
		return new ResponseEntity<>(o, HttpStatus.OK);
	}

}
