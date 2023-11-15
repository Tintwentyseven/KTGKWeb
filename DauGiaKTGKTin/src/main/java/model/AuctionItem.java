package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

public class AuctionItem {
	private Long id;
	private String description;
	private double initialPrice;
	private double priceStep;
	private double currentPrice;
	private Calendar startDate;
	private Calendar endDate;
	private User seller;
	private String details;
	private List<Bid> bids = new ArrayList<Bid>();

	public AuctionItem(Long id, String description, double initialPrice, double priceStep,
			Calendar startDate, Calendar endDate, User seller) {
		this.id = id;
		this.description = description;
		this.initialPrice = initialPrice;
		this.priceStep = priceStep;
		this.startDate = startDate;
		this.endDate = endDate;
		this.seller = seller;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public User getSeller() {
		return seller;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public Duration getDuration() {
		return new Duration(startDate, endDate);
	}

	public void bid(User user, double amount) {
		if (amount < getCurrentPrice() + getPriceStep()) {
			throw new IllegalArgumentException(
					"Invalid argument: amount must greater than "
							+ (getCurrentPrice() + getPriceStep()));
		}
		this.getBids().add(new Bid(user, this, amount));
		setCurrentPrice(amount);
	}

	public double getPriceStep() {
		return priceStep;
	}

}
