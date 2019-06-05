package com.bvlsh.audit.ui.models;

import java.io.Serializable;

public class UserDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String password;
	private boolean status;
	private String roleCode;
	private OfficerDTO officer;

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public OfficerDTO getOfficer() {
		return officer;
	}

	public void setOfficer(OfficerDTO officer) {
		this.officer = officer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return officer != null? officer.getName()+" "+officer.getSurname() : username ;
	}
	
	
	public String fullName()
	{
		if(officer != null) return officer.getName() + " " + officer.getSurname();
		return username;
	}
	
	
	

}
