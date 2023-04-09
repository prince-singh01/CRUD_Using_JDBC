package com.jdbc.Student;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class studentDao {
	
	public static boolean insertStudent(Student st) {
		boolean f=false;
		try {
			Connection con=createConnection.createConn();
			String q="Insert into student(sName,sPhone,sCity) values(?,?,?)";
			
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, st.getStudentName());
			ps.setString(2, st.getStudentPhone());
			ps.setString(3, st.getStudentCity());
			
			ps.executeUpdate();
			f=true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	

	public static boolean deleteStudent(int userId) {
		boolean f=false;
		try {
			Connection con=createConnection.createConn();
			String q="delete from student where sId=?";
			
			PreparedStatement ps=con.prepareStatement(q);
			ps.setInt(1,userId);
						
			ps.executeUpdate();
			f=true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}
	
	
	public static boolean updateStudent(Student st) {
		boolean f=false;
		try {
			Connection con=createConnection.createConn();
			String q="update student set sName=?,sPhone=?,sCity=? where sId=?";
			
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, st.getStudentName());
			ps.setString(2, st.getStudentPhone());
			ps.setString(3, st.getStudentCity());
			
			ps.executeUpdate();
			f=true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	 
	public static void selectAllStudent() {
		boolean f=false;
		try {
			Connection con=createConnection.createConn();
			String q="select * from student";
			
			Statement st=con.createStatement();	
			ResultSet rs=st.executeQuery(q);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phoneNo=rs.getString(3);
				String city=rs.getString(4);
				
				System.out.println("Student Id : "+id+" Student Name : "+name+" Student Phone No. : "+phoneNo+" Student City : "+city);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		

		
	}
}
