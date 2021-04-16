package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
/**
 * Servlet implementation class ControllerLogIn
 */
@WebServlet("/ControllerLogIn")
public class ControllerLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogIn() {
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
		
		// get the login data
		String userEmail = request.getParameter("email");
		String password = request.getParameter("pass");
		
		// Set values of the user bean
				UserBean bean = new UserBean();
				bean.setEmail(userEmail);
				bean.setPassword(password);
		
				// Check if the email and pass is correct.
				if (bean.validate(bean)) {
					
									
					// A new thing here "Session", a way to generate a ID to remember some date on
					// the client
					HttpSession session = request.getSession(); // its apart of the request

					
					// the user is logged in or not
					session.setAttribute("user", bean);

					request.setAttribute("user", bean);					
		
					

					// RequestDispatcher for when we want to send the request to the new page
					RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
					rd.forward(request, response);

					// response.sendRedirect only goes to the new page, and nothing else

				} else {
					// go to an error page that includes the index page to have the user try again
					RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
				}
	}

}
