package com.bvlsh.audit.ui.models;

public class Principal {

	String username;
	String password;
	
	
	public Principal() {}
	
	public Principal(String u,String p)
	{
		username = u; password = p;
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
	
	
	
	
	
	
	
}
