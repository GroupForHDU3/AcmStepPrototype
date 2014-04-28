import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TypeTitle {
	public static ArrayList<String> getTypeTitle(String type) {
		ArrayList<String> ret = new ArrayList<String>();
		String filename="E:\\doc\\sort.txt";
		String line, s[];
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			while((line=br.readLine())!=null) {
				s = line.split(" ");
				if(s[1].equals(type)) {
					ret.add(s[0]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
