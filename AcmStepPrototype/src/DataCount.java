import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	
    public Map<String,Integer> countType() {
        //System.out.println("55555");
        String profile ="E:\\doc\\"+ username + "_profile.txt";
        String sort = "E:\\doc\\sort.txt";
        Map<String, String> sort_map = new HashMap<String, String>();
        Map<String, Integer> ret = new HashMap<String, Integer>();
        try {
            BufferedReader sort_reader;
				sort_reader = new BufferedReader(new FileReader(new File(sort)));
            String line, s[], ss[];
            while((line=sort_reader.readLine())!=null) {
                //System.out.println(line);
                s = line.split(" ");
                //System.out.println(s[0]+"->"+s[1]);
                sort_map.put(s[0], s[1]);
            }
            //System.out.println("111");
            //System.out.println(user_name);
            //System.out.println("222");
            BufferedReader profile_reader;
			profile_reader = new BufferedReader(new FileReader(new File(profile)));
			
            while((line=profile_reader.readLine())!=null) {
                //System.out.println(lin e);
                ss = line.split("[-:\\t]+");
                //sss = ss[3].split("	");
                //System.out.println(ss[5]);
                //System.out.println(sss[0]);
                //s[6]题号
                //System.out.println(ss[5]);
                if(sort_map.containsKey(ss[5])) {
                    String type = sort_map.get(ss[5]);
                    if(ret.containsKey(type)) {
                        ret.put(type, ret.get(type)+1);
                    }
                    else {
                        ret.put(type, 1);
                    }
                }
            }
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ret;
    }
	//public 
	/**
	 * @param args
	 */
}
