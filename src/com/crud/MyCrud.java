package com.crud;

import java.sql.*;
import java.util.*;

public class MyCrud {
	public static void main(String[] args) {
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
				break;
			default:
				System.out.println("Choose a proper option.");
			}
			System.out.println("Press 1 if you wish to continue. To exit, press any key");
			choice = sc.nextInt();
		}while(choice == 1);
	}
}
