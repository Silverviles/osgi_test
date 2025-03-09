package org.sa.event;

public class Event {
	
	private int eventId;
	private String eventName;
	private String eventDescription;
	private String eventLocation;
	private String startBidDateTime;
	private String endBidDateTime;
	
	
	public Event( String eventName, String eventDescription, String eventLocation, String startBidDateTime,  String endBidDateTime) {
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
	

	public String getStartBidDateTime() {
		return startBidDateTime;
	}
	
	public String getEndBidDateTime() {
		return endBidDateTime;
	}
	
	@Override
	public String toString() {
	    return "Event[ID=" + eventId + ", Name=" + eventName + 
	           ", Location=" + eventLocation + 
	           ", Start=" + startBidDateTime + ", End=" + endBidDateTime + "]";
	}

	

}
