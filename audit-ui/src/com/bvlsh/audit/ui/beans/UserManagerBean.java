package com.bvlsh.audit.ui.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bvlsh.audit.ui.api.security.ApiException;
import com.bvlsh.audit.ui.models.OfficerDTO;
import com.bvlsh.audit.ui.models.UserDTO;
import com.bvlsh.audit.ui.services.OfficerService;
import com.bvlsh.audit.ui.services.UserService;
import com.bvlsh.audit.ui.utils.Messages;

@ManagedBean
@ViewScoped
public class UserManagerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String name;
	String surname;

	UserDTO user;
	List<UserDTO> users;
	UserDTO selectedUser;

	OfficerDTO officer;
	List<OfficerDTO> officers;
	OfficerDTO selectedOfficer;

	String activeView;
	boolean disableUser;
	

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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public UserDTO getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserDTO selectedUser) {
		this.selectedUser = selectedUser;
	}

	public OfficerDTO getOfficer() {
		return officer;
	}

	public void setOfficer(OfficerDTO officer) {
		this.officer = officer;
	}

	public List<OfficerDTO> getOfficers() {
		return officers;
	}

	public void setOfficers(List<OfficerDTO> officers) {
		this.officers = officers;
	}

	public OfficerDTO getSelectedOfficer() {
		return selectedOfficer;
	}

	public void setSelectedOfficer(OfficerDTO selectedOfficer) {
		this.selectedOfficer = selectedOfficer;
	}

	public String getActiveView() {
		return activeView;
	}

	public void setActiveView(String activeView) {
		this.activeView = activeView;
	}

	public boolean isDisableUser() {
		return disableUser;
	}

	public void setDisableUser(boolean disableUser) {
		this.disableUser = disableUser;
	}

	@PostConstruct
	public void load() {
		init();
		goToUserList();

	}

	private void init() {
		this.user = new UserDTO();
		this.officer = new OfficerDTO();
		this.selectedUser = null;
		this.users = new UserService().loadUsers();
		this.selectedOfficer = null;
		this.officers = null;
		this.name = null;
		this.surname = null;
		this.disableUser = true;
	}

	public void clearSearchOfficer() {
		this.selectedOfficer = null;
		this.officers = null;
		this.name = null;
		this.surname = null;
	}

	public void clearUser() {
		this.selectedOfficer = null;
		this.officer = new OfficerDTO();
		this.user = new UserDTO();
		this.disableUser = true;
	}

	public void clear() {

		init();

	}

	public void searchOfficer() {

		this.officers = new OfficerService().searchOfficer(name, surname);
		this.selectedOfficer = null;		
	}

	public void onUserSelect() {
		this.user = selectedUser;
		this.activeView = "/ui/user_modify.xhtml";
	}

	public void onOfficerSelect() {
		this.officer = selectedOfficer;
		this.disableUser = false;
	}

	public void goToUserCreate() {
		this.user = new UserDTO();
		this.officer = new OfficerDTO();
		this.activeView = "/ui/user_create.xhtml";
	}

	public void goToUserList() {
		this.activeView = "/ui/user_list.xhtml";
	}

	public void register() {
		try {

			this.user.setOfficer(officer);
			new UserService().registerUser(user);
			Messages.throwFacesMessage("Përdoruesi u regjistrua me sukses!", 1);
			init();
			goToUserList();
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

	public void modify() {
		try {
			new UserService().modifyUser(user);
			Messages.throwFacesMessage("Përdoruesi u modifikua me sukses!", 1);
			init();
			goToUserList();
		} catch (ApiException a) {
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
	}

}
