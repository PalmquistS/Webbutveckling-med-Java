package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SearchForBean;

/**
 * Servlet implementation class SearchForPostController
 */
@WebServlet("/SearchForPostController")
public class SearchForPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForPostController() {
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
		
				// get the new post data
				String searchForPost = request.getParameter("searchForPost");
				SearchForBean searchForBean = new SearchForBean();
				searchForBean.setQuestion(searchForPost);
				ArrayList<String> answer = new ArrayList<String>(); 
				answer=searchForBean.getAnswerFromSQL(answer);
				
				request.setAttribute("feeds", answer);
				RequestDispatcher rd = request.getRequestDispatcher("allFeeds.jsp");
				rd.forward(request, response);
	}

}
