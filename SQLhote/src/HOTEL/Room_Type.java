package HOTEL;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Random;
import java.util.Scanner;

public class Room_Type {
	public static boolean createRoom_TypeTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE Room_Type "+
		          "(id INTEGER not NULL, "+
				 " room_type_name VARCHAR(50)not null , "+
				 " created_date Date, " +
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
//   public  void insertIntoTable2(){
//		
//		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//		String username = "root";
//		String password = "root";
//		
//			Scanner sa=new Scanner(System.in);
//			System.out.println("Enter how many user you want to inport:");
//			int user=sa.nextInt();
//		    Random rn = new Random();
//			Integer numberToAdd = rn.nextInt(100);
//	
//					 String id="1111";
//					 String room_type_name="private";
//				     String created_date="2022-02-11";
//				     String	updated_date="2023-05-12";
//				     Integer is_Active=1;
//				   		
//				    for (int i = 0; i <=user; i++) {
//				    	
//				 String sql = "INSERT INTO Room_Type VALUES (" + i+numberToAdd + ",'"+(id+i)+"','" +room_type_name+"','"+created_date+"','"+updated_date+"',"+is_Active+")";
//				 java.sql.Connection conn = null;
//				 try {
//						Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
//						DriverManager.registerDriver(driver);
//						conn = DriverManager.getConnection(url, username, password);
//						java.sql.Statement st = conn.createStatement();
//						int m = st.executeUpdate(sql);
//						if (m >= 1) {
//							System.out.println("inserted data successfuly...");
//							
//						} else {
//							System.out.println(" faild inserted data...");
//						}
//						conn.close();
//					}
//					catch (Exception ex) {
//						System.err.println(ex);
//					}
//					
//	
//}
//}
}
