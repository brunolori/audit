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
@Table(name = "DOCUMENT_TYPE",schema = "LORI_AUDIT_PROJECT")
@NamedQueries({ @NamedQuery(name = "DocumentType.findAll", query = "SELECT d FROM DocumentType d") })
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 3)
	@Column(name = "CODE")
	private String code;
	@Size(max = 20)
	@Column(name = "TAG")
	private String tag;

	public DocumentType() {
	}
	
	public DocumentType(String code) {
		this.code = code;
	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
