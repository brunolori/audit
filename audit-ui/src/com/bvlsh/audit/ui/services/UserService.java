package com.bvlsh.audit.ui.services;

import java.util.List;

import com.bvlsh.audit.ui.api.clients.UserClient;
import com.bvlsh.audit.ui.models.Principal;
import com.bvlsh.audit.ui.models.UserDTO;
import com.bvlsh.audit.ui.models.UserTokenDTO;

public class UserService {

	public UserTokenDTO login(Principal principal) {
		return new UserClient().login(principal);
	}

	public List<UserDTO> loadUsers() {
		return new UserClient().loadUsers();
	}

	public UserDTO registerUser(UserDTO user) {
		return new UserClient().registerUser(user);
	}

	public UserDTO modifyUser(UserDTO user) {
		return new UserClient().modifyUser(user);
	}

	public UserDTO deleteUser(UserDTO user) {
		return new UserClient().deleteUser(user);
	}
	
	
}
