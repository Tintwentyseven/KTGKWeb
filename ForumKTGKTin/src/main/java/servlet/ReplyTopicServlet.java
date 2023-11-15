package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Message;
import model.Topic;
import model.User;
import service.ForumService;

/**
 * Servlet implementation class ReplyTopicServlet
 */
@WebServlet("/reply")
public class ReplyTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyTopicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    String id = request.getParameter("id");
	    Topic topic = ForumService.getInstance().findTopic(Integer.parseInt(id));
		request.setAttribute("id", id);
		request.setAttribute("title", topic.getTitle());
		request.getRequestDispatcher("replyTopic.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		HttpSession sess = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User) sess.getAttribute("user");
		Message mess = new Message(title, content, user);
		Topic topic = ForumService.getInstance().findTopic(Integer.parseInt(id));

		
		topic.addMessage(mess);
		response.sendRedirect("topics?id=" + id);
	}

}
