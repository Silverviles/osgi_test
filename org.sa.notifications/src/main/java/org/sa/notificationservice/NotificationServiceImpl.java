package org.sa.notificationservice;

public class NotificationServiceImpl implements NotificationService{

	@Override
	public void notifyUsers(String message) {
		Notification notification = new Notification(message);
		System.out.println(notification);
		
	}

}
