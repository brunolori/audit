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
@Table(name = "DOSSIER",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Dossier.findAll", query = "SELECT d FROM Dossier d") })
public class Dossier implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(generator = "DossierIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DossierIdSeq", sequenceName = "DOSSIER_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 250)
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column(name = "IS_DELETED")
	private int isDeleted;
	@Size(max = 20)
	@Column(name = "DOSSIER_NO")
	private String dossierNo;
	@JoinColumn(name = "AUDITING_STATUS_CODE", referencedColumnName = "CODE")
	@ManyToOne
	private AuditStatus auditingStatus;
	@JoinColumn(name = "RISK_LEVEL_CODE", referencedColumnName = "CODE")
	@ManyToOne
	private RiskLevel riskLevel;
	@JoinColumn(name = "STRUCTURE_ID", referencedColumnName = "ID")
	@ManyToOne
	private Structure structure;
	@JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User createUser;
	@JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User updateUser;

	public Dossier() {
	}
	
	public Dossier(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getDossierNo() {
		return dossierNo;
	}

	public void setDossierNo(String dossierNo) {
		this.dossierNo = dossierNo;
	}

	public AuditStatus getAuditingStatus() {
		return auditingStatus;
	}

	public void setAuditingStatus(AuditStatus auditingStatus) {
		this.auditingStatus = auditingStatus;
	}

	public RiskLevel getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

}
