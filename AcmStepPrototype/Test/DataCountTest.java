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

	//对统计某个账号任一月份做题数目的功能进行测试
	@Test
	public void testGetdata() {
		obj.init("lantian66");
		int count=obj.getdata().get("200905");
		assertEquals(11,count);
		count=obj.getdata().get("200901");
		assertNotEquals(10,count);
		count=obj.getdata().get("200806");
		assertEquals(6,count);
		count=obj.getdata().get("200807");
		assertNotEquals(100,count);
	}

	//测试某种类型的做题数目是否和实际值相等
	@Test
	public void testCountType() {
		obj.init("lantian66");
		int count=obj.countType().get("动态规划");
		assertNotEquals(10,count);
		count=obj.countType().get("贪心");
		assertEquals(3,count);
	}
	
	//测试某个账号的排名、解决的问题以及第一次通过的题数是否和预期值一样
	@Test
	public void testfirstAccept(){
		String expected_str0="1354";
		String expected_str1="282";
		String expected_str2="161";
		String not_expected="100";
		String str[]=obj.firstAccept("lantian66");
		assertEquals(expected_str0,str[0]);
		assertEquals(expected_str1,str[1]);
		assertEquals(expected_str2,str[2]);
		assertNotEquals(not_expected,str[2]);
		
		
	}

}

