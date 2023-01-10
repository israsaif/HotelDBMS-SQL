package HOTEL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {

	public static void main(String[] args) {
		

	}
	public static void readFromGuests() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "Select * from guests where guest_name like '%E'";	// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String guest_Name = resultSet.getString(2);
				String guest_phone = resultSet.getString(3);
				int guest_accompanying_members = resultSet.getInt(4);
				int guest_payment_amount = resultSet.getInt(5);
				int room_id = resultSet.getInt(6);
				int hotel_id = resultSet.getInt(7);
				Date created_date = resultSet.getDate(8);
				Date updated_date = resultSet.getDate(9);
				Boolean is_Active = resultSet.getBoolean(10);
				System.out.println("id is : "+id + " guest Name is :" + guest_Name + " guest phone is :" + guest_phone +"guest accompanying members :"+guest_accompanying_members+ "guest payment amount"+guest_payment_amount+"room id :"+room_id+ " hotel id"+hotel_id+
						"created date : "+ created_date + "updated date :"
						+ updated_date + " is Active :" + is_Active);
				count++;
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	
	public static void RoomsWhereGuestMoreThan1000() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "Select * from Rooms  INNER join guests on guests.room_id=Rooms.id where guests.guest_payment_amount>20";	// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			int user=5;
			while (resultSet.next()&&count<user) {
				Integer id = resultSet.getInt(1);
				Integer room_type_id = resultSet.getInt(2);
				Integer hotel_id = resultSet.getInt(3);
				String created_date = resultSet.getString(4);
				String updated_date = resultSet.getString(5);
				int is_Active = resultSet.getInt(6);
				Integer id1 = resultSet.getInt(7);
				String guest_name=resultSet.getString(8);
				int guest_phone=resultSet.getInt(9);
				System.out.println("id is : "+id + " room_type_id is :" + room_type_id + " hotel_id is :" + hotel_id +"created_date :"+created_date+ "updated_date"+updated_date+"is_Active :"+is_Active+ "  id"+id1+
						"guest_name: "+ guest_name + "guest_phone :"
						+ guest_phone );
				count++;
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public static void CountOfGuests() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		String sql = "Select Count(*) from guests  join  Rooms on guests.room_id=Rooms.id join  Room_Type where Room_Type.room_type_name='DELUXE'";	// Connection, Driver, DriverRegister lines will be exactly same

		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			java.sql.Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
			
				System.out.println("Count of guests who are staing in 'DELUXE' rooms : "+id );
				
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	public void guestsNotActiveWithDeluxe() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";

		int user = 8;
		String sql = "SELECT * from  guests INNER join Rooms ON guests.room_id = Rooms.id INNER JOIN Employees ON Rooms.id = Employees.room_id INNER JOIN EmployeeType"
				+ "ON Employees.employee_type_id = EmployeeType.id WHERE EmployeeType.employee_type_name LIKE '%A%';";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;
			int user1=3;
			while (resultSet.next()&& (count< user1) ) {
				String id=resultSet.getString(1);
				String   room_type_id=resultSet.getString(2);
				String   hotel_id=resultSet.getString(3);
				String   created_date= resultSet.getString(4);
				String   updated_date= resultSet.getString(5);
				int   is_Active= resultSet.getInt(6);
				int   id1= resultSet.getInt(7);
				String   room_type_name= resultSet.getString(8);
			
				System.out.println( id+" "+room_type_id+" "+hotel_id+" "+created_date+" "+updated_date+" "+is_Active+" "+id1+""+room_type_name);
				
				count++;
			
			
				
				
			}
			
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
		
		
	}
	public void hotelswhnamehavEH() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		String sql = "SELECT COUNT(Rooms.room_type_id), Room_Type.room_type_name FROM Rooms INNER JOIN Room_Type ON Rooms.room_type_id = Room_Type.id GROUP BY room_type_name HAVING COUNT(Rooms.room_type_id) > 2 ORDER BY COUNT(Rooms.room_type_id) DESC";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next() ) {
				
				if(resultSet.next()==true) {
				int CountOfRooms=resultSet.getInt(1);
				String   room_type_name=resultSet.getString(2);
				System.out.println( CountOfRooms+" "+room_type_name);
			
				}
				else
				{
					System.out.println( "No Rooms Avaliable");
				}
			}
			
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
public void GuestStaingInRooms() {
	String url = "jdbc:mysql://localhost:3306/HotelDBMS";
	String username = "root";
	String password = "root";
		String sql = "SELECT * FROM guests INNER JOIN Rooms ON guests.room_id = Rooms.id INNER JOIN Employees ON Rooms.id = Employees.room_id INNER JOIN Employee_Type  ON Employees.employee_type_id = Employee_Type.id WHERE Employee_Type.employee_type_name LIKE '%H%'\r\n"
				+ "";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next() ) {
				
				
				int id=resultSet.getInt(1);
				String   guest_name=resultSet.getString(2);
				int   guest_phone=resultSet.getInt(3);
				int   guest_accompanying_members=resultSet.getInt(4);
				System.out.println( id+" "+guest_name+""+guest_phone+guest_accompanying_members);
			
				
				
			}
			
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}




}
