package com.application.operator.impl;
import java.util.ArrayList;
import java.util.List;

import com.application.constant.Channels;
import com.application.operator.BasePack;

/**
 * @author subodhP
 *	gold pack scheme under base pack
 */
public class GoldPack extends BasePack{

	private final static String type = "G"; 
	
	public GoldPack()
	{
		List<Channels>listChannel= new ArrayList<Channels>();
		listChannel.add(Channels.ZEE);
		listChannel.add(Channels.DISC);
		listChannel.add(Channels.NAT);
		listChannel.add(Channels.SONY);
		listChannel.add(Channels.STAR);
		super.setChannel(listChannel); 
		super.setPrice(100);
		super.setPackType(type);
	}
	
}
