package com.crud;

import java.sql.*;
import java.util.*;

class MyConnection {
	String sql = null;
	ResultSet rs = null;
	Statement st = null;
	Connection con = null;
	MyConnection() throws SQLException, ClassNotFoundException{
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-MPCSACL:1521:XE","system","admin");
		st = con.createStatement();
		
	}
	
	void display() throws SQLException{
		sql = "SELECT * FROM EMP";
		rs = st.executeQuery(sql);
		System.out.println("ID\tNAME\tCITY");
		while(rs.next()) {
			int id = rs.getInt("emp_id");
			String name = rs.getString("emp_name");
			String city = rs.getString("emp_city");
			System.out.println(id+"\t"+name+"\t"+city);
		}
		rs.close();
	}
}
public class MyCrud {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice;
		int operation;
		do {
			System.out.println("Please select one of the following operation:");
			System.out.println("\n1. Insert a record.\n2. Update a record by id.\n3. Delete a record by id.\n4. Display the whole record");
			operation = sc.nextInt();
			switch(operation) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			
			case 4:
				MyConnection mc = new MyConnection();
				mc.display();
				break;
			default:
				System.out.println("Choose a proper option.");
			}
			System.out.println("Press 1 if you wish to continue. To exit, press any key");
			choice = sc.nextInt();
		}while(choice == 1);
	}
}
