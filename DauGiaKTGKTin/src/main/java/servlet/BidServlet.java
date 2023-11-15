package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuctionItem;
import model.User;
import service.AuctionService;

/**
 * Servlet implementation class BidServlet
 */
@WebServlet("/bid")
public class BidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AuctionService auctionService = new AuctionService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		User user = (User) sess.getAttribute("user");

		
		double price = Double.parseDouble(request.getParameter("price"));
		double priceStep = Double.parseDouble(request.getParameter("priceStep"));
		double currentPrice = Double.parseDouble(request.getParameter("currentPrice"));
		
		String id = request.getParameter("id");
		AuctionItem au = auctionService.getAuctionItem(Long.parseLong(id));
		
		if (price > currentPrice + priceStep) {
			auctionService.bid(user, au, price);
			response.sendRedirect("listAution");
		}else {
			response.sendRedirect("auction?id=" + id);
		}  

		
	}

}
