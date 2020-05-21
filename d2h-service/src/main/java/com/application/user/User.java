package com.application.user;

import com.application.operator.BasePack;
import com.application.operator.SpecialServices;

/**
 * @author subodhP 
 * User model
 */
public class User {
	private String email;
	private String phone;
	protected int balance;
	private boolean isSubScribed;
	private BasePack basePack;
	private SpecialServices specialServices;

	/*
	 * public User() { balance = 100; isSubScribed = false; }
	 */

	public User(int balance) {
		this.balance = balance;
		isSubScribed = false;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the isSubScribed
	 */
	public boolean isSubScribed() {
		return isSubScribed;
	}

	/**
	 * @param isSubScribed the isSubScribed to set
	 */
	public void setSubScribed(boolean isSubScribed) {
		this.isSubScribed = isSubScribed;
	}

	/**
	 * @return the basePack
	 */
	public BasePack getBasePack() {
		return basePack;
	}

	/**
	 * @param basePack the basePack to set
	 */
	public void setBasePack(BasePack basePack) {
		this.basePack = basePack;
	}

	/**
	 * @return the specialServices
	 */
	public SpecialServices getSpecialServices() {
		return specialServices;
	}

	/**
	 * @param specialServices the specialServices to set
	 */
	public void setSpecialServices(SpecialServices specialServices) {
		this.specialServices = specialServices;
	}

}
