/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvlsh.audit.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lorela.shehu
 */
@Entity
@Table(name = "DOCUMENT",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d") })
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(generator = "DocumentIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DocumentIdSeq", sequenceName = "DOCUMENT_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 200)
	@Column(name = "DOCUMENT_PATH")
	private String documentPath;
	@Size(max = 90)
	@Column(name = "DOCUMENT_CONTENT_TYPE")
	private String documentContentType;
	@Size(max = 20)
	@Column(name = "NAME")
	private String name;
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column(name = "IS_DELETED")
	private int isDeleted;
	@JoinColumn(name = "DOCUMENT_TYPE_CODE", referencedColumnName = "CODE")
	@ManyToOne
	private DocumentType documentType;
	@JoinColumn(name = "DOSSIER_ID", referencedColumnName = "ID")
	@ManyToOne
	private Dossier dossier;
	@JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User updateUser;
	@JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User createUser;

	public Document() {
	}

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

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentTypeCode) {
		this.documentType = documentTypeCode;
	}

	public Dossier getDossier() {
		return dossier;
	}

	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentContentType() {
		return documentContentType;
	}

	public void setDocumentContentType(String documentContentType) {
		this.documentContentType = documentContentType;
	}
	
	

}
