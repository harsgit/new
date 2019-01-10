package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.bean.RegisterBean;
import com.mvc.dao.RegisterDao;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("fuck");
		
		
		  String studentName=request.getParameter("studentName");;
		  String studentDept=request.getParameter("studentDept");;
		  String marks12th=request.getParameter("marks12th");;
		  String mobileNumber=request.getParameter("mobileNumber");;
		  String percentage=request.getParameter("percentage");;
		 
		 RegisterBean registerBean = new RegisterBean();
		 //Using Java Beans - An easiest way to play with group of related data
		 registerBean.setStudentName(studentName);
		 registerBean.setStudentDept(studentDept);
		 registerBean.setMarks12th(marks12th);
		 registerBean.setMobileNumber(mobileNumber); 
		 registerBean.setPercentage(percentage); 
		 
		 RegisterDao registerDao = new RegisterDao();
		 
		 //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
		 String userRegistered = registerDao.registerUser(registerBean);
	System.out.println("hello");	 
	HttpSession session=request.getSession(false);
	if(session.getAttribute("username")!=null) {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><body>"
				+"<h3>"
				+ "Wlcome to inbox"
				+ session.getAttribute("username")
				+"! <br/>"
				+ "<form action='SubmitDetailsServlet' method='post'><input type='submit' value='Submit'></form>"
				+ "<br/>"
				
				+ "<a href = 'home.jsp'>go to loginpage </a>"
				+"</h3>"
				+"</body></html>");
		response.sendRedirect("/success.html");
		
	}
	

	
		 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
		 {
			 System.out.println("hellohi");
		 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userRegistered);
		 request.getRequestDispatcher("/Register.jsp").forward(request, response);
		 }
		 
		
	}

}
