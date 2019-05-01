
package junit.framework;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BackendTest {

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

//	@Test
//	public final void testgetURL() {
//		BackendTest test = new BackendTest();
//		String name = test.toString("URL");
//		Assert.assertrue(name.getURL().equals(name));
//		
//	}
	/*public final void testGetURL() {
		fail("Not yet implemented");
		System.out.println("Test good");
	}*/
	public final void testgetURL1() {
		BackendTest test = new BackendTest();
		boolean output = test.equals(true);
		assertEquals(false, output);
	}
//	public final void testgetURL2() {
//		Backendtest test = new BackendTest();
//		
		
	}

}