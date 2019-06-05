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
@Table(name = "USERS" ,schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u") })
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(generator = "UserIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "UserIdSeq", sequenceName = "USERS_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 20)
	@Column(name = "USERNAME")
	private String username;
	@Size(max = 20)
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;
	@Column(name = "UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;
	@Column(name = "STATUS")
	private int status;
	@Size(max = 3)
	@Column(name = "ROLE_CODE")
	private String roleCode;
	@JoinColumn(name = "OFFICER_ID", referencedColumnName = "ID")
	@ManyToOne
	private Officer officer;
	@JoinColumn(name = "UPDATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User updateUser;
	@JoinColumn(name = "CREATE_USER_ID", referencedColumnName = "ID")
	@ManyToOne
	private User createUser;

	public User() {
	}

	public User(Integer userId) {
		this.id = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Officer getOfficer() {
		return officer;
	}

	public void setOfficer(Officer officer) {
		this.officer = officer;
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
