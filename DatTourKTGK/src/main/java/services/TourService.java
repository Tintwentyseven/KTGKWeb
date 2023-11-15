package services;

import java.util.Collection;

import model.Booking;
import model.Customer;
import model.Tour;

public class TourService {
	private TourDatabase database;
	
	public TourService() {
		database = TourDatabase.getInstance();
	}
	
	public Collection<Tour> getAllTours(){
		return database.getAllTours();
	}
	
	public Tour getTour(Long id){
		return database.getTourById(id);
	}
	
	public void saveCustomer(Customer customer){
		database.addCustomer(customer);
	}
	
	public void saveBooking(Booking booking){
		database.addBooking(booking);
		System.out.println("success");
	}
}
