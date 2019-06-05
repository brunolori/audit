package com.bvlsh.audit.dto;

import java.util.Date;

public class AuditNotificationStartDTO {

	private int id;
	private Date auditStartTime;
	private Date auditPeriodStart;
	private Date auditPeriodEnd;
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

	public Date getAuditStartTime() {
		return auditStartTime;
	}

	public void setAuditStartTime(Date auditStartTime) {
		this.auditStartTime = auditStartTime;
	}

	public Date getAuditPeriodStart() {
		return auditPeriodStart;
	}

	public void setAuditPeriodStart(Date auditPeriodStart) {
		this.auditPeriodStart = auditPeriodStart;
	}

	public Date getAuditPeriodEnd() {
		return auditPeriodEnd;
	}

	public void setAuditPeriodEnd(Date auditPeriodEnd) {
		this.auditPeriodEnd = auditPeriodEnd;
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
