/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvlsh.audit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "AUTHORIZATION",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Authorization.findAll", query = "SELECT a FROM Authorization a") })
public class Authorization implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(generator = "AuthorizationIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AuthorizationIdSeq", sequenceName = "AUTHORIZATION_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 20)
	@Column(name = "AUTHORIZATION_NO")
	private String authorizationNo;
	@Column(name = "AUDITING_PERIOD_START")
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditingPeriodStart;
	@Column(name = "AUDITING_PERIOD_END")
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditingPeriodEnd;
	@Column(name = "AUDITING_EXECUTION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditingExecutionDate;
	@Column(name = "PROJECT_END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectEndDate;
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column(name = "IS_DELETED")
	private int isDeleted;
	@JoinTable(name = "AUTHORIZATION_AUDITORS", joinColumns = {
			@JoinColumn(name = "AUTHORIZATION_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "OFFICER_ID", referencedColumnName = "ID") })
	@ManyToMany
	private List<Officer> officers;
	@JoinColumn(name = "DOSSIER_ID", referencedColumnName = "ID")
	@ManyToOne
	private Dossier dossier;
	@JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User updateUser;
	@JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User createUser;

	public Authorization() {
	}

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


	public List<Officer> getOfficers() {
		return officers;
	}

	public void setOfficers(List<Officer> officers) {
		this.officers = officers;
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

}
