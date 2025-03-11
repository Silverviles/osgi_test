package org.sa.biddingService;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Scanner;

@Component(
        service = BiddingServiceCommand.class,
        property = {
                "osgi.command.scope=bid",
                "osgi.command.function=placeBid",
                "osgi.command.function=showHighestBid"
        },
        immediate = true
)

public class BiddingServiceCommand {
    private final Scanner scanner = new Scanner(System.in);
    private BiddingService biddingService;

    @Reference
    public void setBiddingService(BiddingService biddingService) {
        this.biddingService = biddingService;
    }

    @Descriptor("Place a bid on an item")
    public void placeBid() {
        System.out.println("Please enter the item ID");
        long itemId = Long.parseLong(scanner.nextLine());

        System.out.println("Please enter the event ID");
        long eventId = Long.parseLong(scanner.nextLine());

        System.out.println("Please enter the bidder name");
        String name = scanner.nextLine();

        System.out.println("Please enter the bid amount");
        double bidAmount = Double.parseDouble(scanner.nextLine());

        Bid bid = new Bid(itemId, eventId, name, bidAmount);
        biddingService.placeBid(bid);
    }
}
