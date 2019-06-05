package com.bvlsh.audit.ui.models;

import java.util.Date;

public class RestrictionProposalDTO {

	private int id;
	private String notes;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
