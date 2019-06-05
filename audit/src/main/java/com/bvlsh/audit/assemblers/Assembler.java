package com.bvlsh.audit.assemblers;

import java.util.ArrayList;
import java.util.List;

import com.bvlsh.audit.constants.IPath;
import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.dto.AuditNotificationStartDTO;
import com.bvlsh.audit.dto.AuditStatusDTO;
import com.bvlsh.audit.dto.AuthorizationDTO;
import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.dto.DocumentTypeDTO;
import com.bvlsh.audit.dto.DossierDTO;
import com.bvlsh.audit.dto.FieldEvidenceDTO;
import com.bvlsh.audit.dto.ObservationDTO;
import com.bvlsh.audit.dto.OfficerDTO;
import com.bvlsh.audit.dto.RecommandationDTO;
import com.bvlsh.audit.dto.RestrictionProposalDTO;
import com.bvlsh.audit.dto.RiskLevelDTO;
import com.bvlsh.audit.dto.StructureDTO;
import com.bvlsh.audit.dto.UserDTO;
import com.bvlsh.audit.entities.AuditNotificationStart;
import com.bvlsh.audit.entities.AuditStatus;
import com.bvlsh.audit.entities.Authorization;
import com.bvlsh.audit.entities.Document;
import com.bvlsh.audit.entities.DocumentType;
import com.bvlsh.audit.entities.Dossier;
import com.bvlsh.audit.entities.FieldEvidence;
import com.bvlsh.audit.entities.Observation;
import com.bvlsh.audit.entities.Officer;
import com.bvlsh.audit.entities.Recommandation;
import com.bvlsh.audit.entities.RestrictionProposal;
import com.bvlsh.audit.entities.RiskLevel;
import com.bvlsh.audit.entities.Structure;
import com.bvlsh.audit.entities.User;

public class Assembler {

	public AuditNotificationStartDTO toDto(AuditNotificationStart e) {
		if (e == null)
			return null;

		AuditNotificationStartDTO dto = new AuditNotificationStartDTO();
		dto.setId(e.getId());
		dto.setDossier(toDto(e.getDossier()));
		dto.setAuditStartTime(e.getAuditStartTime());
		dto.setAuditPeriodEnd(e.getAuditPeriodEnd());
		dto.setAuditPeriodStart(e.getAuditPeriodStart());
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));
		return dto;

	}

	public List<AuditNotificationStartDTO> auditNofiticationListToDto(List<AuditNotificationStart> auditNofitications) {

		if (auditNofitications == null || auditNofitications.isEmpty())
			return null;

		List<AuditNotificationStartDTO> list = new ArrayList<>();

		for (AuditNotificationStart ans : auditNofitications) {
			list.add(toDto(ans));
		}
		return list;
	}

	public AuditStatusDTO toDto(AuditStatus e) {
		if (e == null)
			return null;

		AuditStatusDTO dto = new AuditStatusDTO();
		dto.setCode(e.getCode());
		dto.setTag(e.getTag());
		return dto;

	}

	public List<AuditStatusDTO> auditStatusListToDto(List<AuditStatus> auditSts) {

		if (auditSts == null || auditSts.isEmpty())
			return null;

		List<AuditStatusDTO> list = new ArrayList<>();

		for (AuditStatus as : auditSts) {
			list.add(toDto(as));
		}
		return list;
	}

	public AuthorizationDTO toDto(Authorization e) {
		if (e == null)
			return null;

		AuthorizationDTO dto = new AuthorizationDTO();

		dto.setId(e.getId());
		dto.setAuthorizationNo(e.getAuthorizationNo());
		dto.setAuditingPeriodStart(e.getAuditingPeriodStart());
		dto.setAuditingPeriodEnd(e.getAuditingPeriodEnd());
		dto.setAuditingExecutionDate(e.getAuditingExecutionDate());
		dto.setProjectEndDate(e.getProjectEndDate());
		dto.setDossier(toDto(e.getDossier()));
		if (e.getOfficers() != null && !e.getOfficers().isEmpty()) {
			dto.setOfficers(officerListToDto(e.getOfficers()));
		}

		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));
		return dto;

	}

	public List<AuthorizationDTO> authorizationListToDto(List<Authorization> authorizations) {

		if (authorizations == null || authorizations.isEmpty())
			return null;

		List<AuthorizationDTO> list = new ArrayList<>();

		for (Authorization a : authorizations) {
			list.add(toDto(a));
		}
		return list;
	}

	public DocumentDTO toDto(Document e) {
		if (e == null)
			return null;

		DocumentDTO dto = new DocumentDTO();

		dto.setId(e.getId());
		dto.setName(e.getName());
		dto.setDossier(toDto(e.getDossier()));
		dto.setFileName(e.getDocumentPath());
		dto.setContentType(e.getDocumentContentType());
		dto.setDocumentPath(IPath.DOC_PATH+e.getDocumentPath());
		if (e.getDocumentType() != null) {
			dto.setDocumentType(toDto(e.getDocumentType()));
		}
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));
		return dto;

	}

	public List<DocumentDTO> documentListToDto(List<Document> documents) {

		if (documents == null || documents.isEmpty())
			return null;

		List<DocumentDTO> list = new ArrayList<>();

		for (Document d : documents) {
			list.add(toDto(d));
		}
		return list;
	}

	public DocumentTypeDTO toDto(DocumentType e) {
		if (e == null)
			return null;

		DocumentTypeDTO dto = new DocumentTypeDTO();
		dto.setCode(e.getCode());
		dto.setTag(e.getTag());
		return dto;

	}

	public List<DocumentTypeDTO> docTypeListToDto(List<DocumentType> doctypes) {

		if (doctypes == null || doctypes.isEmpty())
			return null;

		List<DocumentTypeDTO> list = new ArrayList<>();

		for (DocumentType dt : doctypes) {
			list.add(toDto(dt));
		}
		return list;
	}

	public DossierDTO toDto(Dossier e) {
		if (e == null)
			return null;

		DossierDTO dto = new DossierDTO();
		dto.setId(e.getId());
		dto.setDossierNo(e.getDossierNo());
		dto.setDescription(e.getDescription());
		if (e.getRiskLevel() != null) {
			dto.setRiskLevel(toDto(e.getRiskLevel()));
		}
		if (e.getAuditingStatus() != null) {
			dto.setAuditingStatus(toDto(e.getAuditingStatus()));
		}
		if (e.getStructure() != null) {
			dto.setStructure(toDto(e.getStructure()));
		}
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));

		return dto;

	}

	public List<DossierDTO> dossierListToDto(List<Dossier> dossiers) {

		if (dossiers == null || dossiers.isEmpty())
			return null;

		List<DossierDTO> list = new ArrayList<>();

		for (Dossier d : dossiers) {
			list.add(toDto(d));
		}
		return list;
	}

	public FieldEvidenceDTO toDto(FieldEvidence e) {
		if (e == null)
			return null;

		FieldEvidenceDTO dto = new FieldEvidenceDTO();

		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setDossier(toDto(e.getDossier()));
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));

		return dto;

	}

	public List<FieldEvidenceDTO> fieldEvidenceListToDto(List<FieldEvidence> fieldEvidences) {

		if (fieldEvidences == null || fieldEvidences.isEmpty())
			return null;

		List<FieldEvidenceDTO> list = new ArrayList<>();

		for (FieldEvidence fe : fieldEvidences) {
			list.add(toDto(fe));
		}
		return list;
	}

	public ObservationDTO toDto(Observation e) {
		if (e == null)
			return null;

		ObservationDTO dto = new ObservationDTO();

		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setDossier(toDto(e.getDossier()));
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));
		return dto;

	}

	public List<ObservationDTO> observationListToDto(List<Observation> observations) {

		if (observations == null || observations.isEmpty())
			return null;

		List<ObservationDTO> list = new ArrayList<>();

		for (Observation o : observations) {
			list.add(toDto(o));
		}
		return list;
	}

	public OfficerDTO toDto(Officer e) {
		if (e == null)
			return null;

		OfficerDTO dto = new OfficerDTO();

		dto.setId(e.getId());
		dto.setName(e.getName());
		dto.setSurname(e.getSurname());
		dto.setGrade(e.getGrade());
		dto.setPosition(e.getPosition());
		dto.setFunction(e.getFunction());
		if (e.getStructure() != null) {
			dto.setStructure(toDto(e.getStructure()));
		}
		return dto;

	}

	public List<OfficerDTO> officerListToDto(List<Officer> officers) {

		if (officers == null || officers.isEmpty())
			return null;

		List<OfficerDTO> list = new ArrayList<>();

		for (Officer o : officers) {
			list.add(toDto(o));
		}
		return list;
	}

	public RecommandationDTO toDto(Recommandation e) {
		if (e == null)
			return null;

		RecommandationDTO dto = new RecommandationDTO();

		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setDossier(toDto(e.getDossier()));
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));
		return dto;

	}

	public List<RecommandationDTO> recommandationListToDto(List<Recommandation> recommandations) {

		if (recommandations == null || recommandations.isEmpty())
			return null;

		List<RecommandationDTO> list = new ArrayList<>();

		for (Recommandation r : recommandations) {
			list.add(toDto(r));
		}
		return list;
	}

	public RestrictionProposalDTO toDto(RestrictionProposal e) {
		if (e == null)
			return null;

		RestrictionProposalDTO dto = new RestrictionProposalDTO();

		dto.setId(e.getId());
		dto.setNotes(e.getNotes());
		dto.setDossier(toDto(e.getDossier()));
		dto.setCreateTime(e.getCreateTime());
		dto.setCreateUser(toDto(e.getCreateUser()));
		dto.setUpdateTime(e.getUpdateTime());
		dto.setUpdateUser(toDto(e.getUpdateUser()));
		return dto;

	}

	public List<RestrictionProposalDTO> restrictionListToDto(List<RestrictionProposal> restrictions) {

		if (restrictions == null || restrictions.isEmpty())
			return null;

		List<RestrictionProposalDTO> list = new ArrayList<>();

		for (RestrictionProposal rp : restrictions) {
			list.add(toDto(rp));
		}
		return list;
	}

	public RiskLevelDTO toDto(RiskLevel e) {
		if (e == null)
			return null;

		RiskLevelDTO dto = new RiskLevelDTO();
		dto.setCode(e.getCode());
		dto.setTag(e.getTag());
		return dto;

	}

	public List<RiskLevelDTO> riskLevelListToDto(List<RiskLevel> riskLevels) {

		if (riskLevels == null || riskLevels.isEmpty())
			return null;

		List<RiskLevelDTO> list = new ArrayList<>();

		for (RiskLevel rl : riskLevels) {
			list.add(toDto(rl));
		}
		return list;
	}

	public StructureDTO toDto(Structure e) {
		if (e == null)
			return null;

		StructureDTO dto = new StructureDTO();
		dto.setId(e.getId());
		dto.setName(e.getName());
		if (e.getParent() != null) {
			
			StructureDTO p = new StructureDTO();
			p.setId(e.getParent().getId());
			p.setName(e.getParent().getName());
			dto.setParent(p);
		}

		return dto;

	}

	public List<StructureDTO> structureListToDto(List<Structure> structures) {

		if (structures == null || structures.isEmpty())
			return null;

		List<StructureDTO> list = new ArrayList<>();

		for (Structure s : structures) {
			list.add(toDto(s));
		}
		return list;
	}

	public UserDTO toDto(User e) {
		if (e == null)
			return null;

		UserDTO dto = new UserDTO();
		dto.setId(e.getId());
		dto.setUsername(e.getUsername());
		dto.setPassword(e.getPassword());
		dto.setRoleCode(e.getRoleCode());
		dto.setStatus(e.getStatus() == IStatus.ACTIVE);
		if (e.getOfficer() != null) {
		dto.setOfficer(toDto(e.getOfficer()));
		}
		return dto;

	}

	public List<UserDTO> userListToDto(List<User> userss) {

		if (userss == null || userss.isEmpty())
			return null;

		List<UserDTO> list = new ArrayList<>();

		for (User u : userss) {
			list.add(toDto(u));
		}
		return list;
	}

}
