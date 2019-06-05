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

import com.bvlsh.audit.ui.constants.IApiClient;
import com.bvlsh.audit.ui.models.OfficerDTO;

public class OfficerClient {
	
	public List<OfficerDTO> queryOfficer(String nameSurname) {
		final String BASE_URL = IApiClient.SERVER+"/api/officer/queryOfficer";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("query", nameSurname);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<OfficerDTO>> typeRef = new ParameterizedTypeReference<List<OfficerDTO>>() {};
		
		ResponseEntity<List<OfficerDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<OfficerDTO> searchOfficer(String name, String surname)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/officer/searchOfficer";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);
		builder.queryParam("name", name);
		builder.queryParam("surname", surname);
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<OfficerDTO>> typeRef = new ParameterizedTypeReference<List<OfficerDTO>>() {};
		
		ResponseEntity<List<OfficerDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	

}
