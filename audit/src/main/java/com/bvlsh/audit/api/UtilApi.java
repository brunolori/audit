package com.bvlsh.audit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bvlsh.audit.dto.AuditStatusDTO;
import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.dto.DocumentTypeDTO;
import com.bvlsh.audit.dto.DossierDTO;
import com.bvlsh.audit.dto.OfficerDTO;
import com.bvlsh.audit.dto.RiskLevelDTO;
import com.bvlsh.audit.dto.StructureDTO;
import com.bvlsh.audit.dto.UserDTO;
import com.bvlsh.audit.services.HelperService;

@RestController
@RequestMapping("/api/utils")
public class UtilApi {
	
	@Autowired HelperService helperService;
	
	@RequestMapping(value = "/loadRiskLevels", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadRiskLevels() {
		List<RiskLevelDTO> l = helperService.loadRiskLevels();
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loadAuditStatuses", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadAuditStatuses() {
		List<AuditStatusDTO> a = helperService.loadAuditStatuses();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loadDocTypes", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadDocTypes() {
		List<DocumentTypeDTO> d = helperService.loadDocTypes();
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loadStructures", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadStructures() {
		List<StructureDTO> s = helperService.loadStructures();
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@RequestMapping(value = "/findStructureById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findStructureById(@PathVariable(name = "id") Integer id) {
		StructureDTO str = helperService.findStructureById(id);
		return new ResponseEntity<>(str, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findRiskLevelByCode/{code}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findRiskLevelByCode(@PathVariable(name = "code") String code) {
		RiskLevelDTO riskLevel = helperService.findRiskLevelByCode(code);
		return new ResponseEntity<>(riskLevel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findAuditStatusByCode/{code}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findAuditStatusByCode(@PathVariable(name = "code") String code) {
		AuditStatusDTO auditStatus = helperService.findAuditStatusByCode(code);
		return new ResponseEntity<>(auditStatus, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findDocumentTypeByCode/{code}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findDocumentTypeByCode(@PathVariable(name = "code") String code) {
		DocumentTypeDTO doctype = helperService.findDocumentTypeByCode(code);
		return new ResponseEntity<>(doctype, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findUserById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findUserById(@PathVariable(name = "id") Integer id) {
		UserDTO user = helperService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findOfficerById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findOfficerById(@PathVariable(name = "id") Integer id) {
		OfficerDTO officer = helperService.findOfficerById(id);
		return new ResponseEntity<>(officer, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findDossierById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findDossierById(@PathVariable(name = "id") Integer id) {
		DossierDTO dossier = helperService.findDossierById(id);
		return new ResponseEntity<>(dossier, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/findDocumentById/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> findDocumentById(@PathVariable(name = "id") Integer id) {
		DocumentDTO document = helperService.findDocumentById(id);
		return new ResponseEntity<>(document, HttpStatus.OK);
	}
	
	
}
