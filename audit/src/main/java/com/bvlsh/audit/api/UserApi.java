package com.bvlsh.audit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bvlsh.audit.exceptions.AppException;
import com.bvlsh.audit.security.TokenUtil;
import com.bvlsh.audit.dto.UserDTO;
import com.bvlsh.audit.models.Principal;
import com.bvlsh.audit.models.UserTokenDTO;
import com.bvlsh.audit.services.UserService;


@RestController
@RequestMapping("/api/user")
public class UserApi {
	
	@Autowired UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> login(@RequestBody Principal principal) {
		UserTokenDTO ut = userService.login(principal);
		return new ResponseEntity<>(ut, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/loadUsers", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> loadUsers(@RequestHeader(value = "Authorization") String token) {
		
		
		
		TokenUtil.getUsername(token);
		
		List<UserDTO> u = userService.loadUsers();
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> register(@RequestHeader(value = "Authorization") String token, @RequestBody UserDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			UserDTO user = userService.create(dto, uname);
			return new ResponseEntity<>(user, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modify(@RequestHeader(value = "Authorization") String token, @RequestBody UserDTO dto) {

		try {

			String username = TokenUtil.getUsername(token);

			UserDTO user = userService.update(dto, username);

			return new ResponseEntity<>(user, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> delete(@RequestHeader(value = "Authorization") String token, @RequestBody UserDTO dto) {
		String username = TokenUtil.getUsername(token);
		UserDTO u = userService.delete(dto,username);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

}
