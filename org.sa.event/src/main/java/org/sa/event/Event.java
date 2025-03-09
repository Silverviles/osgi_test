package org.sa.event;

import java.time.LocalDateTime;

public class Event {
	
	private int eventId;
	private String eventName;
	private String eventDescription;
	private String eventLocation;
	private LocalDateTime startBidDateTime;
	private LocalDateTime endBidDateTime;
	
	
	public Event( String eventName, String eventDescription, String eventLocation, LocalDateTime startBidDateTime,  LocalDateTime endBidDateTime) {
		this.eventId = generateEventId();
		this.eventName = eventName;
		this.startBidDateTime = startBidDateTime;
		this.eventDescription = eventDescription;
		this.eventLocation = eventLocation;
		this.endBidDateTime = endBidDateTime;
	}
	
	private int generateEventId() {
		return (int) (Math.random() * 1000);
	}
	
	public int getEventId() {
		return eventId;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	
	public String getEventLocation() {
		return eventLocation;
	}
	

	public LocalDateTime getStartBidDateTime() {
		return startBidDateTime;
	}
	
	public LocalDateTime getEndBidDateTime() {
		return endBidDateTime;
	}
	
	@Override
	public String toString() {
	    return "Event[ID=" + eventId + ", Name=" + eventName + 
	           ", Location=" + eventLocation + 
	           ", Start=" + startBidDateTime + ", End=" + endBidDateTime + "]";
	}

	

}
