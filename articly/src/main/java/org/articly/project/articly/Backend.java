package org.articly.project.articly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Backend {
 
	   public static String getHTML() throws Exception {
		   
		   	  String urlToRead = "https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=Pxp8OXdQJUtbRA5n3XAN0hCpFhL6qZeb\n";
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
