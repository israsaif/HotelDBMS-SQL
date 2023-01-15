package mAPI;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
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
	}

}
