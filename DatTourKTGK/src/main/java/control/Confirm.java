package control;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Booking;
import model.Customer;
import model.Tour;
import services.TourService;

/**
 * Servlet implementation class Confirm
 */
@WebServlet("/confirm")
public class Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String telephoneNumber = request.getParameter("telephoneNumber");
		Date date = (Date) request.getAttribute("date");
		String adultString = request.getParameter("adult");
		String childString = request.getParameter("child");
		int adult =Integer.parseInt(adultString);
		int child = Integer.parseInt(childString);
		
		String idString = request.getParameter("tourId");
		System.out.println("id: "+idString);
		long id = Long.parseLong(idString);
		TourService server = new TourService();
		Tour tour = server.getTour(id);
		
		Customer customer = new Customer(name, address, email, telephoneNumber);
		Booking booking = new Booking(customer, date, adult, child, tour);
		
		server.saveCustomer(customer);
		server.saveBooking(booking);
		
		request.setAttribute("customer", customer);
		request.setAttribute("booking", booking);
		request.setAttribute("tour", tour);
		getServletContext().getRequestDispatcher("/confirm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
