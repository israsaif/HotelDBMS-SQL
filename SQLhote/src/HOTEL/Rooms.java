package HOTEL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Rooms {
		public static boolean createRoomsTable() {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String user = "root";
			String pass = "root";
			String sqlDB = "CREATE TABLE Rooms "+
					  "(id INTEGER not NULL, "+
					 " room_type_id INTEGER "+" REFERENCES room_type(id),"+
					 " hotel_id INTEGER "+" REFERENCES Hotels(id),"+
					 " created_date Date not null, " + 
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
		public static void insertIntoTable(){
			
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String username = "root";
			String password = "root";
			
				Scanner sa=new Scanner(System.in);
				//System.out.println("Enter how many rows you want:");
				System.out.println("How many Rooms you wants:");
				int ROOM2=sa.nextInt();
//				
//				System.out.println("Enter hotel name:");
//				int ROOM3=sa.nextInt();
				
			    Random rn = new Random();
				Integer numberToAdd = rn.nextInt(100);
				
//				         String id="111";  
//					     String room_type_id ="2222";
//					     String hotel_id="1234"; 
					     String created_date="2023-01-10";
					     String	updated_date="2022-05-12";
					     Integer is_Active=1;
					    for (int i = 4; i <=ROOM2; i++) {
					    	
					    	
					    	
//							 String sql = "select id from  Room_Type where room_type_name ="+ROOM2 + "select id from hotels where hotels name ="+ROOM3;
							 java.sql.Connection conn = null;
					    	
					    	
					    	
					 String sql1 = "INSERT INTO Rooms VALUES (" + i + ","+210+",'" +187+"','"+created_date+"','"+updated_date+"',"+is_Active+")";
					 java.sql.Connection conn1 = null;
					 try {
							Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
							DriverManager.registerDriver(driver);
							conn = DriverManager.getConnection(url, username, password);
							java.sql.Statement st = conn.createStatement();
							int m = st.executeUpdate(sql1);
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
		}
	
		public static void readFromTable(){
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String username = "root";
			String password = "root";
			
				Scanner sa=new Scanner(System.in);
				System.out.println("Enter how many users you have to print:");
				int user=sa.nextInt();
				
				
			    
				String sql = "SELECT * FROM Rooms";
				//Connection, Driver, DriverRegister lines will be exactly same
				
				
			 
				 java.sql.Connection conn = null;
				 try {
						Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
						DriverManager.registerDriver(driver);
						conn = DriverManager.getConnection(url, username, password);
						java.sql.Statement st = conn.createStatement();
						ResultSet resultSet = st.executeQuery(sql);
						int count=0;
						while(resultSet.next()&& count<user){
							 
							String id="111";  
							 String room_type_id ="2222";
							 String hotel_id="1234"; 
							Date created_date = resultSet.getDate(4);
							Date updated_date = resultSet.getDate(5);
							Boolean is_Active = resultSet.getBoolean(6);
							System.out.println(id+(room_type_id)+"','"+hotel_id+" "+created_date+" "+updated_date+" "+is_Active);
							count++;
							 }
					
						conn.close();
					}
					catch (Exception ex) {
						System.err.println(ex);
					}
				
	       }
		public static void getById(){
			
			
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			String username = "root";
			String password = "root";
			
				Scanner sa=new Scanner(System.in);
				System.out.println("id input from the user:");
				int user=sa.nextInt();
				
				
			    
				String sql = "select * from Rooms where id ="+user;
			
				
				
			 
				 java.sql.Connection conn = null;
				 try {
						Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
						DriverManager.registerDriver(driver);
						conn = DriverManager.getConnection(url, username, password);
						java.sql.Statement st = conn.createStatement();
					ResultSet resultSet = st.executeQuery(sql);
						int count=0;
						while(resultSet.next()&& count<user){
						
							String id="111";  
							 String room_type_id ="2222";
							 String hotel_id="1234"; 
							Date created_date = resultSet.getDate(4);
						Date updated_date = resultSet.getDate(5);
							Boolean is_Active = resultSet.getBoolean(6);
							System.out.println(id+1+" "+room_type_id+1+" "+hotel_id+1+" "+created_date+1+" "+updated_date+1+" "+is_Active);
							count++;
							 }
					
						conn.close();
					}
					catch (Exception ex) {
						System.err.println(ex);
					}
				
				 
				 }
		 public static  void updateById(){
			 
				String url = "jdbc:mysql://localhost:3306/HotelDBMS";
				String username = "root";
				String password = "root";
			 Connection conn = null;
				Statement stmt = null;
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (Exception e) {
						System.out.println(e);
					}
					conn = DriverManager.getConnection(url, username, password);
					System.out.println("Connection is created successfully:");
					stmt = (Statement) conn.createStatement();
					Scanner scanner = new Scanner(System.in);
					System.out.println("Please Enter any id to Update Rooms data :");
			         int userinput =scanner.nextInt();
			         System.out.println("Please Enter the new  room_type_id:");
			         String  room_type_id=scanner.next();
			         
			
			         Statement st = conn.createStatement();
			         String sql="UPDATE room_type SET room_type_id='"+room_type_id+"' WHERE id='"+userinput+"'";
				     int result=st.executeUpdate(sql);
					System.out.println("Record has been updated in the table successfully..................");
				} catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							conn.close();
					} catch (SQLException se) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
				System.out.println("Please check it in the MySQL Table. Record is now updated.......");
			
		 }
		 
		 public static void deleteById() {
				String url = "jdbc:mysql://localhost:3306/HotelDBMS";
				String username = "root";
				String password = "root";
			    Connection conn = null;
				Statement stmt = null;
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (Exception e) {
						System.out.println(e);
					}
					conn = DriverManager.getConnection(url, username, password);
					System.out.println("Connection is created successfully:");
					stmt = (Statement) conn.createStatement();
					Scanner scanner = new Scanner(System.in);
					System.out.println("Please Enter any id to delete room_type_id data :");
			         int userinput =scanner.nextInt();
			       
			
			         Statement st = conn.createStatement();
			         
			         
			         String sql="delete from Rooms where id ='"+userinput+"'";
				     int result=st.executeUpdate(sql);
					System.out.println("Record has been delete in the table successfully..................");
				} catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							conn.close();
					} catch (SQLException se) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
				System.out.println("Please check it in the MySQL Table. Record is now delete.......");
		 }
		 
		 public static void makeIsActiveFalseById() {
			 String url = "jdbc:mysql://localhost:3306/HotelDBMS";
				String username = "root";
				String password = "root";
			 Connection conn = null;
				Statement stmt = null;
				try {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (Exception e) {
						System.out.println(e);
					}
					conn = DriverManager.getConnection(url, username, password);
					System.out.println("Connection is created successfully:");
					stmt = (Statement) conn.createStatement();
					Scanner scanner = new Scanner(System.in);
					System.out.println("Please Enter any id to Update Rooms data :");
			         int userinput =scanner.nextInt();
			     
			
			         Statement st = conn.createStatement();
			         String sql="UPDATE Rooms SET is_Active=false LIMIT 10";
				     int result=st.executeUpdate(sql);
					System.out.println("Record has been updated in the table successfully..................");
				} catch (SQLException excep) {
					excep.printStackTrace();
				} catch (Exception excep) {
					excep.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							conn.close();
					} catch (SQLException se) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}
				System.out.println("Please check it in the MySQL Table. Record is now updated.......");
			
		 }
		 	
		
		
		
		
		
	}

