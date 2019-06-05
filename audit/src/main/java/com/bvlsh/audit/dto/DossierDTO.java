package com.bvlsh.audit.dto;

import java.util.Date;

public class DossierDTO {

	private int id;
	private String description;
	private String dossierNo;
	private AuditStatusDTO auditingStatus;
	private RiskLevelDTO riskLevel;
	private StructureDTO structure;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDossierNo() {
		return dossierNo;
	}

	public void setDossierNo(String dossierNo) {
		this.dossierNo = dossierNo;
	}

	public AuditStatusDTO getAuditingStatus() {
		return auditingStatus;
	}

	public void setAuditingStatus(AuditStatusDTO auditingStatus) {
		this.auditingStatus = auditingStatus;
	}

	public RiskLevelDTO getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(RiskLevelDTO riskLevel) {
		this.riskLevel = riskLevel;
	}

	public StructureDTO getStructure() {
		return structure;
	}

	public void setStructure(StructureDTO structure) {
		this.structure = structure;
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

}
