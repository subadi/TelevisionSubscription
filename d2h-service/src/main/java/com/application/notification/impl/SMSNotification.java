package com.application.notification.impl;

import com.application.notification.Notification;

public class SMSNotification implements Notification {

	@Override
	public void sendNotification(String msg) {
		// SMS related notification
		
		System.out.println("SMS is sent succsfuuly trohu"+msg+ "pack");

	}

}
