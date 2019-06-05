package com.bvlsh.audit.dto;

public class UserDTO {

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

}
