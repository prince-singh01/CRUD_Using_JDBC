package com.jdbc.Student;

import java.sql.Connection;
import java.sql.DriverManager;

public class createConnection {
	
	static Connection con;
	public static Connection createConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/student_management";
			String uname="root";
			String passowrd="root";
			con=DriverManager.getConnection(url,uname, passowrd);
			
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		return con;
	}
}
