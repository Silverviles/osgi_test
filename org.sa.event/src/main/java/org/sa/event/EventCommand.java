package org.sa.event;


import java.time.LocalDateTime;
import java.util.Scanner;
import org.osgi.service.component.annotations.Component;
import org.apache.felix.service.command.Descriptor;

@Component(
    service = EventCommand.class,
    property = {
        "osgi.command.scope=event",
        "osgi.command.function=startEvent"
    }
)
public class EventCommand {

    @Descriptor("Starts a new event by asking for user input")
    public void startEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter event name: ");
        String name = scanner.nextLine();

        System.out.print("Enter event description: ");
        String description = scanner.nextLine();

        System.out.print("Enter event location: ");
        String location = scanner.nextLine();

        System.out.print("Enter bid start time (yyyy-MM-ddTHH:mm:ss): ");
        LocalDateTime startBidTime = LocalDateTime.parse(scanner.nextLine());

        System.out.print("Enter bid end time (yyyy-MM-ddTHH:mm:ss): ");
        LocalDateTime endBidTime = LocalDateTime.parse(scanner.nextLine());

        Event event = new Event(name, description, location, startBidTime, endBidTime);
        System.out.println("Event Created: " + event.getEventName() + " (ID: " + event.getEventId() + ")");
    }
}
