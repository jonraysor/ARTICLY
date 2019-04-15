package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import java.util.Map;



@RestController

@RequestMapping("/game")

public class DemoController {

//	private final GameMetricsService gameMetricsService;

	

	@Autowired

	DemoController() {

//		this.gameMetricsService = gameMetricsService;

	}

	

	@RequestMapping("/test")
	public String viewTest() {

		return "test"; 

	}
	// https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=yourkey
	@RequestMapping("/nytime")
	public String viewNyTime() throws IOException {
		StringBuilder result = new StringBuilder();
		String urlToRead = "https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=Pxp8OXdQJUtbRA5n3XAN0hCpFhL6qZeb";
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