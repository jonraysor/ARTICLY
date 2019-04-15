package org.articly.project.articly;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.MessageFormat;
import java.util.TreeMap;

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
	   
	   public static String [] getTitles(int numDays) throws JSONException, Exception {
		   
		// create JSON object with Backend functions
			JSONObject obj = new JSONObject(Backend.getHTML(numDays));
			//String pageName = obj.getString("results");
			
			// create JSON array to hold the results
	        JSONArray arr = obj.getJSONArray("results");

	        String [] titles = new String[30];
	        
	        // within each "result" we extract the title and print it to the screen
	        for (int i = 0; i < arr.length(); i++) {
				String url = arr.getJSONObject(i).getString("url");
				String title = arr.getJSONObject(i).getString("title");
				String dataTitle = (i + 1 + ": title: " + title + "\n");
				String dataURL = ("URL: " + url + "\n");
				titles[i] =  dataTitle;
			}

	        return titles;

	   }

	public static String [] getURL(int numDays) throws JSONException, Exception {

		// create JSON object with Backend functions
		JSONObject obj = new JSONObject(Backend.getHTML(numDays));
		//String pageName = obj.getString("results");

		// create JSON array to hold the results
		JSONArray arr = obj.getJSONArray("results");

		String [] urls = new String[30];

		// within each "result" we extract the title and print it to the screen
		for (int i = 0; i < arr.length(); i++) {
			String url = arr.getJSONObject(i).getString("url");
			String title = arr.getJSONObject(i).getString("title");
			String dataTitle = (i + 1 + ": title: " + title + "\n");
			String dataURL = ("URL: " + url + "\n");
			urls[i] =  url;
		}

		return urls;

	}

	   
}
