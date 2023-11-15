package services;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import model.Booking;
import model.Customer;
import model.Tour;

public class TourDatabase {
	private static final TourDatabase instance = new TourDatabase();
	private Map<Long, Tour> tours = new HashMap<Long, Tour>();
	private Map<Long, Booking> bookings = new HashMap<Long, Booking>();
	private Map<Long, Customer> customers = new HashMap<Long, Customer>();
	private Long nextTourId = 1l;
	private Long nextCustomerId = 1l;
	private Long nextBookingId = 1l;

	private TourDatabase() {
		Tour t1 = new Tour(
				"PHÚ QUỐC (Khuyến mãi mùa hè)",
				"3 ngày 2 đêm",
				"Máy bay",
				"Hằng ngày",
				1595000,
				"<p><b>Ngày 01: ĐẾN PHÚ QUỐC : (máy bay)</b></br>"
						+ "Tham quan các điểm:  Làng chài Hàm Ninh. Tắm suối, leo núi tại Suối Tranh (theo mùa). "
						+ "Viếng chùa Sư Muôn. Tham tham quan thắng cảnh Dinh Cậu.</p>"
						+ "<p><b>Ngày 02: PHÚ QUỐC- SAY ĐẮM CÙNG THIÊN NHIÊN HOANG SƠ:</b></br>"
						+ "Tham quan các điểm: Nam Đảo. Cảng An Thới. Di tích nhà tù Phú Quốc. "
						+ "Cơ sở nuôi cấy ngọc trai. Tắm biển tại bãi Sao – nơi có bãi cát trắng dài và đẹp nhất Phú Quốc. "
						+ "Buổi chiều, đoàn sẽ tiếp tục tham quan: "
						+ "Tham quan Nhà thùng (cơ sở sản xuất nước mắm). Trại nuôi chó xoáy lưng Phú Quốc. "
						+ "Shop Cội Nguồn (cửa hàng bán hàng lưu niệm, đặc sản Phú Quốc). Viếng Sùng Hưng Tự. "
						+ "Ghé chợ Dương Đông</p>"
						+ "<p><b>Ngày 03: TẠM BIỆT PHÚ QUỐC : ( máy bay )</b></p>"
						+ "Ăn sáng và tự do tắm biển. Sau khi ăn trưa, Quý khách làm thủ tục trả phòng. "
						+ "Xe sẽ đưa đoàn ra sân bay về Sài Gòn.");

		Tour t2 = new Tour(
				"NHA TRANG",
				"2 ngày 2 đêm",
				"Tàu hỏa",
				"Tối thứ 6 và CN",
				1540000,
				"<p><b>Ngày 01 (Thứ bảy): PHỐ BIỂN NHA TRANG.</b></br>"
						+ "Tham quan suối Hoa Lan. Khám phá Mê Cung Trận Đồ. Chèo thuyền, ngắm cảnh trên Hồ Nghinh Xuân - Thủy Tiên."
						+ "KDL Hòn Lao - Đảo Khỉ. Tham gia chương trình giải trí tại Thế giới giải trí Vinpearl Land.</p>"
						+ "<p><b>Ngày 02 (Chủ nhật) : NHA TRANG – SÀI GÒN ( tàu lửa)</b></br>"
						+ "Tham quan Tháp Bà Ponagar. Chùa Long Sơn. Ngắm cảnh Hòn Chồng, núi Cô Tiên. Khu du lịch Suối Khoáng Nóng Tháp Bà."
						+ "Ăn tối, xe đưa quý khách ra ga Nha Trang khởi hành về Sài Gòn bằng tàu lửa. Kết thúc chuyến tham quan, hẹn ngày gặp lại.");

		Tour t3 = new Tour("CÔN ĐẢO", "3 ngày 2 đêm", "Máy bay", "Hằng ngày",
				1345000, "");

		Tour t4 = new Tour("PHAN THIẾT-MŨI NÉ", "3 ngày 2 đêm", "Ôtô",
				"Thứ 7 mỗi tuần", 1250000, "");

		Tour t5 = new Tour("ĐÀ LẠT - ĐỒI MỘNG MƠ", "4 ngày 3 đêm", "Ôtô",
				"Thứ 7 mỗi tuần", 1320000, "");

		Tour t6 = new Tour("BUÔN MA THUỘT - GIA LAI - KOMTUM", "4 ngày 3 đêm",
				"Ôtô", "Định kỳ", 1790000, "");

		addTour(t1);
		addTour(t2);
		addTour(t3);
		addTour(t4);
		addTour(t5);
		addTour(t6);

		Customer c1 = new Customer("Nguyen Van Tuan", "12 Nguyen Oanh GV",
				"nvtuan@yahoo.com", "0908760880");
		addCustomer(c1);

		Booking b1 = new Booking(c1, new GregorianCalendar(2008, 5, 28)
				.getTime(), 3, 1, t1);
		addBooking(b1);
	}

	public static TourDatabase getInstance() {
		return instance;
	}

	public synchronized void addTour(Tour tour) {
		Long id = nextTourId();
		tour.setId(id);
		tours.put(id, tour);
	}

	public synchronized void addCustomer(Customer customer) {
		Long id = nextCustomerId();
		customer.setId(id);
		customers.put(id, customer);
	}

	public synchronized void addBooking(Booking booking) {
		Long id = nextBookingId();
		booking.setId(id);
		bookings.put(id, booking);
	}

	public Collection<Tour> getAllTours() {
		return tours.values();
	}

	public Tour getTourById(Long id) {
		return tours.get(id);
	}

	private Long nextBookingId() {
		return nextBookingId++;
	}

	private Long nextCustomerId() {
		return nextCustomerId++;
	}

	private Long nextTourId() {
		return nextTourId++;
	}
}
