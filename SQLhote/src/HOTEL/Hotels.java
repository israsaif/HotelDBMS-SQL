package HOTEL;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Hotels {
	public static boolean createHotelsTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Hotels "+
		"(id INTEGER not NULL, "
				+ " hotel_name  VARCHAR(8), "
				+ " hotel_location VARCHAR(8), "
				+ " created_date Date not null, " +
				" updated_date Date , " +
				"is_Active Boolean not null , " +
				" PRIMARY KEY ( id ))";
		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			java.sql.Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 1) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}
	public  void insertIntoTable(){
		
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		
			Scanner sa=new Scanner(System.in);
			System.out.println("Enter how many user you want to inport:");
			int user=sa.nextInt();
		    Random rn = new Random();
			Integer numberToAdd = rn.nextInt(100);
	
					 String hotel_name="ISRA";
					 String hotel_location="MUSCAT";
				     String created_date="2023-01-10";
				     String	updated_date="2022-05-12";
				     boolean is_Active=true;
				   		
				    for (int i = 0; i <=user; i++) {
				    	
				 String sql = "INSERT INTO  Hotels VALUES (" + i+numberToAdd + ",'"+(hotel_name+i)+"','" +hotel_location+"','"+created_date+"','"+updated_date+"',"+is_Active+")";
				 java.sql.Connection conn = null;
				 try {
						Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
						DriverManager.registerDriver(driver);
						conn = DriverManager.getConnection(url, username, password);
						java.sql.Statement st = conn.createStatement();
						int m = st.executeUpdate(sql);
						if (m >= 1) {
							System.out.println("inserted data successfuly...");
							
						} else {
							System.out.println(" faild inserted data...");
						}
						conn.close();
					}
					catch (Exception ex) {
						System.err.println(ex);
					}
					
	
}
}}