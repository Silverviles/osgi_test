package org.sa.event;


import java.util.ArrayList;
import java.util.List;
import org.sa.biddingService.BiddingService;

public class EventServiceImpl implements EventService {
    Long eventId = 0L;
    List<Event> events = new ArrayList<>();
    
    private BiddingService biddingService;

    public EventServiceImpl(BiddingService service) {
		this.biddingService = service;
	}

	@Override
    public void startEvent(String eventName) {
        Event event = new Event(eventId++, eventName);
        events.add(event);
    }

    @Override
    public void endEvent(Long eventId) {
        events.stream().filter(event -> event.getEventId().equals(eventId))
                .findFirst().
                ifPresent(Event::endEvent);
    }

    @Override
    public Double getEventSummary(Long eventId) {
        return biddingService.getHighestBid(eventId);
    }

	@Override
	public Long getCurrentEvent() {
		return events.stream()
				.filter(Event::getIsEventActive)
				.map(Event::getEventId)
				.findFirst()
				.orElse(-1L);
	}
}
