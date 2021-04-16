package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.NewFeedBean;
import beans.UserBean;

/**
 * Servlet implementation class FeedController
 */
@WebServlet("/NewPostController")
public class NewPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewPostController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the new post data
		String newPost = request.getParameter("newPost");
		String tagPost = request.getParameter("tagPost");

		if (newPost != "") {
			NewFeedBean newFeedBean = new NewFeedBean();
			newFeedBean.setFeedContent(newPost);
			newFeedBean.setFeedTag(tagPost);

			if (newFeedBean.newpostToSQL(newFeedBean)) {

				UserBean bean = (UserBean) request.getSession().getAttribute("bean");

				request.setAttribute("user", bean);

				RequestDispatcher rd = request.getRequestDispatcher("inputSQLSuccess.jsp");
				rd.forward(request, response);
			} else {
				// go to an error page that includes the index page to have the user try again
				RequestDispatcher rd = request.getRequestDispatcher("inputSQLFail.jsp");
				rd.forward(request, response);
			}
		}
	}

}
