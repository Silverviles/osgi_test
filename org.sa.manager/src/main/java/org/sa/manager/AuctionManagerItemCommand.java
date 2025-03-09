package org.sa.manager;

import java.util.Scanner;

import org.apache.felix.service.command.Descriptor;
import org.osgi.service.component.annotations.Component;

import org.sa.itemservice.Item;
import org.sa.itemservice.ItemService;
import org.sa.itemservice.ItemServiceImpl;
//import org.sa.bidder.BidderService;
//import org.sa.bidder.BidderServiceImpl;
//import org.sa.biddingService.Bid;
//import org.sa.biddingService.BiddingService;
//import org.sa.biddingService.BiddingServiceImpl;

@Component(
    service = AuctionManagerItemCommand.class,
    property = {
        "osgi.command.scope=item",
        "osgi.command.function=addItem",
        "osgi.command.function=createAuction",
        "osgi.command.function=endAuction",
//        "osgi.command.function=addBidder",
//        "osgi.command.function=placeBid",
//        "osgi.command.function=showHighestBid"
    },
    immediate = true
)
public class AuctionManagerItemCommand {

    private final Scanner scanner = new Scanner(System.in);
    private final ItemService itemService = new ItemServiceImpl();
    private final AuctionManagerService auctionManagerService = new AuctionManagerServiceImpl();
//    private final BidderService bidderService = new BidderServiceImpl();
//    private final BiddingService biddingService = new BiddingServiceImpl(itemService);


    @Descriptor("Interactively add a new item")
    public void addItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price;
        try {
            price = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid price input.");
            return;
        }

        itemService.AddItem(name, price);
        System.out.println("Item added: " + name + " with price " + price);

        // Optionally, list all items
        System.out.println("Current Items: " + itemService.listAllItems());
    }

    @Descriptor("Create a new auction for an item")
    public void createAuction() {
        System.out.print("Enter item name for auction: ");
        String itemName = scanner.nextLine();

        Item item = itemService.getItemByName(itemName);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        auctionManagerService.createAuction(item);
    }


    @Descriptor("End an auction for an item")
    public void endAuction() {
        System.out.print("Enter item ID to end auction: ");
        String itemId = scanner.nextLine();

        auctionManagerService.endAuction(itemId);
    }
    
//    @Descriptor("Register a new bidder")
//    public void addBidder() {
//        System.out.print("Enter bidder name: ");
//        String name = scanner.nextLine();
//        bidderService.addBidder(name);
//        System.out.println("Bidder added: " + name);
//    }
//
//    @Descriptor("Place a new bid")
//    public void placeBid() {
//        System.out.print("Enter item name to bid on: ");
//        String itemName = scanner.nextLine();
//
//        System.out.print("Enter bidder id: ");
//        String bidderId;
//        try {
//            bidderId = scanner.nextLine();
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid bidder id.");
//            return;
//        }
//
//        System.out.print("Enter bid amount: ");
//        double bidAmount;
//        try {
//            bidAmount = Double.parseDouble(scanner.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid bid amount.");
//            return;
//        }
//
//        Bid bid = new Bid(itemName, bidderId, bidAmount);
//        biddingService.placeBid(bid);
//    }
//
//    @Descriptor("Show the current highest bid")
//    public void showHighestBid() {
//        Bid highest = biddingService.getHighestBid();
//        if (highest != null) {
//            System.out.println("Highest bid: " + highest);
//        } else {
//            System.out.println("No bids placed yet.");
//        }
//    }
}
