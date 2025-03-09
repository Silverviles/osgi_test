package org.sa.event;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EventServiceImpl implements EventService {


	@Override
	public void startEvent(String eventName, String eventDescription, String eventLocation, String startBidDateTime,
			String endBidDateTime) {
		
		// Convert date string to LocalDateTime
		LocalDateTime biddingStartTime = convertStringToDate(startBidDateTime);
		LocalDateTime biddingEndTime = convertStringToDate(endBidDateTime);
		
		// Create an event object
		Event event = new Event(eventName, eventDescription, eventLocation, biddingStartTime, biddingEndTime);
		
		System.out.println("Bidding started for event: " + event.getEventName());
		System.out.println("Location: " + event.getEventLocation());
		System.out.println("Bidding starts at: " + event.getStartBidDateTime());
		
	}
	
	
	//convert date string to LocalDateTime
	private LocalDateTime convertStringToDate(String date) {
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        return LocalDateTime.parse(date, formatter);
	    } catch (Exception e) {
	        throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd HH:mm", e);
	    }
	}
	




}
