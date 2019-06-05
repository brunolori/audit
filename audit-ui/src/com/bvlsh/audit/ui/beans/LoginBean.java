package com.bvlsh.audit.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.bvlsh.audit.ui.api.security.ApiException;
import com.bvlsh.audit.ui.models.Principal;
import com.bvlsh.audit.ui.models.UserTokenDTO;
import com.bvlsh.audit.ui.services.UserService;
import com.bvlsh.audit.ui.utils.Messages;
import com.bvlsh.audit.ui.utils.StringUtil;
import com.bvlsh.audit.ui.utils.Util;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	UserTokenDTO userToken;	

	public UserTokenDTO getUserToken() {
		return userToken;
	}

	public void setUserToken(UserTokenDTO userToken) {
		this.userToken = userToken;
	}

	public void login() {

		String uname = Util.getParam("uname");
		String secret = Util.getParam("secret");
		
		
		if (!StringUtil.isValid(uname)) {
			Messages.throwFacesMessage("Plotëso Username", 3);
			return;
		}

		if (!StringUtil.isValid(secret)) {
			Messages.throwFacesMessage("Plotëso Password", 3);
			return;
		}

		Principal principal = new Principal();
		principal.setUsername(uname);
		principal.setPassword(secret);
		
		try {

			this.userToken = new UserService().login(principal);
	
			if (userToken != null) {
				Util.setToken(userToken.getToken());
				Util.redirect("ui/dossier_list.xhtml");
			} else {
				Messages.throwFacesMessage("Kredenciale të gabuara", 3);
			}
		
		}catch(ApiException a)
		{
			Messages.throwFacesMessage(a.getMessage(), a.getSeverity());
		}
		

	}

	public String logout() {
		try {
			HttpSession session = Util.getSession();
			if (session != null) {
				session.invalidate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/login.xhtml?faces-redirect=true";
	}

}
