import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.util.regex.*;

public class InfoDownload {
	String username;
	String filename;
	String urlstr;
	String strline; //html文件每行的内容
	String runid_str;
	int runid_int;
	URL url;
	
	String valid_regex;
	String runid_regex;
	String time_regex;
	String pro_regex;
	String last_regex;
	Pattern valid_pat;
	Pattern runid_pat;
	Pattern time_pat;
	Pattern pro_pat;
	Pattern last_pat;
	Matcher valid_mat;
	Matcher runid_mat;
	Matcher time_mat;
	Matcher pro_mat;
	Matcher last_mat;
	
	File file;
	OutputStreamWriter write;
	BufferedWriter bw;
	InputStream in;
	InputStreamReader read; 
	BufferedReader br;
	
	boolean isLastPage; //判断页面是否为最后一页
	
	
	public boolean init(String user_name){
		username=user_name;
		valid_regex=">No such user.<";
		valid_pat=Pattern.compile(valid_regex);
		urlstr="http://acm.hdu.edu.cn/userstatus.php?user="+username;
		try{
		url=new URL(urlstr);
		InputStream in=url.openStream();
		read = new InputStreamReader(in,"UTF-8"); 
		br=new BufferedReader(read);
		while((strline=br.readLine())!=null){
			valid_mat=valid_pat.matcher(strline);
			if(valid_mat.find())
				return false;
		}
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		urlstr="http://acm.hdu.edu.cn/status.php?user="+username+"&status=5";
		filename="E:\\doc\\"+username+"_profile.txt";
		try{
		url=new URL(urlstr);
		InputStream in=url.openStream();
		read = new InputStreamReader(in,"UTF-8"); 
		br=new BufferedReader(read);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			file=new File(filename);
			write = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			bw=new BufferedWriter(write);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		runid_regex="px>\\d+";
		time_regex="\\d+-\\d+-\\d+ \\d+:\\d+:\\d+";
		pro_regex=">\\d+</a>";
		last_regex="Next Page";
		
		runid_pat=Pattern.compile(runid_regex);
		time_pat=Pattern.compile(time_regex);
		pro_pat=Pattern.compile(pro_regex);
		last_pat=Pattern.compile(last_regex);
		
		return true;
	}
	public void getinfo(){
		while(!isLastPage){
			isLastPage=true;
		try{
			while((strline=br.readLine())!=null){
				runid_mat=runid_pat.matcher(strline);
				time_mat=time_pat.matcher(strline);
				pro_mat=pro_pat.matcher(strline);
				last_mat=last_pat.matcher(strline);
				if(last_mat.find())
					isLastPage=false;
				while(runid_mat.find() && time_mat.find() && pro_mat.find()){
					runid_str=runid_mat.group().substring(3);
					bw.write(time_mat.group()+"\t"+pro_mat.group().substring(1,5));
					bw.newLine();
				}
				bw.flush();//刷新缓冲区
			}
			if(!isLastPage){
			runid_int=Integer.parseInt(runid_str)-1;
			runid_str=String.valueOf(runid_int);
			urlstr="http://acm.hdu.edu.cn/status.php?first="+runid_str+"&user="+username+"&pid=&lang=&status=5#status";
			}
			//bin.close();
			//bw.close();
			url=new URL(urlstr);
			in=url.openStream();
			read = new InputStreamReader(in,"UTF-8"); 
			br=new BufferedReader(read);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		}
		
	}

}

