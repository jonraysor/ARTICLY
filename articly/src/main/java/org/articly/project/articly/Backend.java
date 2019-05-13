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

    private static String Link;

    public static String getHTML(int numDays,  int type) throws Exception {

        getRequested(type);
        String urlToRead = MessageFormat.format(Link, numDays);
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

    // fucntion to get type of request
    // based off of
    private static String getRequested(int type){

        switch (type) {

            //most viewed
            case 1:
                Link = "https://api.nytimes.com/svc/mostpopular/v2/viewed/{0}.json?api-key=Pxp8OXdQJUtbRA5n3XAN0hCpFhL6qZeb\n";
                return Link;

            // most shared
            case 2:
                Link = "https://api.nytimes.com/svc/mostpopular/v2/shared/{0}.json?api-key=Pxp8OXdQJUtbRA5n3XAN0hCpFhL6qZeb\n";
                return Link;

            // most emailed
            case 3:
                Link = "https://api.nytimes.com/svc/mostpopular/v2/emialed/{0}.json?api-key=Pxp8OXdQJUtbRA5n3XAN0hCpFhL6qZeb\n";
                return Link;


        }
        return Link;
    }

    public static String [] getTitles(int numDays, int type) throws JSONException, Exception {

        // create JSON object with Backend functions
        JSONObject obj = new JSONObject(Backend.getHTML(numDays, type);
        //String pageName = obj.getString("results");

        // create JSON array to hold the results
        JSONArray arr = obj.getJSONArray("results");

        String [] titles = new String[30];

        // within each "result" we extract the title and print it to the screen
        for (int i = 0; i < arr.length(); i++) {
            String title = arr.getJSONObject(i).getString("title");
            String dataTitle = (i + 1 + ". " + title + "\n");
            titles[i] =  dataTitle;
        }

        return titles;

    }

    public static String [] getURL(int numDays, int type) throws JSONException, Exception {

        // create JSON object with Backend functions
        JSONObject obj = new JSONObject(Backend.getHTML(numDays, type));
        //String pageName = obj.getString("results");

        // create JSON array to hold the results
        JSONArray arr = obj.getJSONArray("results");

        String [] urls = new String[30];

        // within each "result" we extract the title and print it to the screen
        for (int i = 0; i < arr.length(); i++) {
            String url = arr.getJSONObject(i).getString("url");
            urls[i] =  url;
        }

        return urls;

    }
	   
}
