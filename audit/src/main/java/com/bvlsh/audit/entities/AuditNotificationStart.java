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

/**
 *
 * @author lorela.shehu
 */
@Entity
@Table(name = "AUDIT_NOTIFICATION_START",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({
    @NamedQuery(name = "AuditNotificationStart.findAll", query = "SELECT a FROM AuditNotificationStart a")})
public class AuditNotificationStart implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(generator = "AuditNotifStartIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AuditNotifStartIdSeq", sequenceName = "AUDIT_NOTIF_START_ID_SEQ", allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Column(name = "AUDIT_START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditStartTime;
    @Column(name = "AUDIT_PERIOD_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditPeriodStart;
    @Column(name = "AUDIT_PERIOD_END")
    @Temporal(TemporalType.TIMESTAMP)
    private Date auditPeriodEnd;
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "UPDATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Column(name = "IS_DELETED")
    private int isDeleted;
    @JoinColumn(name = "DOSSIER_ID", referencedColumnName = "ID")
    @ManyToOne
    private Dossier dossier;
    @JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User updateUser;
    @JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
    @ManyToOne
    private User createUser;

    public AuditNotificationStart() {
    }

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
