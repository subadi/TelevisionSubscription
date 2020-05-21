package com.application.constant;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author subodhP
 *enum of all available channel for subscription
 */
public enum Channels {

	ZEE("Zee",10),
	SONY("Sony",15),
	STAR ("Star Plus",20),
	DISC ("Discovery",10),
	NAT ("NatGeo",20),
	SPORT("Sport",30);

	public static  Set<Channels> addChannelSet = EnumSet.of(Channels.NAT,Channels.DISC);
		
	 private final String key;
	 private final Integer value;

	    Channels(String key, Integer value) {
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
