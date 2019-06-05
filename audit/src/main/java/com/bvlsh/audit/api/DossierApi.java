package com.bvlsh.audit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bvlsh.audit.api.req.DossierReq;
import com.bvlsh.audit.dto.AuditNotificationStartDTO;
import com.bvlsh.audit.dto.AuthorizationDTO;
import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.dto.DossierDTO;
import com.bvlsh.audit.dto.FieldEvidenceDTO;
import com.bvlsh.audit.dto.ObservationDTO;
import com.bvlsh.audit.dto.RecommandationDTO;
import com.bvlsh.audit.dto.RestrictionProposalDTO;
import com.bvlsh.audit.exceptions.AppException;
import com.bvlsh.audit.security.TokenUtil;
import com.bvlsh.audit.services.DossierService;

@RestController
@RequestMapping("/api/dossier")
public class DossierApi {

	@Autowired DossierService dossierService;

	@RequestMapping(value = "/registerDossier", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerDossier(@RequestHeader(value = "Authorization") String token,@RequestBody DossierDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			DossierDTO d = dossierService.create(dto, uname);
			return new ResponseEntity<>(d, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyDossier", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyDossier(@RequestHeader(value = "Authorization") String token,@RequestBody DossierDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			DossierDTO d = dossierService.update(dto, uname);
			return new ResponseEntity<>(d, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyAuthorization", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyAuthorization(@RequestHeader(value = "Authorization") String token,@RequestBody AuthorizationDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			AuthorizationDTO a = dossierService.update(dto, uname);
			return new ResponseEntity<>(a, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyAuditNotificationStart", method = RequestMethod.POST, produces = {
			"application/json" })
	public ResponseEntity<?> modifyAuditNotificationStart(@RequestHeader(value = "Authorization") String token,	@RequestBody AuditNotificationStartDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			AuditNotificationStartDTO a = dossierService.update(dto, uname);
			return new ResponseEntity<>(a, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyFieldEvidence", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyFieldEvidence(@RequestHeader(value = "Authorization") String token,@RequestBody FieldEvidenceDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			FieldEvidenceDTO fv = dossierService.update(dto, uname);
			return new ResponseEntity<>(fv, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyObservation", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyObservation(@RequestHeader(value = "Authorization") String token,@RequestBody ObservationDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			ObservationDTO fv = dossierService.update(dto, uname);
			return new ResponseEntity<>(fv, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyRecommandation", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modifyRecommandation(@RequestHeader(value = "Authorization") String token,@RequestBody RecommandationDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			RecommandationDTO r = dossierService.update(dto, uname);
			return new ResponseEntity<>(r, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/modifyRestrictionProposal", method = RequestMethod.POST, produces = {
			"application/json" })
	public ResponseEntity<?> modifyRestrictionProposal(@RequestHeader(value = "Authorization") String token,@RequestBody RestrictionProposalDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			RestrictionProposalDTO rp = dossierService.update(dto, uname);
			return new ResponseEntity<>(rp, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/searchDossier", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> searchDossier(@RequestHeader(value = "Authorization") String token,@RequestBody DossierReq req) {

		List<DossierDTO> dossiers = dossierService.searchDossiers(req);
		return new ResponseEntity<>(dossiers, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getAuthorizations/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAuthorizations(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<AuthorizationDTO> auths = dossierService.getAuthorizations(dossierId);
		return new ResponseEntity<>(auths, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getAuditNotificationStarts/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getAuditNotificationStarts(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<AuditNotificationStartDTO> l = dossierService.getAuditNotificationStarts(dossierId);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getFieldEvidences/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getFieldEvidences(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<FieldEvidenceDTO> l = dossierService.getFieldEvidences(dossierId);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getObservations/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getObservations(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<ObservationDTO> l = dossierService.getObservations(dossierId);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRecommandations/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getRecommandations(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<RecommandationDTO> l = dossierService.getRecommandations(dossierId);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRestrictionProposals/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getRestrictionProposals(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<RestrictionProposalDTO> l = dossierService.getRestrictionProposals(dossierId);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDocuments/{dossier_id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getDocuments(@RequestHeader(value = "Authorization") String token,
			@PathVariable(name = "dossier_id") Integer dossierId) {

		List<DocumentDTO> l = dossierService.getDocuments(dossierId);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/registerFieldEvidence", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerFieldEvidence(@RequestHeader(value = "Authorization") String token,@RequestBody FieldEvidenceDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			FieldEvidenceDTO fe = dossierService.create(dto, uname);
			return new ResponseEntity<>(fe, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/registerObservation", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerObservation(@RequestHeader(value = "Authorization") String token,@RequestBody ObservationDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			ObservationDTO o = dossierService.create(dto, uname);
			return new ResponseEntity<>(o, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/registerRecommandation", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerRecommandation(@RequestHeader(value = "Authorization") String token,@RequestBody RecommandationDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			RecommandationDTO r = dossierService.create(dto, uname);
			return new ResponseEntity<>(r, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/registerRestrictionProposal", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> registerRestrictionProposal(@RequestHeader(value = "Authorization") String token,@RequestBody RestrictionProposalDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			RestrictionProposalDTO rp = dossierService.create(dto, uname);
			return new ResponseEntity<>(rp, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	
}
