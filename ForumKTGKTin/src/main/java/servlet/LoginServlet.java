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
import service.ForumService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ForumService forumService = new ForumService();

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Login.jsp").forward(request, response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		String status = "";
		User user =forumService.checkUser(userName, password);
		
		if ( user != null) {
			status = "success";
			request.setAttribute("status", status);
			session.setAttribute("user", user);
			response.sendRedirect("topics");
		}else {
			status = "failed";
			
			request.setAttribute("status", status);
			dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}