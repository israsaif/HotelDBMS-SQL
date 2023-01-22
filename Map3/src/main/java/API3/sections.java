package API3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Scanner;

public class sections {
	public static void READAPI() {
	try {
		URL url = new URL("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=pqPfy3ImcWl7dWdPQv8GhDZxNchc5Ndu");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		StringBuilder informationString = new StringBuilder();
		int responseCode = conn.getResponseCode();
		if (responseCode != 200) {
			throw new RuntimeException("HttpresponseCode" + responseCode);
		} else {
			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNext()) {
				informationString.append(scanner.nextLine());
			}
			scanner.close();
			System.out.println(informationString);
		}
	} catch (Exception e) {
	System.out.println(e);
}

	
	
	}
	
	public static boolean createAPITable() {
		String url = "jdbc:mysql://localhost:3306/section";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE section " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + "section_name  VARCHAR(80), "
				+ " subsection_name VARCHAR(80), "  
			+ " PRIMARY KEY ( id ))";
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
	

	

