package OrderUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Translater {
	
	public static boolean Sender(String info) throws IOException {
		URL url = new URL("http://139.199.77.144:8080");
		URLConnection con = url.openConnection();
		
		con.setDoOutput(true);
		con.setRequestProperty("Pragma", "no-cache");
		con.setRequestProperty("Cache-control", "no-cache");
		con.setRequestProperty("Content-Type", "text/html");
		
		OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
		osw.write(info);
		osw.close();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
		String str = br.readLine();
		br.close();
		if(str == "0") 
			return false;
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Translater.Sender("≤‚ ‘ ˝æ›!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
