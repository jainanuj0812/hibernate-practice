package com.hibernate.TestConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectiion {

	public static void main(String[] args) {
		String user = "hbstudent";
		String pass = "hbstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		
		try {
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection Successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
