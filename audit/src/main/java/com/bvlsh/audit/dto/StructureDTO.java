package com.bvlsh.audit.dto;

public class StructureDTO {

	private int id;
	private String name;
	private StructureDTO parent;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StructureDTO getParent() {
		return parent;
	}

	public void setParent(StructureDTO parent) {
		this.parent = parent;
	}

}
