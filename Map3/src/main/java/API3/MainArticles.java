package API3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class MainArticles {

	public static void main(String[] args) throws IOException, InterruptedException, Exception {
		Scanner sa = new Scanner(System.in);
		boolean Menu = true;
		while (Menu) {
			System.out.println("SELECT ONE OPTION:");
			System.out.println("1. SECTION");
			System.out.println("2.create SECTIONT able");

			System.out.println("3.Insert FOR SECTION ");

			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {

			case 1:

				sections Sections = new sections();
				Sections.READAPI();

				break;

			case 2:

				sections Sections1 = new sections();
				Sections1.createAPITable();

				break;

			case 3:
				String url1 = "jdbc:mysql://localhost:3306/section";
				String user1 = "root";
				String pass1 = "root";

				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(
						"https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=pqPfy3ImcWl7dWdPQv8GhDZxNchc5Ndu"))
						.build();

				HttpResponse<String> responses = client.send(request, HttpResponse.BodyHandlers.ofString());
				String uglyJsonString = responses.body();

				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp = new JsonParser();
				JsonElement je = jp.parse(uglyJsonString);
				String prettyJsonString = gson.toJson(je);
				//System.out.println(responses);
				APIresponse M = gson.fromJson(responses.body(), APIresponse.class);

				Connection con = null;

				Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url1, user1, pass1);

				for (int i = 0; i < 10; i++) {

					String SQLqueryForInserting = "insert into section(section_name,subsection_name)" + " values('"
							+ M.getResponse().getDocs()[0].getSection_name() + "','"
							+ M.getResponse().getDocs()[0].getSection_name() + "'" + ")";

					System.out.println("SQL : " + SQLqueryForInserting);

					try {

						java.sql.Statement st = con.createStatement();

						int m = st.executeUpdate(SQLqueryForInserting);
						if (m > 0)
							System.out.println("inserted successfully : " + SQLqueryForInserting);
						else
							System.out.println("insertion failed");

					} catch (Exception ex) {
						System.err.println(ex);
					}
				}
				con.close();
				break;

			}
		}
		Menu = false;

	}

}
