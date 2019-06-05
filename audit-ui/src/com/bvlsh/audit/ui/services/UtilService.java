package com.bvlsh.audit.ui.services;

import java.util.List;
import com.bvlsh.audit.ui.api.clients.UtilClient;
import com.bvlsh.audit.ui.models.AuditStatusDTO;
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.models.DocumentTypeDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.models.OfficerDTO;
import com.bvlsh.audit.ui.models.RiskLevelDTO;
import com.bvlsh.audit.ui.models.StructureDTO;
import com.bvlsh.audit.ui.models.UserDTO;

public class UtilService {

	public List<RiskLevelDTO> loadRiskLevels() {
		return new UtilClient().loadRiskLevels();
	}

	public List<AuditStatusDTO> loadAuditStatuses() {
		return new UtilClient().loadAuditStatuses();
	}

	public List<DocumentTypeDTO> loadDocTypes() {
		return new UtilClient().loadDocTypes();
	}

	public List<StructureDTO> loadStructures() {
		return new UtilClient().loadStructures();
	}

	public StructureDTO findStructureById(Integer id) {
		return new UtilClient().findStructureById(id);
	}
	
	public RiskLevelDTO findRiskLevelByCode(String code)
	{
		return new UtilClient().findRiskLevelByCode(code);
	}
	
	public AuditStatusDTO findAuditStatusByCode(String code)
	{
		return new UtilClient().findAuditStatusByCode(code);
	}
	
	public DocumentTypeDTO findDocumentTypeByCode(String code) {
		return new UtilClient().findDocumentTypeByCode(code);
	}

	public UserDTO findUserById(Integer id) {
		return new UtilClient().findUserById(id);
	}	
	public OfficerDTO findOfficerById(Integer id)
	{
		return new UtilClient().findOfficerById(id);
	}
	public DossierDTO findDossierById(Integer id) {
		return new UtilClient().findDossierById(id);
	}
	
	public DocumentDTO findDocumentById(Integer id) {
		return new UtilClient().findDocumentById(id);
	}	
	
}
