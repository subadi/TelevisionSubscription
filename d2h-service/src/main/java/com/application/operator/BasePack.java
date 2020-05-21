package com.application.operator;

import java.util.List;

import com.application.constant.Channels;

/**
 * @author subodhP
 *	Model to set pack services
 */
public class BasePack {

	private List<Channels> channel;
	private int price;
	public String packType;

	
	

	public BasePack() {

	}

	/**
	 * @return the packType
	 */
	public String getPackType() {
		return packType;
	}

	/**
	 * @param packType the packType to set
	 */
	public void setPackType(String packType) {
		this.packType = packType;
	}

	/**
	 * @return the channel
	 */
	public List<Channels> getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(List<Channels> channel) {
		this.channel = channel;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
