package com.crud;

import java.sql.*;
import java.util.*;

class MyConnection {
	String sql = null;
	ResultSet rs = null;
	Statement st = null;
	PreparedStatement pst = null;
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
	
	void insertValues(int id, String name, String city) throws SQLException{
		sql = "INSERT INTO EMP(emp_id, emp_name, emp_city) values(?,?,?)";
		pst =con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, city);
		pst.execute();
		display();
	}
	
	void update(int id, String city) throws SQLException {
		sql = "UPDATE EMP SET emp_city = ? WHERE emp_id = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, city);
		pst.setInt(2, id);
		pst.execute();
		System.out.println("\nNew Records:\n");
		display();
		
	}
}
public class MyCrud {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice;
		int operation;
		int id;
		String name;
		String city;
		MyConnection mc = new MyConnection();
		System.out.println("Initial Records\n");
		mc.display();
		do {
			System.out.println("Please select one of the following operation:");
			System.out.println("\n1. Insert a record.\n2. Update a record by id.\n3. Delete a record by id.\n4. Display the whole record");
			operation = sc.nextInt();
			switch(operation) {
			case 1:
				System.out.println("\nEnter the id: ");
				id = sc.nextInt();
				System.out.println("\nEnter your name: ");
				name = sc.next();
				System.out.println("\nEnter your city: ");
				city = sc.next();
				mc.insertValues(id, name, city);
				break;
			case 2:
				System.out.println("Enter the id of the record you want to update:");
				id = sc.nextInt();
				System.out.println("\nEnter new city:");
				city = sc.next();
				mc.update(id, city);
				break;
			case 3:
				break;
			
			case 4:
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
