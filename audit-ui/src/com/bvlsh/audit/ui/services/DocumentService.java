package com.bvlsh.audit.ui.services;

import java.util.List;

import com.bvlsh.audit.ui.api.clients.DocumentClient;
import com.bvlsh.audit.ui.models.DocumentDTO;

public class DocumentService 
{
	
	public DocumentDTO registerDocument(DocumentDTO doc) {
		return new DocumentClient().registerDocument(doc);
	}
	
	public DocumentDTO modifyDocument(DocumentDTO doc) {
		return new DocumentClient().modifyDocument(doc);
	}
	
	public List<DocumentDTO> searchDocument(Integer dossierId, String dossierNo, String documentType) {
		return new DocumentClient().searchDocument(dossierId, dossierNo, documentType);
	}

	public DocumentDTO deleteDocument(Integer docId) {
		return new DocumentClient().deleteDocument(docId);
	}
}


