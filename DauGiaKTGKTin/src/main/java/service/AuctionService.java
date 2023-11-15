package service;

import java.util.Collection;

import model.AuctionItem;
import model.User;

public class AuctionService {
	private AuctionDatabase database;

	public AuctionService() {
		database = AuctionDatabase.getInstance();
	}

	public Collection<AuctionItem> getAllAuctionItems() {
		return database.getAllAuctionItems();
	}

	public AuctionItem getAuctionItem(Long id) {
		return database.getAuctionItem(id);
	}

	public User authenticateUser(String name, String password) {
		return database.authenticateUser(name, password);
	}

	public void bid(User user, AuctionItem item, double amount) {
		item.bid(user, amount);
	}
}
