package com.jdbcExample;

import java.sql.*;


public class MysqlCon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/koenig","root","root");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from emp");
			while(rs.next())
				System.out.println(rs.getInt(1)+ " " + rs.getString(2)+" " + rs.getString(3));
			con.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
