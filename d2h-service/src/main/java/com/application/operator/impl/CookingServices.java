package com.application.operator.impl;

import com.application.operator.SpecialServices;

/**
 * @author subodhP cooking
 *  special service class
 */
public class CookingServices extends SpecialServices {

	private final static String LEARNCOOKING = "LearnCooking";

	public CookingServices() {
		super.setServiceName(LEARNCOOKING);
		super.setPrice(200);
	}

}
