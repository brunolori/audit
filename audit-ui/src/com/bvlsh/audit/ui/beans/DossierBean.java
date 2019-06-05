package com.bvlsh.audit.ui.beans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.UploadedFile;

import com.bvlsh.audit.ui.api.security.ApiException;
import com.bvlsh.audit.ui.models.AuditNotificationStartDTO;
import com.bvlsh.audit.ui.models.AuditStatusDTO;
import com.bvlsh.audit.ui.models.AuthorizationDTO;
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.models.DocumentTypeDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.models.FieldEvidenceDTO;
import com.bvlsh.audit.ui.models.ObservationDTO;
import com.bvlsh.audit.ui.models.OfficerDTO;
import com.bvlsh.audit.ui.models.RecommandationDTO;
import com.bvlsh.audit.ui.models.RestrictionProposalDTO;
import com.bvlsh.audit.ui.models.RiskLevelDTO;
import com.bvlsh.audit.ui.models.StructureDTO;
import com.bvlsh.audit.ui.services.DocumentService;
import com.bvlsh.audit.ui.services.DossierService;
import com.bvlsh.audit.ui.services.OfficerService;
import com.bvlsh.audit.ui.services.UtilService;
import com.bvlsh.audit.ui.utils.CalculatorUtil;
import com.bvlsh.audit.ui.utils.Encryptor;
//import com.bvlsh.audit.ui.utils.Encryptor;
import com.bvlsh.audit.ui.utils.Messages;
import com.bvlsh.audit.ui.utils.StringUtil;
import com.bvlsh.audit.ui.utils.Util;

@ManagedBean
@ViewScoped
public class DossierBean implements Serializable {

	private static final long serialVersionUID = 1L;

	DossierDTO dossier;
	AuthorizationDTO auth;
	AuditNotificationStartDTO ans;
	ObservationDTO observation;
	RecommandationDTO recommandation;
	FieldEvidenceDTO fieldEvidence;
	RestrictionProposalDTO restrictionProposal;
	DocumentDTO document;
	List<DocumentDTO> documents;
	
	List<OfficerDTO> auditors;
	OfficerDTO selectedAuditor;

	List<StructureDTO> structures;
	List<RiskLevelDTO> riskLevels;
	List<AuditStatusDTO> auditStatuses;
	List<DocumentTypeDTO> docTypes;
	
	List<FieldEvidenceDTO> fieldEvidences;
	List<ObservationDTO> observations;
	List<RecommandationDTO> recommandations;
	List<RestrictionProposalDTO> restrictionProposals;
	
	UploadedFile file;
	InputStream is;

	public DossierDTO getDossier() {
		return dossier;
	}

	public void setDossier(DossierDTO dossier) {
		this.dossier = dossier;
	}

	public AuthorizationDTO getAuth() {
		return auth;
	}

	public void setAuth(AuthorizationDTO auth) {
		this.auth = auth;
	}

	public AuditNotificationStartDTO getAns() {
		return ans;
	}

	public void setAns(AuditNotificationStartDTO ans) {
		this.ans = ans;
	}

	public ObservationDTO getObservation() {
		return observation;
	}

	public void setObservation(ObservationDTO observation) {
		this.observation = observation;
	}

	public RecommandationDTO getRecommandation() {
		return recommandation;
	}

	public void setRecommandation(RecommandationDTO recommandation) {
		this.recommandation = recommandation;
	}

	
	public FieldEvidenceDTO getFieldEvidence() {
		return fieldEvidence;
	}

	public void setFieldEvidence(FieldEvidenceDTO fieldEvidence) {
		this.fieldEvidence = fieldEvidence;
	}

	public RestrictionProposalDTO getRestrictionProposal() {
		return restrictionProposal;
	}

	public void setRestrictionProposal(RestrictionProposalDTO restrictionProposal) {
		this.restrictionProposal = restrictionProposal;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
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

	public List<DocumentTypeDTO> getDocTypes() {
		return docTypes;
	}

	public void setDocTypes(List<DocumentTypeDTO> docTypes) {
		this.docTypes = docTypes;
	}

	public List<DocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentDTO> documents) {
		this.documents = documents;
	}

	public List<OfficerDTO> getAuditors() {
		return auditors;
	}

	public void setAuditors(List<OfficerDTO> auditors) {
		this.auditors = auditors;
	}

	public OfficerDTO getSelectedAuditor() {
		return selectedAuditor;
	}

	public void setSelectedAuditor(OfficerDTO selectedAuditor) {
		this.selectedAuditor = selectedAuditor;
	}
	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	
	public List<FieldEvidenceDTO> getFieldEvidences() {
		return fieldEvidences;
	}

	public void setFieldEvidences(List<FieldEvidenceDTO> fieldEvidences) {
		this.fieldEvidences = fieldEvidences;
	}

	public List<ObservationDTO> getObservations() {
		return observations;
	}

	public void setObservations(List<ObservationDTO> observations) {
		this.observations = observations;
	}

	public List<RecommandationDTO> getRecommandations() {
		return recommandations;
	}

	public void setRecommandations(List<RecommandationDTO> recommandations) {
		this.recommandations = recommandations;
	}

	public List<RestrictionProposalDTO> getRestrictionProposals() {
		return restrictionProposals;
	}

	public void setRestrictionProposals(List<RestrictionProposalDTO> restrictionProposals) {
		this.restrictionProposals = restrictionProposals;
	}
	

	@PostConstruct
	public void load() {
		
		String id = new Encryptor().decrypt(Util.getParam("dossier_id"));
		if(!StringUtil.isNumber(id) )
		{
			Util.redirect("ui/dossier_list.xhtml");
			return;
		}
		this.dossier = new UtilService().findDossierById(Integer.valueOf(id));
		if(dossier == null)
		{
			Util.redirect("ui/dossier_list.xhtml");
			return;
		}

		this.document = new DocumentDTO();
		document.setDossier(dossier);					
		this.riskLevels = new UtilService().loadRiskLevels();
		this.structures = new UtilService().loadStructures();
		this.auditStatuses = new UtilService().loadAuditStatuses();
		this.docTypes = new UtilService().loadDocTypes();
		
		loadAuthorization();
		loadDocuments();
		loadFieldEvidence();
		loadNotificationStart();
		loadObservation();
		loadRecommandation();
		loadRestrictionProposal();
		
	}


	public void loadAuthorization()
	{
		List<AuthorizationDTO> list = new DossierService().getAuthorizations(this.dossier.getId());
		this.selectedAuditor = null;
		
		if(list == null || list.isEmpty()) {
			this.auth = new AuthorizationDTO();
			this.auditors = new ArrayList<>();
		}
		else
		{
			this.auth = list.get(0);
			this.auditors = auth.getOfficers();
			if(auditors == null) auditors = new ArrayList<>();
		}
	}
	
	public void loadNotificationStart()
	{
		List<AuditNotificationStartDTO> list = new DossierService().getAuditNotificationStarts(dossier.getId());
		
		if(list == null || list.isEmpty()) {
			this.ans = new AuditNotificationStartDTO();
		}
		else
		{
			this.ans = list.get(0);
		}
	}
	
	public void loadFieldEvidence()
	{
		this.fieldEvidence = new FieldEvidenceDTO();
		this.fieldEvidence.setDossier(dossier);
		this.fieldEvidences = new DossierService().getFieldEvidences(this.dossier.getId());		
	}
	
	
	public void loadObservation()
	{
		this.observation = new ObservationDTO();
		this.observation.setDossier(dossier);
		this.observations = new DossierService().getObservations(dossier.getId());		
	}
	
	public void loadRecommandation()
	{
		this.recommandation = new RecommandationDTO();
		this.recommandation.setDossier(dossier);
		this.recommandations = new DossierService().getRecommandations(dossier.getId());		
	}
	
	public void loadRestrictionProposal()
	{
		this.restrictionProposal = new RestrictionProposalDTO();
		this.restrictionProposal.setDossier(dossier);
		this.restrictionProposals = new DossierService().getRestrictionProposals(dossier.getId());
	}
	
	
	public void loadDocuments()
	{
		this.document = new DocumentDTO();
		this.document.setDossier(dossier);
		this.file = null;
		this.documents = new DossierService().getDocuments(dossier.getId());
	}
	
	
	public void modifyDossier() {

		try {
			new DossierService().modifyDossier(dossier);
			Messages.throwFacesMessage("Dosja u modifikua me sukses!", 1);	
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	public List<OfficerDTO> searchOfficer(String query)
	{
		return new OfficerService().queryOfficer(query);
	}
	
	public void onOfficerSelect()
	{
		this.auditors.add(selectedAuditor);
		this.selectedAuditor = null;
	}
	
	public void removeAuditor(OfficerDTO o)
	{
		this.auditors.remove(o);
	}
	

	public void modifyAuthorization() {
		try {
			this.selectedAuditor = null;
			auth.setOfficers(auditors);			
			new DossierService().modifyAuthorization(auth);
			Messages.throwFacesMessage("Autorizimi u modifikua me sukses!", 1);
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modifyAuditNotifStart() {
		try {
			new DossierService().modifyAuditNotificationStart(ans);
			Messages.throwFacesMessage("Njoftim fillim auditi u modifikua me sukses!", 1);
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modifyFieldEvidence(RowEditEvent event) {
		try {
			new DossierService().modifyFieldEvidence((FieldEvidenceDTO)event.getObject());
			Messages.throwFacesMessage("Evidenca në terren u modifikua me sukses!", 1);
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modifyObservation(RowEditEvent event) {
		try {
			new DossierService().modifyObservation((ObservationDTO)event.getObject());			
			Messages.throwFacesMessage("Observacioni u modifikua me sukses!", 1);
			
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modifyRecommandation(RowEditEvent event) {
		try {
			new DossierService().modifyRecommandation((RecommandationDTO)event.getObject());
			Messages.throwFacesMessage("Rekomandimi u modifikua me sukses!", 1);
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modifyRestrictionProposal(RowEditEvent event) {
		try {
			new DossierService().modifyRestrictionProposal((RestrictionProposalDTO)event.getObject());
			Messages.throwFacesMessage("Masat e propozuara u modifikuan me sukses!", 1);
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	

	
	public void registerFieldEvidence() {
		try {			
		 new DossierService().registerFieldEvidence(fieldEvidence);
		 loadFieldEvidence();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}catch(Exception e)
		{
			Messages.throwFacesMessage("Error në sistem!", 4);
			e.printStackTrace();
		}
	}
	
	public void registerObservation() {
		try {			
		 new DossierService().registerObservation(observation);
		 loadObservation();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}catch(Exception e)
		{
			Messages.throwFacesMessage("Error në sistem!", 4);
			e.printStackTrace();
		}
	}
	
	public void registerRecommandation() {
		try {			
		 new DossierService().registerRecommandation(recommandation);
		 loadRecommandation();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}catch(Exception e)
		{
			Messages.throwFacesMessage("Error në sistem!", 4);
			e.printStackTrace();
		}
	}
	
	public void registerRestrictionProposal() {
		try {			
		 new DossierService().registerRestrictionProposal(restrictionProposal);
		 loadRestrictionProposal();
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}catch(Exception e)
		{
			Messages.throwFacesMessage("Error në sistem!", 4);
			e.printStackTrace();
		}
	}	

	public void registerDocument() {
		try {
			if (this.file != null && is != null) {
				try {
					
					byte[] bytes = IOUtils.toByteArray(is);//file.getInputstream()
					String base64 = CalculatorUtil.encodeBASE64(bytes);
					document.setDocumentPath(file.getFileName());
					document.setContentType(file.getContentType());
					document.setData(base64);
					new DocumentService().registerDocument(document);
					loadDocuments();
					Messages.throwFacesMessage("Dokumenti u regjistrua me sukses!", 1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				Messages.throwFacesMessage("Ngarko dokumentin!", 2);
			}

		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}
	
	
	public void handleFileUpload(FileUploadEvent event) {
        this.file = event.getFile();
        try {
			this.is = event.getFile().getInputstream();
			Messages.throwFacesMessage(file.getFileName()+"#"+file.getContentType()+" u ngarkua me sukses", 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	

	public void deleteDocument() {
		try {
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}catch(Exception e)
		{
			Messages.throwFacesMessage("Error në sistem!", 4);
			e.printStackTrace();
		}
	}	

	
	
	public void openFile(DocumentDTO d) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		        ExternalContext externalContext = facesContext.getExternalContext();
		        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		        BufferedInputStream input = null;
		        BufferedOutputStream output = null;

		        try {
		        	File f = new File(d.getDocumentPath());
		            // Open file.
		            input = new BufferedInputStream(new FileInputStream(f));

		            // Init servlet response.
		            response.reset();
		            response.setHeader("Content-type", d.getContentType()); 
		            response.setContentLength((int)f.length());

		            response.setHeader("Content-disposition", "inline; filename=" + d.getFileName());
		            response.setHeader("pragma", "public");
		            output = new BufferedOutputStream(response.getOutputStream(), (int) f.length());

		            // Write file contents to response.
		            byte[] buffer = new byte[(int) f.length()];
		            int length;
		            while ((length = input.read(buffer)) > 0) {
		                output.write(buffer, 0, length);
		            }

		            // Finalize task.
		            output.flush();
		            
		        }catch(Exception e)
	            {
	            	e.printStackTrace();
	            } 
		        finally {
		            // Gently close streams.

		                try {
							output.close();
							input.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                
		        }
		}
	
	
	
	
	
}
