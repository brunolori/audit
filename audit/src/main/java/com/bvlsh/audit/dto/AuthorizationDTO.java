package com.bvlsh.audit.dto;

import java.util.Date;
import java.util.List;

public class AuthorizationDTO {

	private int id;
	private String authorizationNo;
	private Date auditingPeriodStart;
	private Date auditingPeriodEnd;
	private Date auditingExecutionDate;
	private Date projectEndDate;
	private List<OfficerDTO> officers;
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

	public String getAuthorizationNo() {
		return authorizationNo;
	}

	public void setAuthorizationNo(String authorizationNo) {
		this.authorizationNo = authorizationNo;
	}

	public Date getAuditingPeriodStart() {
		return auditingPeriodStart;
	}

	public void setAuditingPeriodStart(Date auditingPeriodStart) {
		this.auditingPeriodStart = auditingPeriodStart;
	}

	public Date getAuditingPeriodEnd() {
		return auditingPeriodEnd;
	}

	public void setAuditingPeriodEnd(Date auditingPeriodEnd) {
		this.auditingPeriodEnd = auditingPeriodEnd;
	}

	public Date getAuditingExecutionDate() {
		return auditingExecutionDate;
	}

	public void setAuditingExecutionDate(Date auditingExecutionDate) {
		this.auditingExecutionDate = auditingExecutionDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public List<OfficerDTO> getOfficers() {
		return officers;
	}

	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
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

}
