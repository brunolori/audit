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
import com.bvlsh.audit.ui.models.AuditStatusDTO;
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.models.DocumentTypeDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.models.OfficerDTO;
import com.bvlsh.audit.ui.models.RiskLevelDTO;
import com.bvlsh.audit.ui.models.StructureDTO;
import com.bvlsh.audit.ui.models.UserDTO;

public class UtilClient {

	public List<RiskLevelDTO> loadRiskLevels() {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/loadRiskLevels";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<RiskLevelDTO>> typeRef = new ParameterizedTypeReference<List<RiskLevelDTO>>() {};

		ResponseEntity<List<RiskLevelDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public List<AuditStatusDTO> loadAuditStatuses() {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/loadAuditStatuses";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<AuditStatusDTO>> typeRef = new ParameterizedTypeReference<List<AuditStatusDTO>>() {};

		ResponseEntity<List<AuditStatusDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public List<DocumentTypeDTO> loadDocTypes() {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/loadDocTypes";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<DocumentTypeDTO>> typeRef = new ParameterizedTypeReference<List<DocumentTypeDTO>>() {};

		ResponseEntity<List<DocumentTypeDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,	entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public List<StructureDTO> loadStructures() {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/loadStructures";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<StructureDTO>> typeRef = new ParameterizedTypeReference<List<StructureDTO>>() {};

		ResponseEntity<List<StructureDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public StructureDTO findStructureById(Integer id) {
		final String BASE_URL = IApiClient.SERVER + "/api/utils/findStructureById/" + id;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<StructureDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,StructureDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public RiskLevelDTO findRiskLevelByCode(String code) {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/findRiskLevelByCode/" + code;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		ResponseEntity<RiskLevelDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,RiskLevelDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	public AuditStatusDTO findAuditStatusByCode(String code) {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/findAuditStatusByCode/" + code;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		ResponseEntity<AuditStatusDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,AuditStatusDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	public DocumentTypeDTO findDocumentTypeByCode(String code) {

		final String BASE_URL = IApiClient.SERVER + "/api/utils/findDocumentTypeByCode/" + code;
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);
		ResponseEntity<DocumentTypeDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,	DocumentTypeDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	public UserDTO findUserById(Integer id) {
		final String BASE_URL = IApiClient.SERVER + "/api/utils/findUserById/" + id;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<UserDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,UserDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	public OfficerDTO findOfficerById(Integer id) {
		final String BASE_URL = IApiClient.SERVER + "/api/utils/findOfficerById/" + id;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<OfficerDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,OfficerDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	public DossierDTO findDossierById(Integer id) {
		final String BASE_URL = IApiClient.SERVER + "/api/utils/findDossierById/" + id;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<DossierDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,DossierDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	public DocumentDTO findDocumentById(Integer id) {
		final String BASE_URL = IApiClient.SERVER + "/api/utils/findDocumentById/" + id;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<Object>(headers);

		ResponseEntity<DocumentDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,DocumentDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

}
