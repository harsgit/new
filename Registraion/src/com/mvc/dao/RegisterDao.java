package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class RegisterDao {
	 public String registerUser(RegisterBean registerBean)
	 {
	 String studentName = registerBean.getStudentName();
	 String studentDept = registerBean.getStudentDept();
	 String marks12th = registerBean.getMarks12th();
	 String mobileNumber = registerBean.getMobileNumber();
	 String percentage = registerBean.getPercentage();
	
	 
	 
	 Connection con = null;
	 PreparedStatement preparedStatement = null;
	 
	 try
	 {
	 con = DBConnection.createConnection();
	 String query = "insert into Studentdetails(studentName,studentDept,marks12th,mobileNumber,percentage) values (?,?,?,?,?)"; //Insert user details into the table 'USERS'
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, studentName);
	 preparedStatement.setString(2, studentDept);
	 preparedStatement.setString(3, marks12th);
	 preparedStatement.setString(4, mobileNumber);
	 preparedStatement.setString(5, percentage);
	 
	 int i= preparedStatement.executeUpdate();
	 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "SUCCESS"; 
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	 }
}
