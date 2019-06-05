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
import com.bvlsh.audit.ui.criterias.DossierReq;
import com.bvlsh.audit.ui.models.AuditNotificationStartDTO;
import com.bvlsh.audit.ui.models.AuthorizationDTO;
import com.bvlsh.audit.ui.models.DocumentDTO;
import com.bvlsh.audit.ui.models.DossierDTO;
import com.bvlsh.audit.ui.models.FieldEvidenceDTO;
import com.bvlsh.audit.ui.models.ObservationDTO;
import com.bvlsh.audit.ui.models.RecommandationDTO;
import com.bvlsh.audit.ui.models.RestrictionProposalDTO;
import com.bvlsh.audit.ui.utils.Util;

public class DossierClient {

	public DossierDTO registerDossier(DossierDTO dossier) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/registerDossier";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<DossierDTO>(dossier, headers);

		ResponseEntity<DossierDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				DossierDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}

	public DossierDTO modifyDossier(DossierDTO dossier) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyDossier";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<DossierDTO>(dossier, headers);

		ResponseEntity<DossierDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				DossierDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public AuthorizationDTO modifyAuthorization(AuthorizationDTO auth) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyAuthorization";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<AuthorizationDTO>(auth, headers);

		ResponseEntity<AuthorizationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,
				entity, AuthorizationDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public AuditNotificationStartDTO modifyAuditNotificationStart(AuditNotificationStartDTO ans) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyAuditNotificationStart";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<AuditNotificationStartDTO>(ans, headers);

		ResponseEntity<AuditNotificationStartDTO> response = restTemplate.exchange(builder.toUriString(),
				HttpMethod.POST, entity, AuditNotificationStartDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public FieldEvidenceDTO modifyFieldEvidence(FieldEvidenceDTO fv) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyFieldEvidence";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<FieldEvidenceDTO>(fv, headers);

		ResponseEntity<FieldEvidenceDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,
				entity, FieldEvidenceDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public ObservationDTO modifyObservation(ObservationDTO observation) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyObservation";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<ObservationDTO>(observation, headers);

		ResponseEntity<ObservationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				ObservationDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public RecommandationDTO modifyRecommandation(RecommandationDTO recommandation) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyRecommandation";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<RecommandationDTO>(recommandation, headers);

		ResponseEntity<RecommandationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,
				entity, RecommandationDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}

	public RestrictionProposalDTO modifyRestrictionProposal(RestrictionProposalDTO rp) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/modifyRestrictionProposal";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<RestrictionProposalDTO>(rp, headers);

		ResponseEntity<RestrictionProposalDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST,entity, RestrictionProposalDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}
		return null;
	}
	
	
	public List<DossierDTO> searchDossier(DossierReq req)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/searchDossier";
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<DossierReq>(req,headers);
		
		ParameterizedTypeReference<List<DossierDTO>> typeRef = new ParameterizedTypeReference<List<DossierDTO>>() {};
		
		ResponseEntity<List<DossierDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;
	}
	
	public List<AuthorizationDTO> getAuthorizations(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getAuthorizations/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AuthorizationDTO>> typeRef = new ParameterizedTypeReference<List<AuthorizationDTO>>() {};
		
		ResponseEntity<List<AuthorizationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	public List<AuditNotificationStartDTO> getAuditNotificationStarts(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getAuditNotificationStarts/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<AuditNotificationStartDTO>> typeRef = new ParameterizedTypeReference<List<AuditNotificationStartDTO>>() {};
		
		ResponseEntity<List<AuditNotificationStartDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	public List<FieldEvidenceDTO> getFieldEvidences(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getFieldEvidences/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<FieldEvidenceDTO>> typeRef = new ParameterizedTypeReference<List<FieldEvidenceDTO>>() {};
		
		ResponseEntity<List<FieldEvidenceDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	public List<ObservationDTO> getObservations(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getObservations/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<ObservationDTO>> typeRef = new ParameterizedTypeReference<List<ObservationDTO>>() {};
		
		ResponseEntity<List<ObservationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	public List<RecommandationDTO> getRecommandations(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getRecommandations/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<RecommandationDTO>> typeRef = new ParameterizedTypeReference<List<RecommandationDTO>>() {};
		
		ResponseEntity<List<RecommandationDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	public List<RestrictionProposalDTO> getRestrictionProposals(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getRestrictionProposals/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<RestrictionProposalDTO>> typeRef = new ParameterizedTypeReference<List<RestrictionProposalDTO>>() {};
		
		ResponseEntity<List<RestrictionProposalDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	public List<DocumentDTO> getDocuments(Integer id)
	{
		final String BASE_URL = IApiClient.SERVER+"/api/dossier/getDocuments/"+id;
	    
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		ParameterizedTypeReference<List<DocumentDTO>> typeRef = new ParameterizedTypeReference<List<DocumentDTO>>() {};
		
		ResponseEntity<List<DocumentDTO>> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, typeRef);
		
		if(response.getStatusCode() == HttpStatus.OK)
		{
			return response.getBody();
		}				
		
		return null;	
	}
	
	
	public FieldEvidenceDTO registerFieldEvidence(FieldEvidenceDTO fieldEvidence) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/registerFieldEvidence";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<FieldEvidenceDTO>(fieldEvidence, headers);

		ResponseEntity<FieldEvidenceDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				FieldEvidenceDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	
	public ObservationDTO registerObservation(ObservationDTO observation) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/registerObservation";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<ObservationDTO>(observation, headers);

		ResponseEntity<ObservationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				ObservationDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	
	public RecommandationDTO registerRecommandation(RecommandationDTO recommandation) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/registerRecommandation";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<RecommandationDTO>(recommandation, headers);

		ResponseEntity<RecommandationDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				RecommandationDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	
	
	public RestrictionProposalDTO registerRestrictionProposal(RestrictionProposalDTO restrictionProposal) {

		final String BASE_URL = IApiClient.SERVER + "/api/dossier/registerRestrictionProposal";

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(BASE_URL);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ErrorHandler());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer "+Util.getToken());
		HttpEntity<?> entity = new HttpEntity<RestrictionProposalDTO>(restrictionProposal, headers);

		ResponseEntity<RestrictionProposalDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity,
				RestrictionProposalDTO.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody();
		}

		return null;
	}
	
	
	
}
