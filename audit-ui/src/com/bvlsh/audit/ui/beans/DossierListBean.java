package com.bvlsh.audit.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bvlsh.audit.ui.api.security.ApiException;
import com.bvlsh.audit.ui.criterias.DossierReq;
import com.bvlsh.audit.ui.models.AuditStatusDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.models.RiskLevelDTO;
import com.bvlsh.audit.ui.models.StructureDTO;
import com.bvlsh.audit.ui.models.UserDTO;
import com.bvlsh.audit.ui.services.DossierService;
import com.bvlsh.audit.ui.services.UserService;
import com.bvlsh.audit.ui.services.UtilService;
import com.bvlsh.audit.ui.utils.Encryptor;
import com.bvlsh.audit.ui.utils.Messages;
import com.bvlsh.audit.ui.utils.Util;



@ManagedBean
@ViewScoped
public class DossierListBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	DossierDTO dossier;
	List<DossierDTO> dossiers;
	DossierDTO selectedDossier;
	DossierReq req;
	
	List<StructureDTO> structures;
	List<RiskLevelDTO> riskLevels;
	List<AuditStatusDTO> auditStatuses;
	List<UserDTO> users;
	

	
	public DossierDTO getDossier() {
		return dossier;
	}

	public void setDossier(DossierDTO dossier) {
		this.dossier = dossier;
	}

	public List<DossierDTO> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<DossierDTO> dossiers) {
		this.dossiers = dossiers;
	}

	public DossierDTO getSelectedDossier() {
		return selectedDossier;
	}

	public void setSelectedDossier(DossierDTO selectedDossier) {
		this.selectedDossier = selectedDossier;
	}

	public DossierReq getReq() {
		return req;
	}

	public void setReq(DossierReq req) {
		this.req = req;
	}

	public List<StructureDTO> getStructures() {
		return structures;
	}

	public void setStructures(List<StructureDTO> structures) {
		this.structures = structures;
	}

	public List<RiskLevelDTO> getRiskLevels() {
		return riskLevels;
	}

	public void setRiskLevels(List<RiskLevelDTO> riskLevels) {
		this.riskLevels = riskLevels;
	}

	public List<AuditStatusDTO> getAuditStatuses() {
		return auditStatuses;
	}

	public void setAuditStatuses(List<AuditStatusDTO> auditStatuses) {
		this.auditStatuses = auditStatuses;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
		

	@PostConstruct
	public void load() {

		this.riskLevels = new UtilService().loadRiskLevels();
		this.structures = new UtilService().loadStructures();
		this.auditStatuses = new UtilService().loadAuditStatuses();
		this.users = new UserService().loadUsers();
		init();
	}
	
	public void init() {
		this.req = new DossierReq();
		req.setMaxResult(40);
		this.dossier = new DossierDTO();
		this.selectedDossier = null;
		this.dossiers = new DossierService().searchDossier(req);
	}
	
	public void clear() {
		init();
	}
	
	public void search() {
		req.setMaxResult(1000);
		this.dossiers = new DossierService().searchDossier(req);
	}
	
	public void register() {
		try {			
			DossierDTO d = new DossierService().registerDossier(dossier);
			Util.redirect("ui/dossier.xhtml?dossier_id="+new Encryptor().encrypt(d.getId()+""));
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}catch(Exception e)
		{
			Messages.throwFacesMessage("Error ne sistem", 4);
			e.printStackTrace();
		}
	}
	
	public void view() {
		if(selectedDossier != null) 
		{
			Util.redirect("ui/dossier.xhtml?dossier_id="+new Encryptor().encrypt(selectedDossier.getId()+""));
		}else
		{
			Messages.throwFacesMessage("Zgjidhni dosjen!", 2);
		}
	}
	

}
