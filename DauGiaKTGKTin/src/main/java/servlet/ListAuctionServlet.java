package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AuctionDatabase;
import service.AuctionService;

/**
 * Servlet implementation class ListAuctionServlet
 */
@WebServlet("/listAution")
public class ListAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AuctionService auctionService = new AuctionService();
	AuctionDatabase auctionDatabase = AuctionDatabase.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAuctionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("auction", auctionService.getAllAuctionItems());
		request.getRequestDispatcher("listItems.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
