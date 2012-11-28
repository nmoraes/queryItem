package com.example.myproject.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import com.example.myproject.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	/**
	 * Copy paste friendly !!, This function implements CURL for connect to the API
	 * Search
	 * @description make a query in API Search
	 * @param input: key world to find, for example 'ipod'
	 * @param site: site id to find, for example MLA
	 * @return html type with query results, to show in the DevMercadoLibreQuery.html 
	 * @author nicolas moraes @nmoraes_
	 */
	public String[] queryItem(String input, String site)
			throws IllegalArgumentException {

		String currency = null;
		String stop_time = null;
		String condition = null;
		String id = null;
		String site_id = null;
		String sold_quantity = null;
		String listing_type_id = null;

		String titles = null;
		String subtitle = null;
		String price = null;
		String thumbnail = null;
		String pic = null;
		String parametro = input.replaceAll(" ", "");
		String html = "";		
		
		String [] s = new String[7];
		
		String permalink="";

		
		URL url;
		try {
			url = new URL("https://api.mercadolibre.com/sites/" + site
					+ "/search?q=" + parametro);
			InputStream response = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response));
			String result = "";

			for (String line; (line = reader.readLine()) != null;) {
				result = result + line;
			}
			reader.close();

			System.out.println("result: " + result);

			JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

			// get items array
			JSONObject p = (JSONObject) json.get("paging");
			String total = p.getString("total");
			System.out.println("Total: " + total);

			JSONArray results = json.getJSONArray("results");

			
			// for json array 
			for (int i = 0; i < 7; i++) {
				JSONObject array = (JSONObject) results.get(i);
				titles = array.getString("title");
				subtitle = array.getString("subtitle");
				price = array.getString("price");
				thumbnail = array.getString("thumbnail");
				// changing size image
				pic = changeImageSize(thumbnail);
				currency = array.getString("currency_id");
				stop_time = array.getString("stop_time");
				condition = array.getString("condition");
				id = array.getString("id");
				site_id = array.getString("site_id");
				sold_quantity = array.getString("sold_quantity");
				listing_type_id = array.getString("listing_type_id");
				permalink =array.getString("permalink");
				System.out.println("permalink " + permalink);
					
				html = "<!--"+id + "                                         -->"+
						" <div> <p> <input type= \"image\" src= " + pic + " "+ " +  align=\"left\" onclick=\"location.href='" + permalink+ "' \"/> </p>"
						+ "<p><b>Title :</b> " + titles
						+ "<br><b>Description: </b>" + subtitle
						+ "<br><b>Price: </b>" + price + " " + currency
						+ "<br><b>State: </b>" + condition
						+ "<br><b>Up to: </b>" + stop_time
						+ "<br><b>Item Id: </b>" + id + "<br><b>Site Id: </b>"
						+ site_id + "<br><b>Count: </b>" + sold_quantity
						+ "<br><b>Listing type: </b>" + listing_type_id	+ "<br><b>: </b>"
						+ "<br><br></p> </div><br>";
				
				s[i]=html;
			
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;
	}

	
	
	public String changeImageSize(String thumbnail){
		String image = null;	
		//small I
		//medium T
		image= thumbnail.replace("_v_I_f", "_v_T_f");		
	return image;	
		
	}
	
	
	
	@Override
	public String viewItem(String query) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
