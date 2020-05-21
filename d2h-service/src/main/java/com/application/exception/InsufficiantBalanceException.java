package com.application.exception;

/**
 * @author subodhP
 *	custom exception to handle Insufficiant balance exception
 */
public class InsufficiantBalanceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficiantBalanceException(String error)
	{
		super(error);
	}
	
}
