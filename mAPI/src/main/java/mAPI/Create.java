package mAPI;

import java.sql.Driver;
import java.sql.DriverManager;

public class Create {
	public static boolean createAPITable() {
		String url = "jdbc:mysql://localhost:3306/SqlDb";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE API " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + " web_pages  VARCHAR(80), "
				+ " state_province VARCHAR(80), " + " alpha_two_code VARCHAR(80), " + " name VARCHAR(80) , "
				+ "country VARCHAR(80) , " + " domains VARCHAR(80),"+ " PRIMARY KEY ( id ))";
		java.sql.Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
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
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return false;
	}
}
