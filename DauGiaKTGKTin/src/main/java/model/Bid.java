package model;

import java.util.Calendar;

public class Bid {
	private User bidder;
	private AuctionItem item;
	private double amount;
	private Calendar createdTime;

	public Bid(User bidder, AuctionItem item, double amount) {
		this.bidder = bidder;
		this.item = item;
		this.amount = amount;
	}

	public User getBidder() {
		return bidder;
	}

	public AuctionItem getItem() {
		return item;
	}

	public double getAmount() {
		return amount;
	}

	public Calendar getCreatedTime() {
		return createdTime;
	}
}
