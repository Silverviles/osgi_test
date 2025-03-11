package org.sa.manager;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.sa.biddingService.BiddingService;
import org.sa.event.EventService;

import java.util.Scanner;
import org.sa.items.ItemService;

@Component(
        service = ManagerServiceCommand.class,
        property = {
                "osgi.command.scope=manager",
                "osgi.command.function=setMinimumBid",
                "osgi.command.function=addItem",
                "osgi.command.function=removeItem",
                "osgi.command.function=startEvent",
                "osgi.command.function=endEvent",
                "osgi.command.function=summary"
        },
        immediate = true
)
public class ManagerServiceCommand {
    private final Scanner scanner = new Scanner(System.in);

    private ManagerService managerService;

    private BiddingService biddingService;

    private EventService eventService;

    private ItemService itemService;

    @Reference
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Reference
    public void setBiddingService(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    @Reference
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Reference
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Descriptor("Set a minimum allowed bid value")
    public void setMinimumBid() {
        System.out.println("Enter the minimum bid value");
        double minimumBid = Double.parseDouble(scanner.nextLine());

        managerService.setMinimumBid(minimumBid);
    }

    @Descriptor("Add an item")
    public void addItem() {
        System.out.println("Enter the item name");
        String itemName = scanner.nextLine();

        itemService.AddItem(itemName);
    }

    @Descriptor("Remove an item")
    public void removeItem() {
        System.out.println("Enter the item ID");
        Long itemId = Long.parseLong(scanner.nextLine());

        itemService.removeItemById(itemId);
    }

    @Descriptor("Start an event")
    public void startEvent() {
        System.out.println("Enter the event name");
        String eventName = scanner.nextLine();

        if (eventService.getCurrentEvent() != -1) {
        	System.out.println("Event is already active. Event ID: " + eventService.getCurrentEvent());
        }

        eventService.startEvent(eventName);
    }

    @Descriptor("End an event")
    public void endEvent() {
        System.out.println("Enter Event ID");
        Long eventId = Long.parseLong(scanner.nextLine());

        if (eventService.getCurrentEvent() != eventId) {
        	System.out.println("That event is not currently active");
        	return;
        }

        eventService.endEvent(eventId);
    }
    
    @Descriptor("Event Summary")
    public void summary() {
    	System.out.println("Enter Event ID");
        Long eventId = Long.parseLong(scanner.nextLine());
        
        System.out.println("Highest bid for the event is : " + eventService.getEventSummary(eventId));
    }
}
