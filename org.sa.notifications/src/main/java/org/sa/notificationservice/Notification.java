package org.sa.notificationservice;

import java.time.LocalDateTime;

public class Notification {
	
	private String message;
	private LocalDateTime timestamp;
	
	
	public Notification(String message) {
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}
	
	public String getMessage() {
		return message;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	@Override
	public String toString() {
		return "Notification [message=" + message + ", timestamp=" + timestamp + "]";
	}

}
