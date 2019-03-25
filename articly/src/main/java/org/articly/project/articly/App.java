package org.articly.project.articly;
import java.io.FileInputStream;

import org.json.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        

    	//System.out.println(Backend.getHTML());
    	
    	// create JSON object with Backend functions
		JSONObject obj = new JSONObject(Backend.getHTML());
		//String pageName = obj.getString("results");
		
		// create JSON array to hold the results
        JSONArray arr = obj.getJSONArray("results");
        
        // within each "result" we extract the title and print it to the screen
        for (int i = 0; i < arr.length(); i++) {
        	String url = arr.getJSONObject(i).getString("url");
            String title = arr.getJSONObject(i).getString("title");
            System.out.println(i+1 + ": title: " + title + "\n");
            System.out.println("URL: " + url + "\n");
		
        }
        
        FileInputStream serviceAccount = new FileInputStream("/Users/jonathan/Desktop/work/School/CISC_3171/ARTICLY/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://articly-753c2.firebaseio.com")
            .build();

        FirebaseApp.initializeApp(options);
        
    }
}

