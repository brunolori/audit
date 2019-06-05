package com.bvlsh.audit.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bvlsh.audit.ui.api.clients.DocumentClient;
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.models.DocumentTypeDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.services.UtilService;
import com.bvlsh.audit.ui.utils.Encryptor;
import com.bvlsh.audit.ui.utils.Util;

@ManagedBean
@ViewScoped
public class DocumentListBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	
	DocumentDTO document;
	List<DocumentDTO> documents;
	DocumentDTO selectedDocument;
	
	String dossierNo;
	String docTypeCode;
	List<DocumentTypeDTO> documentTypes;

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public List<DocumentDTO> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentDTO> documents) {
		this.documents = documents;
	}

	public DocumentDTO getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(DocumentDTO selectedDocument) {
		this.selectedDocument = selectedDocument;
	}

	public String getDossierNo() {
		return dossierNo;
	}

	public void setDossierNo(String dossierNo) {
		this.dossierNo = dossierNo;
	}

	public String getDocTypeCode() {
		return docTypeCode;
	}

	public void setDocTypeCode(String docTypeCode) {
		this.docTypeCode = docTypeCode;
	}

	public List<DocumentTypeDTO> getDocumentTypes() {
		return documentTypes;
	}

	public void setDocumentTypes(List<DocumentTypeDTO> documentTypes) {
		this.documentTypes = documentTypes;
	}

	@PostConstruct
	public void load() {
		this.documentTypes = new UtilService().loadDocTypes();
		init();
	}
	
	public void init() {
		this.document = new DocumentDTO();
		this.dossierNo = null;
		this.docTypeCode = null;
		this.selectedDocument = null;
		
	}
	
	public void clear() {
		init();
	}
	
	
	public void search() {
		this.documents = new DocumentClient().searchDocument(null, dossierNo, docTypeCode);	
	}
	
	
	public void viewDossier(DossierDTO d) {
		
		Util.redirect("ui/dossier.xhtml?dossier_id="+new Encryptor().encrypt(d.getId()+""));
		
	}
	
	
}
