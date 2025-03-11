package org.sa.event;

public class Event {

	private final Long eventId;
	private String eventName;
	private Boolean isEventActive;


	public Event(Long eventId, String eventName) {
		this.eventId = eventId;
		this.eventName = eventName;
		isEventActive = true;
	}

	public Long getEventId() {
		return eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Boolean getIsEventActive() {
		return isEventActive;
	}

	public void endEvent() {
		isEventActive = false;
	}
}
