package com.application.operator.impl;

import java.util.ArrayList;
import java.util.List;

import com.application.constant.Channels;
import com.application.operator.BasePack;

/**
 * @author subodhP
 *service pack scheme under base package
 */
public class SilverPack extends BasePack{

	private final static String type = "S"; 
	
	public SilverPack()
	{
		List<Channels> listChannel= new ArrayList<Channels>();
		listChannel.add(Channels.ZEE);
		listChannel.add(Channels.DISC);
		listChannel.add(Channels.NAT);
		super.setChannel(listChannel); 
		super.setPrice(50);
		super.setPackType(type);
	}
	
}
