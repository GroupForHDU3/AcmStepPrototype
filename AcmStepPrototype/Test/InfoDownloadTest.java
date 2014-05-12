import static org.junit.Assert.*;
import java.io.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


public class InfoDownloadTest {
	private InfoDownload info;
	private File file;
	private BufferedReader br;
	String expected_str1;
	String expected_str2;
	String expected_str3;
	String expected_str4;

	@Before
	public void setUp() throws Exception {
		info=new InfoDownload();
	}

	
	@Test
	public void testInit() {
		boolean bln1=info.init("lantian66");
		boolean bln2=info.init("kdjie899362");
		assertTrue(bln1);
		assertFalse(bln2);
	}

	
	@Test
	public void testGetinfo() {
		expected_str1="2009-05-20 14:54:55	1069";
		expected_str2="2008-06-21 15:04:16	1000";
		expected_str3="Rank	1358";
		expected_str4="2816	1	1";
		
		info.init("lantian66");
		info.getinfo();
		try{
		file=new File("E:\\doc\\lantian66_profile.txt");
		br=new BufferedReader(new FileReader(file));
		String str1=br.readLine();
		String str2,str3=null;
		while((str2=br.readLine())!=null){
			str3=str2;
		}
		boolean bln=expected_str1.equals(str1)&&expected_str2.equals(str3);
		
		assertTrue(bln);
		
		file=new File("E:\\doc\\lantian66_solvedproblem.txt");
		br=new BufferedReader(new FileReader(file));
		str1=br.readLine();
		while((str2=br.readLine())!=null){
			str3=str2;
		}
		assertEquals(expected_str3,str1);
		assertEquals(expected_str4,str3);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
