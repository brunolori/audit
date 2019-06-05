/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvlsh.audit.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lorela.shehu
 */
@Entity
@Table(name = "STRUCTURE",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Structure.findAll", query = "SELECT s FROM Structure s") })
public class Structure implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 20)
	@Column(name = "NAME")
	private String name;
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
	@ManyToOne
	private Structure parent;

	public Structure() {
	}
	
	public Structure(int id) {
		this.id = id;
	}

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

	public Structure getParent() {
		return parent;
	}

	public void setParent(Structure parent) {
		this.parent = parent;
	}

}
