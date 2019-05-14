package org.articly.project.articly;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;

public class BackendURLTest {
	/*
	 * This method checks if a string is returned. 
	 */
	@Test
	public void testGetURL() throws JSONException, Exception {
		Backend test =  new Backend(); 
		String [] result = test.getURL(7);
		assertArrayEquals(test.getURL(7), result);
	}
	/*
	 * This method checks if there is nulls in the URL. 
	 */
	@Test
	public void test_Null_URL() throws JSONException, Exception {
		Backend test = new Backend();
		String[] result = test.getURL(7);
		assertNull(result);
	}
	/*
	 * This method checks if output of URLs is the same from daily and weekly. 
	 */
	@Test
	public void test_Same() throws JSONException, Exception {
		Backend test = new Backend();
		String[] result = test.getURL(1);
		assertSame(result, test.getURL(7));
	}
	
}
