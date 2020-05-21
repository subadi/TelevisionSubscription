package com.application.operator.impl;

import com.application.operator.SpecialServices;

/**
 * @author subodhP
 *  english special srvice class
 */
public class EnglishService extends SpecialServices {

	private final static String LEARNENGLISH = "LearnEnglish";

	public EnglishService() {
		super.setServiceName(LEARNENGLISH);
		super.setPrice(200);
	}

}
