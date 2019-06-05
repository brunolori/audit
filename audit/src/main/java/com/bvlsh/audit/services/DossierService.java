package com.bvlsh.audit.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvlsh.audit.api.req.DossierReq;
import com.bvlsh.audit.assemblers.Assembler;
import com.bvlsh.audit.assemblers.RequestAssembler;
import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.dao.CrudDAO;
import com.bvlsh.audit.dao.DossierDAO;
import com.bvlsh.audit.dao.UserDAO;
import com.bvlsh.audit.dao.sql.DossierSQL;
import com.bvlsh.audit.dto.AuditNotificationStartDTO;
import com.bvlsh.audit.dto.AuthorizationDTO;
import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.dto.DossierDTO;
import com.bvlsh.audit.dto.FieldEvidenceDTO;
import com.bvlsh.audit.dto.ObservationDTO;
import com.bvlsh.audit.dto.OfficerDTO;
import com.bvlsh.audit.dto.RecommandationDTO;
import com.bvlsh.audit.dto.RestrictionProposalDTO;
import com.bvlsh.audit.entities.AuditNotificationStart;
import com.bvlsh.audit.entities.AuditStatus;
import com.bvlsh.audit.entities.Authorization;
import com.bvlsh.audit.entities.Dossier;
import com.bvlsh.audit.entities.FieldEvidence;
import com.bvlsh.audit.entities.Observation;
import com.bvlsh.audit.entities.Officer;
import com.bvlsh.audit.entities.Recommandation;
import com.bvlsh.audit.entities.RestrictionProposal;
import com.bvlsh.audit.entities.RiskLevel;
import com.bvlsh.audit.entities.Structure;
import com.bvlsh.audit.entities.User;
import com.bvlsh.audit.exceptions.AppException;
import com.bvlsh.audit.utils.StringUtil;

@Service
@Transactional
public class DossierService {

	@Autowired CrudDAO crudDAO;
	@Autowired UserDAO userDAO;
	@Autowired DossierDAO dossierDAO;

	public DossierDTO create(DossierDTO dto, String uname) {

		if (dto.getStructure() == null || dto.getStructure().getId() <= 0) {
			throw new AppException("Zgjidh strukturën");
		}
		if (dto.getRiskLevel() == null || !StringUtil.isValid(dto.getRiskLevel().getCode())) {
			throw new AppException("Zgjidh nivelin e riskut");
		}
		if (dto.getAuditingStatus() == null || !StringUtil.isValid(dto.getAuditingStatus().getCode())) {
			throw new AppException("Zgjidh statusin e auditimit");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		Dossier d = new Dossier();
		d.setAuditingStatus(new AuditStatus(dto.getAuditingStatus().getCode()));
		d.setCreateTime(time);
		d.setCreateUser(user);
		d.setDescription(dto.getDescription());
		d.setDossierNo(dto.getDossierNo());
		d.setIsDeleted(IStatus.NO);
		d.setRiskLevel(new RiskLevel(dto.getRiskLevel().getCode()));
		d.setStructure(new Structure(dto.getStructure().getId()));

		d = crudDAO.create(d);

		Authorization a = new Authorization();
		a.setDossier(d);
		a.setIsDeleted(IStatus.NO);

		a = crudDAO.create(a);

		AuditNotificationStart ans = new AuditNotificationStart();

		ans.setDossier(d);
		ans.setIsDeleted(IStatus.NO);

		ans = crudDAO.create(ans);		

		return new Assembler().toDto(d);
	}

	public DossierDTO update(DossierDTO dto, String uname) {

		if (dto.getStructure() == null || dto.getStructure().getId() <= 0) {
			throw new AppException("Zgjidh strukturën!");
		}
		if (dto.getRiskLevel() == null || !StringUtil.isValid(dto.getRiskLevel().getCode())) {
			throw new AppException("Zgjidh nivelin e riskut!");
		}
		if (dto.getAuditingStatus() == null || !StringUtil.isValid(dto.getAuditingStatus().getCode())) {
			throw new AppException("Zgjidh statusin e auditimit!");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		Dossier d = crudDAO.findByKey(Dossier.class, dto.getId());
		d.setAuditingStatus(new AuditStatus(dto.getAuditingStatus().getCode()));
		d.setDescription(dto.getDescription());
		d.setDossierNo(dto.getDossierNo());
		d.setRiskLevel(new RiskLevel(dto.getRiskLevel().getCode()));
		d.setStructure(new Structure(dto.getStructure().getId()));
		d.setUpdateTime(time);
		d.setUpdateUser(user);

		d = crudDAO.update(d);

		return new Assembler().toDto(d);

	}

	public AuthorizationDTO update(AuthorizationDTO dto, String uname) {
		if (dto.getOfficers() == null || dto.getOfficers().isEmpty()) {

			throw new AppException("Zgjidhni oficerin");
		}

		if (dto.getAuditingPeriodStart() == null) {

			throw new AppException("Zgjidhni datën e fillimit!");
		}

		if (dto.getAuditingPeriodEnd() == null) {

			throw new AppException("Zgjidhni datën e mbarimit!");
		}
		if (dto.getAuditingExecutionDate() == null) {

			throw new AppException("Zgjidhni oficerin");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		Authorization a = crudDAO.findByKey(Authorization.class, dto.getId());

		a.setAuditingExecutionDate(dto.getAuditingExecutionDate());
		a.setAuditingPeriodEnd(dto.getAuditingPeriodEnd());
		a.setAuditingPeriodStart(dto.getAuditingPeriodStart());
		a.setAuthorizationNo(dto.getAuthorizationNo());

		a.setOfficers(new ArrayList<>());
		for (OfficerDTO o : dto.getOfficers()) {
			Officer of = new Officer(o.getId());
			a.getOfficers().add(of);
		}

		a.setProjectEndDate(dto.getProjectEndDate());
		a.setUpdateTime(time);
		a.setUpdateUser(user);
		if (a.getUpdateUser() == null) {
			a.setCreateUser(user);
			a.setCreateTime(time);
		}

		a = crudDAO.update(a);

		return new Assembler().toDto(a);
	}

	public AuditNotificationStartDTO update(AuditNotificationStartDTO dto, String uname) {

		if (dto.getAuditStartTime() == null) {

			throw new AppException("Zgjidhni datën e startimit të auditit!");
		}

		if (dto.getAuditPeriodStart() == null) {

			throw new AppException("Zgjidhni datën e fillimit!");
		}

		if (dto.getAuditPeriodEnd() == null) {

			throw new AppException("Zgjidhni datën e mbarimit!");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		AuditNotificationStart ans = crudDAO.findByKey(AuditNotificationStart.class, dto.getId());

		ans.setAuditPeriodStart(dto.getAuditPeriodStart());
		ans.setAuditPeriodEnd(dto.getAuditPeriodEnd());
		ans.setAuditStartTime(dto.getAuditStartTime());
		ans.setUpdateTime(time);
		ans.setUpdateUser(user);

		if (ans.getUpdateUser() == null) {
			ans.setCreateUser(user);
			ans.setCreateTime(time);
		}

		ans = crudDAO.update(ans);

		return new Assembler().toDto(ans);
	}

	public FieldEvidenceDTO update(FieldEvidenceDTO dto, String uname) {

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		FieldEvidence fv = crudDAO.findByKey(FieldEvidence.class, dto.getId());

		fv.setNotes(dto.getNotes());
		fv.setUpdateTime(time);
		fv.setUpdateUser(user);
		if (fv.getUpdateUser() == null) {
			fv.setUpdateTime(time);
			fv.setUpdateUser(user);
		}

		fv = crudDAO.update(fv);

		return new Assembler().toDto(fv);
	}

	public ObservationDTO update(ObservationDTO dto, String uname) {

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		Observation o = crudDAO.findByKey(Observation.class, dto.getId());

		o.setNotes(dto.getNotes());
		o.setUpdateTime(time);
		o.setUpdateUser(user);
		if (o.getUpdateUser() == null) {
			o.setUpdateTime(time);
			o.setUpdateUser(user);
		}

		o = crudDAO.update(o);

		return new Assembler().toDto(o);
	}

	public RecommandationDTO update(RecommandationDTO dto, String uname) {

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		Recommandation r = crudDAO.findByKey(Recommandation.class, dto.getId());

		r.setNotes(dto.getNotes());
		r.setUpdateTime(time);
		r.setUpdateUser(user);
		if (r.getUpdateUser() == null) {
			r.setUpdateTime(time);
			r.setUpdateUser(user);
		}

		r = crudDAO.update(r);

		return new Assembler().toDto(r);
	}

	public RestrictionProposalDTO update(RestrictionProposalDTO dto, String uname) {

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);

		RestrictionProposal rp = crudDAO.findByKey(RestrictionProposal.class, dto.getId());

		rp.setNotes(dto.getNotes());
		rp.setUpdateTime(time);
		rp.setUpdateUser(user);
		if (rp.getUpdateUser() == null) {
			rp.setUpdateTime(time);
			rp.setUpdateUser(user);
		}

		rp = crudDAO.update(rp);

		return new Assembler().toDto(rp);
	}

	public List<DossierDTO> searchDossiers(DossierReq req) {
		DossierSQL criterias = new RequestAssembler().toSql(req);
		return new Assembler().dossierListToDto(dossierDAO.search(criterias));
	}

	
	public List<AuthorizationDTO> getAuthorizations(Integer dossierId)
	{
		return new Assembler().authorizationListToDto(dossierDAO.getAuthorizations(dossierId));
	}
	
	public List<AuditNotificationStartDTO> getAuditNotificationStarts(Integer dossierId)
	{
		return new Assembler().auditNofiticationListToDto(dossierDAO.getAuditNotificationStarts(dossierId));
	}
	
	public List<FieldEvidenceDTO> getFieldEvidences(Integer dossierId)
	{
		return new Assembler().fieldEvidenceListToDto(dossierDAO.getFieldEvidences(dossierId));
	}
	
	public List<ObservationDTO> getObservations(Integer dossierId)
	{
		return new Assembler().observationListToDto(dossierDAO.getObservations(dossierId));
	}
	
	public List<RecommandationDTO> getRecommandations(Integer dossierId)
	{
		return new Assembler().recommandationListToDto(dossierDAO.getRecommandations(dossierId));
	}
	
	public List<RestrictionProposalDTO> getRestrictionProposals(Integer dossierId)
	{
		return new Assembler().restrictionListToDto(dossierDAO.getRestrictionProposals(dossierId));
	}
	
	public List<DocumentDTO> getDocuments(Integer dossierId)
	{
		return new Assembler().documentListToDto(dossierDAO.getDocuments(dossierId));
	}
	
	
	
	public FieldEvidenceDTO create(FieldEvidenceDTO dto, String uname) {

		
		if (dto.getDossier() == null) {
			throw new AppException("Dosja e papërcaktuar!");
		}
		if (!StringUtil.isValid(dto.getNotes())) {
			throw new AppException("Shënimet e papërcaktuara!");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);
		Dossier d = crudDAO.findByKey(Dossier.class, dto.getDossier().getId());

		FieldEvidence fe = new FieldEvidence();

		fe.setDossier(d);
		fe.setNotes(dto.getNotes());
		fe.setCreateTime(time);
		fe.setCreateUser(user);
		fe.setIsDeleted(IStatus.NO);

		fe = crudDAO.create(fe);
		return new Assembler().toDto(fe);

	}
	
	public ObservationDTO create(ObservationDTO dto, String uname) {

		if (dto.getDossier() == null) {
			throw new AppException("Dosja e papërcaktuar!");
		}
		if (!StringUtil.isValid(dto.getNotes())) {
			throw new AppException("Shënimet e papërcaktuara!");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);
		Dossier d = crudDAO.findByKey(Dossier.class, dto.getDossier().getId());

		Observation o = new Observation();

		o.setDossier(d);
		o.setNotes(dto.getNotes());
		o.setCreateTime(time);
		o.setCreateUser(user);
		o.setIsDeleted(IStatus.NO);

		o = crudDAO.create(o);
		return new Assembler().toDto(o);

	}
	
	
	public RecommandationDTO create(RecommandationDTO dto, String uname) {

		if (dto.getDossier() == null) {
			throw new AppException("Dosja e papërcaktuar!");
		}
		if (!StringUtil.isValid(dto.getNotes())) {
			throw new AppException("Shënimet e papërcaktuara!");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);
		Dossier d = crudDAO.findByKey(Dossier.class, dto.getDossier().getId());

		Recommandation r = new Recommandation();

		r.setDossier(d);
		r.setNotes(dto.getNotes());
		r.setCreateTime(time);
		r.setCreateUser(user);
		r.setIsDeleted(IStatus.NO);

		r = crudDAO.create(r);
		return new Assembler().toDto(r);

	}
	
	public RestrictionProposalDTO create(RestrictionProposalDTO dto, String uname) {

		if (dto.getDossier() == null) {
			throw new AppException("Dosja e papërcaktuar!");
		}
		if (!StringUtil.isValid(dto.getNotes())) {
			throw new AppException("Shënimet e papërcaktuara!");
		}

		Date time = Calendar.getInstance().getTime();
		User user = userDAO.findByUsername(uname);
		Dossier d = crudDAO.findByKey(Dossier.class, dto.getDossier().getId());

		RestrictionProposal rp = new RestrictionProposal();

		rp.setDossier(d);
		rp.setNotes(dto.getNotes());
		rp.setCreateTime(time);
		rp.setCreateUser(user);
		rp.setIsDeleted(IStatus.NO);

		rp = crudDAO.create(rp);
		return new Assembler().toDto(rp);

	}
	
	
	
	
		
}
