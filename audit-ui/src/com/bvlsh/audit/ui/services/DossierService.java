package com.bvlsh.audit.ui.services;

import java.util.List;

import com.bvlsh.audit.ui.api.clients.DossierClient;
import com.bvlsh.audit.ui.criterias.DossierReq;
import com.bvlsh.audit.ui.models.AuditNotificationStartDTO;
import com.bvlsh.audit.ui.models.AuthorizationDTO;
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.models.FieldEvidenceDTO;
import com.bvlsh.audit.ui.models.ObservationDTO;
import com.bvlsh.audit.ui.models.RecommandationDTO;
import com.bvlsh.audit.ui.models.RestrictionProposalDTO;

public class DossierService {

	public DossierDTO registerDossier(DossierDTO dossier) {
		return new DossierClient().registerDossier(dossier);
	}

	public DossierDTO modifyDossier(DossierDTO dossier) {
		return new DossierClient().modifyDossier(dossier);
	}

	public AuthorizationDTO modifyAuthorization(AuthorizationDTO auth) {
		return new DossierClient().modifyAuthorization(auth);
	}

	public AuditNotificationStartDTO modifyAuditNotificationStart(AuditNotificationStartDTO ans) {
		return new DossierClient().modifyAuditNotificationStart(ans);
	}

	public FieldEvidenceDTO modifyFieldEvidence(FieldEvidenceDTO fv) {
		return new DossierClient().modifyFieldEvidence(fv);
	}

	public ObservationDTO modifyObservation(ObservationDTO observation) {
		return new DossierClient().modifyObservation(observation);
	}

	public RecommandationDTO modifyRecommandation(RecommandationDTO r) {
		return new DossierClient().modifyRecommandation(r);
	}

	public RestrictionProposalDTO modifyRestrictionProposal(RestrictionProposalDTO rp) {
		return new DossierClient().modifyRestrictionProposal(rp);
	}

	public List<DossierDTO> searchDossier(DossierReq req) {
		return new DossierClient().searchDossier(req);
	}

	public List<AuthorizationDTO> getAuthorizations(Integer id) {
		return new DossierClient().getAuthorizations(id);
	}

	public List<AuditNotificationStartDTO> getAuditNotificationStarts(Integer id) {
		return new DossierClient().getAuditNotificationStarts(id);
	}

	public List<FieldEvidenceDTO> getFieldEvidences(Integer id) {
		return new DossierClient().getFieldEvidences(id);
	}

	public List<ObservationDTO> getObservations(Integer id) {
		return new DossierClient().getObservations(id);
	}

	public List<RecommandationDTO> getRecommandations(Integer id) {
		return new DossierClient().getRecommandations(id);
	}

	public List<RestrictionProposalDTO> getRestrictionProposals(Integer id) {
		return new DossierClient().getRestrictionProposals(id);
	}

	public List<DocumentDTO> getDocuments(Integer id) {
		return new DossierClient().getDocuments(id);
	}

	public FieldEvidenceDTO registerFieldEvidence(FieldEvidenceDTO fieldEvidence) {
		return new DossierClient().registerFieldEvidence(fieldEvidence);
	}

	public ObservationDTO registerObservation(ObservationDTO observation) {

		return new DossierClient().registerObservation(observation);
	}

	public RecommandationDTO registerRecommandation(RecommandationDTO recommandation) {

		return new DossierClient().registerRecommandation(recommandation);
	}

	public RestrictionProposalDTO registerRestrictionProposal(RestrictionProposalDTO restrictionProposal) {
		return new DossierClient().registerRestrictionProposal(restrictionProposal);
	}

}
