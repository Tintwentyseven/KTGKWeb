package model;

import java.util.Date;

public class Booking {
	public long id;
	private Customer customer;
	private Date departureDate;
	private int noAdults;
	private int noChildren;
	private Tour tour;

	public Booking(Customer customer, Date departureDate, int noAdults,
			int noChildren, Tour tour) {
		this.customer = customer;
		this.departureDate = departureDate;
		this.noAdults = noAdults;
		this.noChildren = noChildren;
		this.tour = tour;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public int getNoAdults() {
		return noAdults;
	}

	public void setNoAdults(int noAdults) {
		this.noAdults = noAdults;
	}

	public int getNoChildren() {
		return noChildren;
	}

	public void setNoChildren(int noChildren) {
		this.noChildren = noChildren;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
