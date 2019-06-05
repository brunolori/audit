package com.bvlsh.audit.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bvlsh.audit.ui.models.DossierDTO;

@ManagedBean
@ViewScoped
public class DashboardBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	List<DossierDTO> dossiers;
	DossierDTO selectedDossier;
	
	
	@PostConstruct
	public void load(){}
	
	
	public void loadDossier() {}
	
	public void onDossierSelect() {}

}
