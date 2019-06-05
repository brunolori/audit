/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvlsh.audit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author lorela.shehu
 */
@ResponseStatus(value=HttpStatus.CONFLICT)
public class EntityExistsException extends AppException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7268310653039569420L;

	public EntityExistsException() {
    }

    public EntityExistsException(String message) {
        super(message);
    }
    
}