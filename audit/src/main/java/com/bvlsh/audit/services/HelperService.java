package com.bvlsh.audit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bvlsh.audit.assemblers.Assembler;
import com.bvlsh.audit.dao.CrudDAO;
import com.bvlsh.audit.dto.AuditStatusDTO;
import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.dto.DocumentTypeDTO;
import com.bvlsh.audit.dto.DossierDTO;
import com.bvlsh.audit.dto.OfficerDTO;
import com.bvlsh.audit.dto.RiskLevelDTO;
import com.bvlsh.audit.dto.StructureDTO;
import com.bvlsh.audit.dto.UserDTO;
import com.bvlsh.audit.entities.AuditStatus;
import com.bvlsh.audit.entities.Document;
import com.bvlsh.audit.entities.DocumentType;
import com.bvlsh.audit.entities.Dossier;
import com.bvlsh.audit.entities.Officer;
import com.bvlsh.audit.entities.RiskLevel;
import com.bvlsh.audit.entities.Structure;
import com.bvlsh.audit.entities.User;

@Service
public class HelperService {
	
	@Autowired CrudDAO crudDAO;
	
	public List<RiskLevelDTO> loadRiskLevels(){
		return new Assembler().riskLevelListToDto(crudDAO.loadRiskLevels());
	}

	 public List<AuditStatusDTO> loadAuditStatuses(){
		 return new Assembler().auditStatusListToDto(crudDAO.loadAuditStatuses());
	 }
	 
	 public List<DocumentTypeDTO> loadDocTypes(){
		 return new Assembler().docTypeListToDto(crudDAO.loadDocTypes());
	 }
	 
	 public List<StructureDTO> loadStructures(){
		 return new Assembler().structureListToDto(crudDAO.loadStructures());
	 }
	 
	 public StructureDTO findStructureById(Integer id){
		 return new Assembler().toDto(crudDAO.findByKey(Structure.class, id));
	 }
	
	 public RiskLevelDTO findRiskLevelByCode(String code) {
		 return new Assembler().toDto(crudDAO.findByKey(RiskLevel.class, code));
	 }
	 
	 public AuditStatusDTO findAuditStatusByCode(String code) {
		 return new Assembler().toDto(crudDAO.findByKey(AuditStatus.class, code));
	 }

     public DocumentTypeDTO findDocumentTypeByCode(String code) {
    	 return new Assembler().toDto(crudDAO.findByKey(DocumentType.class, code));
     }

     public UserDTO findUserById(Integer id) {
    	 return new Assembler().toDto(crudDAO.findByKey(User.class, id));
     }
     
     public OfficerDTO findOfficerById(Integer id) {
    	 return new Assembler().toDto(crudDAO.findByKey(Officer.class, id));
     }
     
     public DossierDTO findDossierById(Integer id) {
    	 return new Assembler().toDto(crudDAO.findByKey(Dossier.class, id));
     }
     
     public DocumentDTO findDocumentById(Integer id) {
    	 return new Assembler().toDto(crudDAO.findByKey(Document.class,id));
     }
     
}
