package com.bvlsh.audit.exceptions;


/**
 *
 * @author lorela.shehu
 */
@SuppressWarnings("serial")
public class WrongPasswordException extends AppException {

	public WrongPasswordException()
    {super(); }
    
     public WrongPasswordException(String message){
      super(message);
     }
}
