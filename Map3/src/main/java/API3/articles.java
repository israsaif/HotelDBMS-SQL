package API3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Scanner;

public class articles {

	
	public Result[] getResult() {
		return result;
	}

	public void setResult(Result[] result) {
		this.result = result;
	}

	Result[] result;
	
	public static void READAPIarticles() {
		try {
			URL url = new URL("https://api.nytimes.com/svc/topstories/v2/home.json?api-key=pqPfy3ImcWl7dWdPQv8GhDZxNchc5Ndu");
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
	
	public static boolean createArticlesTable() {
		String url = "jdbc:mysql://localhost:3306/section";
		String user = "root";
		String pass = "root";
		String sqlDB = "CREATE TABLE articles " + "(id INTEGER NOT NULL AUTO_INCREMENT, " + "title  VARCHAR(80), "
				+ " published_date VARCHAR(80), "+ " type VARCHAR(80), "+ " subtype VARCHAR(80), "+" Section_id INTEGER "+" REFERENCES section(id),"
				+"Authors_id INTEGER "+" REFERENCES authors(id),"
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
