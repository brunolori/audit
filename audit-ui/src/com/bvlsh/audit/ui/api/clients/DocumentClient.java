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
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.utils.StringUtil;
import com.bvlsh.audit.ui.utils.Util;

public class DocumentClient {
	
	public DocumentDTO registerDocument(DocumentDTO doc) {

		final String BASE_URL = IApiClient.SERVER + "/api/document/create";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<DocumentDTO>(doc, headers);

		ResponseEntity<DocumentDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				DocumentDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public DocumentDTO modifyDocument(DocumentDTO doc) {

		final String BASE_URL = IApiClient.SERVER + "/api/document/update";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<DocumentDTO>(doc, headers);

		ResponseEntity<DocumentDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				DocumentDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public List<DocumentDTO> searchDocument(Integer dossierId, String dossierNo, String documentType) {
		
		if(dossierId == null)
		{
			dossierId = 0;
		}
				
		final String BASE_URL = IApiClient.SERVER + "/api/document/search/"+dossierId;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		if(StringUtil.isValid(documentType))
		{
			builder.queryParam("documentType", documentType);
		}
		if(StringUtil.isValid(dossierNo)) {
			builder.queryParam("dossierNo", dossierNo);
		}
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ParameterizedTypeReference<List<DocumentDTO>> typeRef = new ParameterizedTypeReference<List<DocumentDTO>>() {
		};

		ResponseEntity<List<DocumentDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET,
				entity, typeRef);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public DocumentDTO deleteDocument(Integer docId) {

		final String BASE_URL = IApiClient.SERVER + "/api/document/delete/"+ docId;

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<DocumentDTO>(headers);

		ResponseEntity<DocumentDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				DocumentDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

}
