package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.AuctionService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AuctionService forumService = new AuctionService();

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		String status = "";
		User user =forumService.authenticateUser(userName, password);
		
		if ( user != null) {
			status = "success";
			request.setAttribute("status", status);
			session.setAttribute("user", user);
			response.sendRedirect("listAution");
		}else {
			status = "failed";
			
			request.setAttribute("status", status);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		
	}

}
