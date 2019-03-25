package org.articly.project.articly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.text.MessageFormat;

public class Backend {
	
	
		public static int getDays() {
			
			Scanner reader = new Scanner(System.in);
			System.out.println("How Many days would you like to see (1,7,30)");
			int numDays = reader.nextInt();
			
			reader.close();
			
			return numDays;
		}
 
	   public static String getHTML() throws Exception {
		   
		   	  int numDays = Backend.getDays();
		   
		   	  String urlToRead = MessageFormat.format("https://api.nytimes.com/svc/mostpopular/v2/viewed/{0}.json?api-key=Pxp8OXdQJUtbRA5n3XAN0hCpFhL6qZeb\n", numDays); 
		   	  StringBuilder result = new StringBuilder();
		      URL url = new URL(urlToRead);
		      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		      conn.setRequestMethod("GET");
		      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		      String line;
		      while ((line = rd.readLine()) != null) {
		         result.append(line);
		      }
		      rd.close();
		      return result.toString();
	   }
	   
	   
	   
	   
}
