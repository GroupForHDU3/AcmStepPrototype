import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class DataCountTest {
	private DataCount obj;
	private String filename;

	@Before
	public void setUp() throws Exception {
		obj=new DataCount();
	}

	@Test
	public void testInit() {
		boolean bln1=obj.init("lantian66");
		assertTrue(bln1);
		boolean bln2=obj.init("lduf843j6o");
		assertFalse(bln2);
	}

	@Test
	public void testGetdata() {
		obj.init("lantian66");
		int count=obj.getdata().get("200905");
		assertEquals(11,count);
		count=obj.getdata().get("200901");
		assertNotEquals(10,count);
	}

	@Test
	public void testCountType() {
		obj.init("lantian66");
		int count=obj.countType().get("动态规划");
		assertNotEquals(10,count);
		
	}

}

