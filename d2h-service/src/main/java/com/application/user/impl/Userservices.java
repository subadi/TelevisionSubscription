package com.application.user.impl;

import com.application.exception.InsufficiantBalanceException;
import com.application.exception.InvalidInputException;

public interface Userservices {

	/**
	 * To display user balance
	 */
	int showBalance();

	/**
	 * To user balance
	 * 
	 * @return
	 * @throws InvalidInputException
	 */
	boolean recharge() throws InvalidInputException;

	/**
	 * Display All services offered
	 * 
	 * @return
	 */
	boolean viewAllService();

	/**
	 * TO Subscribe to gold or silver services
	 * 
	 * @return
	 */
	boolean subscribeBase();

	/**
	 * To add channel to current subscription
	 * @return 
	 */
	boolean addChannel();

	/**
	 * Subscribe speacial services such as english class or cookign classes.
	 * 
	 * @return
	 * @throws InsufficiantBalanceException
	 */
	boolean subscribeSpecialService() throws InsufficiantBalanceException;

	/**
	 * To display user's all subscription history
	 * 
	 * @return
	 */
	boolean viewDetails();

	/**
	 * update phone and email of user
	 * 
	 * @return
	 */
	boolean updatePhoneEmail();

}
