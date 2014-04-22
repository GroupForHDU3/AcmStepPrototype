import java.net.URL;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.*;

public class DataCount {
	String username;
	String filename;
	String strline;
	
	File file;
	OutputStreamWriter write;
	BufferedWriter bw;
	InputStream in;
	InputStreamReader read; 
	BufferedReader br;
	
	Map<String, Integer> map = new HashMap<String,Integer>();
	
	public boolean init(String user_name){
		username=user_name;
		filename="E:\\doc\\"+username+"_profile.txt";
		
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Map<String,Integer> getdata(){
		try{
			// br.readLine();
			/*while((strline=br.readLine())!=null){
				String[] s = strline.split("[-： ]+");
				System.out.println(s[0] + ":"  + s[1]);
			}*/
			while((strline=br.readLine())!=null){
				String[] s = strline.split("[-： ]+");
				// s[0]:年, s[1]：月, s[6]：题号;
				String time = s[0] + s[1];
				//System.out.println(time);
				if(map.containsKey(time))
					map.put(time, map.get(time)+1);
				else
					map.put(time, 1);
					
			}
			/*
			for(Map.Entry<String, Integer> entry:map.entrySet()){  
		           System.out.println(entry.getKey() + " " + entry.getValue());
		       }
		       */ 
		}
		catch(Exception e){
			e.printStackTrace();
		}
                return map;
	}

	//public 
	/**
	 * @param args
	 */
}
