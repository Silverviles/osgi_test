package org.sa.event;

public interface EventService {
    void startEvent(String eventName);
	void endEvent(Long eventId);
	Double getEventSummary(Long eventId);
	Long getCurrentEvent();
}
