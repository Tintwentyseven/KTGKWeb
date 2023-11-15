package service;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Bid;
import model.AuctionItem;
import model.User;

public class AuctionDatabase {
	private static final AuctionDatabase instance = new AuctionDatabase();
	private Map<String, User> userData;
	private Map<Long, AuctionItem> itemData;
	private Long nextItemId = 1l;
	
	public AuctionDatabase(){
		init();
	}

	private void init() {
		userData = new HashMap<String, User>();
		itemData = new HashMap<Long, AuctionItem>();
		
		userData.put("hoangnv", new User("hoangnv", "hoangnv", "Nguyễn Văn Hoàng", 
				"0905600120", "hoangnv@yahoo.com", "12 Phường 4, Nguyễn Kiệm, Gò vấp, Tp.HCM"));
		userData.put("mrhuy", new User("mrhuy", "mrhuy", "Đỗ Cao Huy", 
				"0983243936", "traisitinhs@yahoo.com", "A75/6B/24 Phường 2 Quận Tân Bình. Tp.HCM"));
		userData.put("hoanglinhdung", new User("hoanglinhdung", "hoanglinhdung", "Dung Cuong", 
				"01682317716", "hoang_linh_dung@yahoo.com", "Nha Trang Khanh Hoa"));
		userData.put("tongdai108em", new User("tongdai108em", "123456", "ho quang tuan", 
				"0953298328", "tongdai108em@yahoo.com", "02 Trường Sa - Phường 17 Quận Bình Thạnh"));
		userData.put("t17", new User("t17", "t17", "Lê Thanh Tú", 
				"0983813688", "jackie_chinus@yahoo.com", "301/12 Nguyễn Văn Công - F3 - Gò Vấp"));
		userData.put("ngoc1972", new User("ngoc1972", "ngoc1972", "Nguyễn Ngọc Phúc", 
				"0918452080", "ngocphuc72@yahoo.com", "Quang Trung, Quận Gò Vấp, TPHCM"));
		userData.put("phandinhthanh", new User("phandinhthanh", "phandinhthanh", "Phan Dinh Thanh", 
				"0973304055", "dinhthanh_88h@yahoo.com.vn", "75/03, Dinh Tien Hoang, Tp Da Nang"));
		userData.put("ngaoop007", new User("ngaoop007", "ngaoop007", "Phan Dinh Thanh", 
				"0982085350", "ngaoop007@yahoo.com.vn", "125D Minh Khai, Hai Bà Trưng, Hà Nội"));
		userData.put("ngdxuan", new User("ngdxuan", "ngdxuan", "Nguyễn Đình Xuân", 
				"0988085300", "ndxuan@yahoo.com.vn", ""));
		userData.put("nguyenduclong", new User("nguyenduclong", "nguyenduclong", "Nguyen Duc Long", 
				"01699332116", "traxinh_8x@yahoo.com", ""));

		AuctionItem item1 = new AuctionItem(nextItemId(), "Máy chụp hình Canon ixy 910 IS (8.0 MP)", 
				100000.0, 100000.0, new GregorianCalendar(2008, Calendar.AUGUST, 26, 17, 40, 0),
				new GregorianCalendar(2008, Calendar.SEPTEMBER, 25, 17, 39, 0), userData.get("mrhuy"));
		item1.bid(userData.get("ngaoop007"), 200000.0);
		item1.bid(userData.get("phandinhthanh"), 300000.0);

		AuctionItem item2 = new AuctionItem(nextItemId(), "Laptop Acer 3680-2682 hang xach tay ! Chat luong con hao hang", 
				3000000.0, 300000.0, new GregorianCalendar(2008, Calendar.AUGUST, 21, 23, 4, 0),
				new GregorianCalendar(2008, Calendar.AUGUST, 30, 22, 1, 0), userData.get("hoanglinhdung"));
		item2.bid(userData.get("ngdxuan"), 4500000.0);
		
		AuctionItem item3 = new AuctionItem(nextItemId(), "Máy nghe nhạc APPLE iPHONE 16GB", 
				500000.0, 100000.0, new GregorianCalendar(2008, Calendar.AUGUST, 23, 23, 15, 0),
				new GregorianCalendar(2008, Calendar.SEPTEMBER, 2, 23, 15, 0), userData.get("t17"));
		item3.bid(userData.get("ngaoop007"), 600000.0);
		item3.bid(userData.get("nguyenduclong"), 700000.0);
		item3.bid(userData.get("ngaoop007"), 900000.0);
		item3.bid(userData.get("nguyenduclong"), 1000000.0);
		item3.bid(userData.get("ngoc1972"), 1200000.0);

		AuctionItem item4 = new AuctionItem(nextItemId(), "Bán gấp Nokia N72 chính hãng", 
				2600000.0, 200000.0, new GregorianCalendar(2008, Calendar.AUGUST, 26, 18, 42, 0),
				new GregorianCalendar(2008, Calendar.SEPTEMBER, 2, 18, 42, 0), userData.get("tongdai108em"));

		AuctionItem item5 = new AuctionItem(nextItemId(), "Nước hoa Embrace Him - 8057", 
				150000.0, 20000.0, new GregorianCalendar(2008, Calendar.AUGUST, 6, 20, 45, 0),
				new GregorianCalendar(2008, Calendar.AUGUST, 30, 20, 45, 0), userData.get("t17"));
		item5.bid(userData.get("ngoc1972"), 200000.0);
		item5.bid(userData.get("nguyenduclong"), 250000.0);
		item5.bid(userData.get("ngoc1972"), 275000.0);
		
		itemData.put(item1.getId(), item1);
		itemData.put(item2.getId(), item2);
		itemData.put(item3.getId(), item3);
		itemData.put(item4.getId(), item4);
		itemData.put(item5.getId(), item5);
	}
	
	public synchronized Collection<AuctionItem> getAllAuctionItems() {
		return itemData.values();
	}
	
	public synchronized User authenticateUser(String name, String password){
		User user = userData.get(name);
		if (user != null && user.getPassword().equals(password)){
			return user;
		}
		return null;
	}
	
	public synchronized AuctionItem getAuctionItem(Long id){
		return itemData.get(id);
	}
	
	public static AuctionDatabase getInstance(){
		return instance;
	}
	
	private Long nextItemId() {
		return nextItemId++;
	}
}
