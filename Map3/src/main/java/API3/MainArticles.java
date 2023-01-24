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
			System.out.println("1.read api SECTION");
			System.out.println("2.create SECTIONT Table");
			System.out.println("3.Insert FOR SECTION ");
			System.out.println("4.read api Authors");
			System.out.println("5.create Authors Table");
			System.out.println("6.Insert Authors ");
			System.out.println("7.read api Articals");
			System.out.println("8.create Articals Table");
			System.out.println("9.Insert Articals ");

			
			
			
			
			

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

				
			case 4:	
				
				
				authors Authors=new authors();
				Authors.READAuthorssAPI(); 
	
				break;	
				
				
				
				
			case 5:	
				
		
				authors Authors1 = new authors();
				Authors1.createAuthorssTable();

				break;	
				
			case 6:		
				
				String url12 = "jdbc:mysql://localhost:3306/section";
				String user12 = "root";
				String pass12 = "root";

				HttpClient client2 = HttpClient.newHttpClient();
				HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("https://api.nytimes.com/svc/search/v2/articlesearch.json?q=election&api-key=pqPfy3ImcWl7dWdPQv8GhDZxNchc5Ndu")).build();

				HttpResponse<String> responses2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());
				String uglyJsonString2 = responses2.body();

				Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp2 = new JsonParser();
				JsonElement je2 = jp2.parse(uglyJsonString2);
				String prettyJsonString2 = gson2.toJson(je2);
				//System.out.println(responses);
				APIresponse M2 = gson2.fromJson(responses2.body(), APIresponse.class);

				Connection con2 = null;

				Driver driver2 = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver2);
				con = DriverManager.getConnection(url12, user12, pass12);

				for (int i = 0; i < 10; i++) {

					String SQLqueryForInserting = "insert into Authors(firstname,lastname)" + " values('"
						+ M2.getResponse().getDocs()[1].getByline().getPerson()[1].getFirstname() + "','"
							+ M2.getResponse().getDocs()[1].getByline().getPerson()[1].getLastname() + "'" + ")";

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
				
				
			case 7:
				
				
				articles Articals=new articles();
				Articals.READAPIarticles();
				
			
				
				break;
				
			case 8:

				articles Articles= new articles();
				Articles.createArticlesTable();	
				
				
				break;
			
			case 9:
			
			String url11 = "jdbc:mysql://localhost:3306/section";
			String user11 = "root";
		    String pass11 = "root";

				HttpClient client1 = HttpClient.newHttpClient();
				HttpRequest request1 = HttpRequest.newBuilder().uri(URI.create(
						"https://api.nytimes.com/svc/topstories/v2/home.json?api-key=pqPfy3ImcWl7dWdPQv8GhDZxNchc5Ndu"))
						.build();

				HttpResponse<String> responses1 = client1.send(request1, HttpResponse.BodyHandlers.ofString());
				String uglyJsonString1 = responses1.body();

				Gson gson1 = new GsonBuilder().setPrettyPrinting().create();
				JsonParser jp1 = new JsonParser();
			JsonElement je1 = jp1.parse(uglyJsonString1);
				String prettyJsonString1 = gson1.toJson(je1);
				//System.out.println(responses);
				APIresult M1 = gson1.fromJson(responses1.body(), APIresult.class);

				Connection con1 = null;

				Driver driver1 = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				DriverManager.registerDriver(driver1);
				con = DriverManager.getConnection(url11, user11, pass11);

			for (int i = 0; i < 10; i++) {

					String SQLqueryForInserting = "insert into articles(title,published_date,type,subtype)" + " values('"
						    + M1.getResult().getTitle()+"','"+M1.getResult().getPublished_date()+"','"+M1.getResult().getMultimedia()[1].getType()+"','"
							+M1.getResult().getMultimedia()[1].getSubtype()+ "')";

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
					
		}	Menu = false;

	}

		
}
