package com.bvlsh.audit.ui.models;

import java.util.Date;

public class DocumentDTO {

	private int id;
	private String documentPath;
	private String fileName;
	private String data;
	private String contentType;
	private String name;
	private DocumentTypeDTO documentType;
	private DossierDTO dossier;
	private Date createTime;
	private Date updateTime;
	private UserDTO createUser;
	private UserDTO updateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DocumentTypeDTO getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentTypeDTO documentType) {
		this.documentType = documentType;
	}

	public DossierDTO getDossier() {
		return dossier;
	}

	public void setDossier(DossierDTO dossier) {
		this.dossier = dossier;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public UserDTO getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UserDTO createUser) {
		this.createUser = createUser;
	}

	public UserDTO getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserDTO updateUser) {
		this.updateUser = updateUser;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	
	public String viewerPath()
	{
		return "file:\\\\\\"+this.documentPath.replace("/", "\\");
	}
	
}
