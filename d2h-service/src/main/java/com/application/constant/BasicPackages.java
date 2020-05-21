package com.application.constant;

/**
 * @author subodhP
 * Enum to define different package systems
 */
public enum BasicPackages {

	    S("SILVER", 50), G("GOLD", 100);

	    private final String key;
	    private final Integer value;

	    BasicPackages(String key, Integer value) {
	        this.key = key;
	        this.value = value;
	    }

	    public String getKey() {
	        return key;
	    }
	    public Integer getValue() {
	        return value;
	    }
}
