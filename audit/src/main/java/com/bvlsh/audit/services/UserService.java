package com.bvlsh.audit.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bvlsh.audit.assemblers.Assembler;
import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.dao.CrudDAO;
import com.bvlsh.audit.dao.UserDAO;
import com.bvlsh.audit.dto.UserDTO;
import com.bvlsh.audit.entities.Officer;
import com.bvlsh.audit.entities.Structure;
import com.bvlsh.audit.entities.User;
import com.bvlsh.audit.exceptions.AppException;
import com.bvlsh.audit.exceptions.EmptyFieldsException;
import com.bvlsh.audit.models.Principal;
import com.bvlsh.audit.models.UserTokenDTO;
import com.bvlsh.audit.security.TokenUtil;
import com.bvlsh.audit.utils.StringUtil;

@Service
@Transactional
public class UserService {

	@Autowired CrudDAO crudDAO;
	@Autowired UserDAO userDAO;

	
	public UserTokenDTO login(Principal princ) {
		User u = userDAO.findByUsername(princ.getUsername());

		if (u == null){
			throw new AppException("Përdoruesi nuk ekziston!");
		}

		if (u.getStatus() != IStatus.ACTIVE) {
			throw new AppException("Përdoruesi jo aktiv!");
		}
		if (!u.getPassword().equals(princ.getPassword())) {
			throw new AppException("Kredenciale të gabuara!");
		}

		UserDTO user = new Assembler().toDto(u);

		UserTokenDTO ut = new UserTokenDTO();
		ut.setUser(user);
		ut.setToken(TokenUtil.generateToken(user));

		return ut;

	}

	public UserDTO create(UserDTO dto, String username) throws AppException {

		if (dto == null) {
			throw new EmptyFieldsException("Nuk ka të dhëna!");
		}

		if (!StringUtil.isValid(dto.getUsername())) {
			throw new EmptyFieldsException("Plotësoni 'Username'!");
		}

		if (!StringUtil.isValid(dto.getRoleCode())) {
			throw new EmptyFieldsException("Plotësoni rolin e përdoruesit!");
		}

		if (dto.getOfficer() == null || dto.getOfficer().getId() <= 0) {
			throw new EmptyFieldsException("Nuk ka të dhëna për oficerin!");
		}

		User regUser = userDAO.findByUsername(username);

		Officer o = new Officer();
		o.setName(dto.getOfficer().getName());
		o.setSurname(dto.getOfficer().getSurname());
		o.setGrade(dto.getOfficer().getGrade());
		o.setFunction(dto.getOfficer().getFunction());
		o.setPosition(dto.getOfficer().getPosition());
		o.setStructure(new Structure(dto.getOfficer().getStructure().getId()));

		o = crudDAO.create(o);

		User u = new User();

		u.setUsername(dto.getUsername());
		u.setRoleCode(dto.getRoleCode());
		u.setOfficer(o);
		u.setStatus(IStatus.ACTIVE);
		u.setCreateTime(Calendar.getInstance().getTime());
		u.setCreateUser(regUser);

		u = crudDAO.create(u);

		return new Assembler().toDto(u);
	}

	public UserDTO update(UserDTO dto, String username) throws AppException {
		if (dto == null) {
			throw new EmptyFieldsException("Nuk ka të dhëna!");
		}

		if (!StringUtil.isValid(dto.getUsername())) {
			throw new EmptyFieldsException("Plotësoni 'Username'!");
		}

		if (!StringUtil.isValid(dto.getRoleCode())) {
			throw new EmptyFieldsException("Plotësoni rolin e përdoruesit!");
		}

		if (dto.getOfficer() == null || dto.getOfficer().getId() <= 0) {
			throw new EmptyFieldsException("Nuk ka të dhëna për oficerin!");
		}

		User regUser = userDAO.findByUsername(username);

        Officer o = crudDAO.findByKey(Officer.class, dto.getId());
		User u = crudDAO.findByKey(User.class, dto.getId());

		u.setUsername(dto.getUsername());
		u.setRoleCode(dto.getRoleCode());
		u.setOfficer(o);
		u.setUpdateTime(Calendar.getInstance().getTime());
		u.setStatus(IStatus.ACTIVE);
		u.setUpdateUser(regUser);

		u = crudDAO.update(u);

		return new Assembler().toDto(u);
	}

	public UserDTO delete(UserDTO dto,String uname) {
		
		User regUser = userDAO.findByUsername(uname);
		
		User user = crudDAO.findByKey(User.class, dto.getId());
		user.setStatus(IStatus.NOT_ACTIVE);
		user.setUpdateTime(Calendar.getInstance().getTime());
		user.setUpdateUser(regUser);
		return new Assembler().toDto(crudDAO.update(user));
	}

	public List<UserDTO> loadUsers() {

		return new Assembler().userListToDto(crudDAO.loadUsers());
		
	}

}
