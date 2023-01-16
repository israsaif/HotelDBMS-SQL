package mAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Driver;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		Scanner sa = new Scanner(System.in);
		boolean bigMenu = true;
		while (bigMenu) {
			System.out.println("SELECT ONE OPTION:");
			System.out.println("1.READ API");
			System.out.println("2.CREATE TABLE");
			System.out.println("3.Insert API INTO TABLE");
			System.out.println("4.UPDATE  INTO TABLE");
			System.out.println("5.delete INTO TABLE");
			String bb = sa.next();
			int option = Integer.parseInt(bb);

			switch (option) {
			case 1:
				try {
					URL url = new URL("http://universities.hipolabs.com/search?country=United+States");
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
		
				break;
			case 2:
				Create Createtable=new Create();
				Createtable.createAPITable();
				
				break;
				
			case 3:
				  String url = "jdbc:mysql://localhost:3306/SqlDb";
				    String user = "root";
				    String pass = "root";
				
				    HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder()
							.uri(URI.create("http://universities.hipolabs.com/search?country=United+States")).build();
				
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					String uglyJsonString = response.body();

					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					JsonParser jp = new JsonParser();
					JsonElement je = jp.parse(uglyJsonString);
					String prettyJsonString = gson.toJson(je);
					System.out.println(prettyJsonString);
					ReadAPI[] M = gson.fromJson(prettyJsonString, ReadAPI[].class);
					for (ReadAPI A : M) {
				
						String webpage = A.getWeb_pages()[0];
						String state_province = A.getState_province();
						String alpha_two_code = A.getAlpha_two_code();
						String name = A.getName();
						String country = A.getCountry();
						String domian = A.getDomains()[0];
					
						String SQLqueryForInserting = "insert into API(web_pages,State_province, Alpha_two_code,name, country,domains)"
								+ " values('" + webpage + "' ,'" + state_province + "', '" + alpha_two_code
								+ "','" + name + "' ,' " +country  +  "','" +domian+"')";
					
						System.out.println(SQLqueryForInserting);
						Connection con = null;
						try {
							Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
							DriverManager.registerDriver(driver);
							con = DriverManager.getConnection(url, user, pass);
							java.sql.Statement st = con.createStatement();
				
							int m = st.executeUpdate(SQLqueryForInserting);
							if (m >= 0)
								System.out.println("inserted successfully : " + SQLqueryForInserting);
							else
								System.out.println("insertion failed");
						
							con.close();
						} catch (Exception ex) {
					
							System.err.println(ex);
						}
					}
				
				
				
				
				break;
			case 4:
				
				ForAll update=new ForAll();
				update. updateById();
				
				
				
				
				break;	
				
				
				
			case 5:
				
				ForAll delete=new ForAll();
				 delete.deleteById();
				 break;	
					
				
			}
			}bigMenu=false;
		
		
		
		
		
		}
}
