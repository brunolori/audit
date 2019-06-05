package com.bvlsh.audit.ui.api.clients;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bvlsh.audit.ui.api.security.ErrorHandler;
import com.bvlsh.audit.ui.constants.IApiClient;
import com.bvlsh.audit.ui.models.Principal;
import com.bvlsh.audit.ui.models.UserDTO;
import com.bvlsh.audit.ui.models.UserTokenDTO;
import com.bvlsh.audit.ui.utils.Util;

public class UserClient {

	public UserTokenDTO login(Principal principal) {
		final String BASE_URL = IApiClient.SERVER + "/api/user/login";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Principal>(principal, headers);

		ResponseEntity<UserTokenDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				UserTokenDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public List<UserDTO> loadUsers() {

		final String BASE_URL = IApiClient.SERVER + "/api/user/loadUsers";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<UserDTO>> typeRef = new ParameterizedTypeReference<List<UserDTO>>() {
		};

		ResponseEntity<List<UserDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public UserDTO registerUser(UserDTO user) {

		final String BASE_URL = IApiClient.SERVER + "/api/user/register";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<UserDTO>(user, headers);

		ResponseEntity<UserDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				UserDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public UserDTO modifyUser(UserDTO user) {

		final String BASE_URL = IApiClient.SERVER + "/api/user/modify";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<UserDTO>(user, headers);

		ResponseEntity<UserDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				UserDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public UserDTO deleteUser(UserDTO user) {

		final String BASE_URL = IApiClient.SERVER + "/api/user/delete";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<UserDTO>(user, headers);

		ResponseEntity<UserDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				UserDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

}
