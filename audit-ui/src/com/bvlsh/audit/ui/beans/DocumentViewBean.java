package com.bvlsh.audit.ui.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bvlsh.audit.ui.services.UtilService;
import com.bvlsh.audit.ui.utils.Util;

@ManagedBean
@RequestScoped
public class DocumentViewBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	String path;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	@PostConstruct
	public void load() {
		String ids = Util.getParam("d_id"); 	
		
		this.path = new UtilService().findDocumentById(Integer.valueOf(ids)).getDocumentPath();
		
		System.out.println("Pathiii: "+path);
	}

}
