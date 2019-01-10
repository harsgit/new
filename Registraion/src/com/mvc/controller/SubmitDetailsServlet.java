package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitDetailsServlet
 */
@WebServlet("/SubmitDetailsServlet")
public class SubmitDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitDetailsServlet() {
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
		HttpSession session=request.getSession(false);
		if(session.getAttribute("username")!=null) {
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			pw.print("<html><body>"
					+"<h3>"
					+ "Wlcome to Sentitems"
					+ session.getAttribute("username")
					+"! <br/>"
					
					+ "<a href = 'home.jsp'>go to loginpage </a>"
					+"</h3>"
					+"</body></html>");
			
		}else {
			
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			pw.print("<html><body>"
					+"<h3>"
					+ "stupid fello  login first!<br/>"
					+ "<a href = 'home.jsp'>go to loginpage </a>"
					+"</h3>"
					+"</body></html>");
		}
	}

}
