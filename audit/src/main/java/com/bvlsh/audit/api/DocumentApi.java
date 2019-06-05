package com.bvlsh.audit.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bvlsh.audit.dto.DocumentDTO;
import com.bvlsh.audit.exceptions.AppException;
import com.bvlsh.audit.security.TokenUtil;
import com.bvlsh.audit.services.DocumentService;

@RestController
@RequestMapping("/api/document")
public class DocumentApi {
	
	@Autowired DocumentService documentService;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> register(@RequestHeader(value = "Authorization") String token,
			@RequestBody DocumentDTO dto) throws IOException {

		try {

			String uname = TokenUtil.getUsername(token);

			DocumentDTO d = documentService.create(dto, uname);
			return new ResponseEntity<>(d, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> modify(@RequestHeader(value = "Authorization") String token,
			@RequestBody DocumentDTO dto) {

		try {

			String uname = TokenUtil.getUsername(token);

			DocumentDTO d = documentService.update(dto, uname);
			return new ResponseEntity<>(d, HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	

	@RequestMapping(value = "/search/{dossierId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> searchDocument(@RequestHeader(value = "Authorization") String token, 
			@PathVariable("dossierId") Integer dossierId,
			@RequestParam(value="documentType", required=false) String documentType,
			@RequestParam(value="dossierNo", required=false) String dossierNo){
		
		List<DocumentDTO> list = documentService.search(dossierId, dossierNo, documentType);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
				
	}
	
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> delete(@RequestHeader(value = "Authorization") String token,
			@PathVariable("id") Integer id) throws IOException {

		try {

			String uname = TokenUtil.getUsername(token);

			documentService.delete(id, uname);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (AppException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
