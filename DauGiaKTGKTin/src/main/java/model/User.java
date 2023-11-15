package model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private String fullName;
	private String phone;
	private String email;
	private String address;
	private List<AuctionItem> itemsForSale = new ArrayList<AuctionItem>();

	public User(String username, String password, String fullName,
			String phone, String email, String address) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String companyName) {
		this.fullName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AuctionItem> getItemsForSale() {
		return itemsForSale;
	}
	
	public void postAuctionItem(AuctionItem item){
		this.getItemsForSale().add(item);
	}
}
