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
@Table(name = "RECOMMANDATION",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Recommandation.findAll", query = "SELECT r FROM Recommandation r") })
public class Recommandation implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(generator = "RecommandationIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RecommandationIdSeq", sequenceName = "RECOMMANDATION_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 500)
	@Column(name = "NOTES")
	private String notes;
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

	public Recommandation() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
