package org.articly.project.articly;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.sun.javafx.fxml.builder.URLBuilder;
import javafx.scene.control.Hyperlink;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.MessageFormat;

public class Backend {
 
	   public static String getHTML(int numDays) throws Exception {
		   
		   	  //int numDays = Backend.getDays();
		   
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
	   
	   public static String displayResults(int numDays) throws JSONException, Exception {
		   
		// create JSON object with Backend functions
			JSONObject obj = new JSONObject(Backend.getHTML(numDays));
			//String pageName = obj.getString("results");
			
			// create JSON array to hold the results
	        JSONArray arr = obj.getJSONArray("results");

	        StringBuilder sB = new StringBuilder();

	        // within each "result" we extract the title and print it to the screen
	        for (int i = 0; i < arr.length(); i++) {
				String url = arr.getJSONObject(i).getString("url");
	            String title = arr.getJSONObject(i).getString("title");
	            String dataTitle = (i + 1 + ": title: " + title + "\n");
				String dataURL = ("URL: " + url + "\n");
	            sB.append(dataTitle);
	            sB.append(dataURL);
	            sB.append("\n");
	        }

	        String output = sB.toString();
	        return output;

	   }

	   
}