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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lorela.shehu
 */
@Entity
@Table(name = "OFFICER",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "Officer.findAll", query = "SELECT o FROM Officer o") })
public class Officer implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@GeneratedValue(generator = "OfficerIdSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "OfficerIdSeq", sequenceName = "OFFICER_ID_SEQ", allocationSize=1)
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	private int id;
	@Size(max = 20)
	@Column(name = "NAME")
	private String name;
	@Size(max = 20)
	@Column(name = "SURNAME")
	private String surname;
	@Size(max = 20)
	@Column(name = "GRADE")
	private String grade;
	@Size(max = 50)
	@Column(name = "POSITION")
	private String position;
	@Size(max = 50)
	@Column(name = "FUNCTION")
	private String function;
	@JoinColumn(name = "STRUCTURE_ID", referencedColumnName = "ID")
	@ManyToOne
	private Structure structure;

	public Officer() {
	}
	
	public Officer(int id) {
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Structure getStructure() {
		return structure;
	}

	public void setStructure(Structure structure) {
		this.structure = structure;
	}

}
