package org.articly.project.articly;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BackendTest1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
    // this Tests assest the truth that GetURL is equal to 7
	@Test
	public final void testgetURL() {
		BackendTest test = new BackendTest();
		String[] name = test.getURL(7);
		Assert.assertrue(name.getURL().equals(name));
		
	}

	// this junit test for equivalence if true of false 
	@Test
	public final void testgetURL1() throws JSONException, Exception{
		BackendTest test = new BackendTest();
		boolean output = test.equals(true);
		assertEquals(false, output);
	}
	// these two test sees if url is equal to 1 and 30
	@Test
	public final void testgetURL2()throws Exception {
	BackendTest test = new BackendTest();
	String [] result = test.getURL(1);
	assertArrayEquals(test.getURL(1), result);
	}
	@Test
	public final void testgetURL2()throws Exception {
    BackendTest test = new BackendTest();
	String [] result = test.getURL(30);
	assertArrayEquals(test.getURL(30), result);
		}

}
