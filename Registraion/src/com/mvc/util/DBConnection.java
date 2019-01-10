package com.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {


	 public static Connection createConnection()
	 {
	 Connection con = null;
	 String url = "jdbc:oracle:thin:@10.219.34.3:1521/orcl"; //MySQL URL followed by the database name
	 String username = "trg711"; //MySQL username
	 String password = "training711"; //MySQL password
	 
	 try 
	 {
	 try 
	 {
	 Class.forName("com.mysql.jdbc.Driver"); //loading MySQL drivers. This differs for database servers 
	 } 
	 catch (ClassNotFoundException e)
	 {
	 e.printStackTrace();
	 }
	 
	 con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	 System.out.println("Printing connection object "+con);
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 
	 return con; 
	 }
	
}
