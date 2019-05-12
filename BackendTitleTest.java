package org.articly.project.articly;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;

public class BackendTitleTest {
	
	/**
	 * This test the method shows if the buttons is not 1, 7 or 30 
	 * then test will fail. 
	 * If it is not daily, weekly, or monthly (1, 7, 30) then 
	 * test will fail. 
	 */
	@Test
	public void testGetTitles() throws JSONException, Exception {
		Backend test = new Backend();
		String[] result = test.getTitles(2);
		assertArrayEquals(test.getTitles(2), result);
	}
	
	/**
	 * This test shows us if there is any null for daily. 
	 */
	@Test
	public void test_Daily_Titles_Null() throws JSONException, Exception{
		Backend test = new Backend();
		String[] result = test.getTitles(1);
		assertNull(result);
	}
	
	/**
	 * This test shows us if there is any null for weekly. 
	 */
	@Test
	public void test_Weekly_Titles_Null() throws JSONException, Exception{
		Backend test = new Backend();
		String[] result = test.getTitles(7);
		assertNull(result);
	}
	
	/**
	 * This test shows us if there is any null for monthly. 
	 */
	@Test
	public void test_Monthly_Titles_Null() throws JSONException, Exception{
		Backend test = new Backend();
		String[] result = test.getTitles(7);
		assertNull(result);
	}
}	