package com.bvlsh.audit.ui.models;

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
		StructureDTO other = (StructureDTO) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
