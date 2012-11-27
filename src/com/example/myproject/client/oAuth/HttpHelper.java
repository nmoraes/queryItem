package com.example.myproject.client.oAuth;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Fernando Scasserra @fersca
 */
public class HttpHelper {

	public static String get(String url) {
				
		try {
			URL server = new URL(url);
					
			HttpURLConnection connection = (HttpURLConnection)server.openConnection();
			
			connection.setRequestMethod("GET");
			connection.addRequestProperty("Accept","application/json");		
			connection.setAllowUserInteraction(false);
			
			int code = connection.getResponseCode();	
			StringBuilder content = new StringBuilder();
				
			InputStream input;
			if (code>=400){
				input = connection.getErrorStream();
			} else {
				input = connection.getInputStream();
			}
									
			BufferedReader docHtml = new BufferedReader(new InputStreamReader(input));
				
			String line;
			
			while ((line = docHtml.readLine()) != null){
				
				content.append(line);
	
			}
			
			docHtml.close();
			
			connection.disconnect();
			
			return content.toString();
		} catch (Exception e){
			return e.getMessage();
		}
	}
	
	public static String post(String url, String data, String contentType) {
				
		try {
			URL server = new URL(url);
					
			HttpURLConnection connection = (HttpURLConnection)server.openConnection();
			
			connection.setRequestMethod("POST");
			connection.addRequestProperty("Accept","application/json");
			connection.addRequestProperty("Content-Type",contentType);

			connection.setRequestProperty("Content-Length", "" +Integer.toString(data.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");  
				
			connection.setUseCaches (false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
		    
		   // 	DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
		   	//wr.writeBytes (data);
		    	//wr.flush ();
		    //	wr.close ();			
			
			int code = connection.getResponseCode();	
			StringBuilder content = new StringBuilder();
				
			InputStream input;
			if (code>=400){
				input = connection.getErrorStream();
			} else {
				input = connection.getInputStream();
			}
									
			BufferedReader docHtml = new BufferedReader(new InputStreamReader(input));
				
			String line;
			
			while ((line = docHtml.readLine()) != null){
				
				content.append(line);
	 
			}
			
			docHtml.close();
			
			connection.disconnect();
			
			return content.toString();
		} catch (Exception e){
			return e.getMessage();
		}
	}
	
	
}
