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

	public String queryItem(String input) throws IllegalArgumentException {

		String site = null;
		String query = null;
		String currency = null;
		String stop_time = null;
		String condition = null;

		String titles = null;
		String subtitle = null;
		String price = null;
		String thumbnail = null;
		String pic = null;
		String parametro = input.replaceAll(" ", "");
		String html = "";
		System.out.println(parametro);

		URL url;
		try {
			url = new URL("https://api.mercadolibre.com/sites/MLB/search?q="
					+ parametro);
			InputStream response = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					response));
			String result = "";

			for (String line; (line = reader.readLine()) != null;) {
				System.out.println(line);
				result = result + line;
			}

			System.out.println("result: " + result);

			JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

			// String id = json.getString( "id" );
			site = json.getString("site_id");
			query = json.getString("query");

			// Obtengo el array de items
			JSONObject p = (JSONObject) json.get("paging");
			String total = p.getString("total");
			System.out.println("Total: " + total);

			JSONArray results = json.getJSONArray("results");

			// results.size();
			// Obtengo los 10 primeros
			for (int i = 0; i < 5; i++) {
				JSONObject array = (JSONObject) results.get(i);
				titles = array.getString("title");
				subtitle = array.getString("subtitle");
				price = array.getString("price");
				thumbnail = array.getString("thumbnail");
				pic = thumbnail.replace("_v_I_f", "_v_T_f");
				currency = array.getString("currency_id");
				stop_time = array.getString("stop_time");
				condition = array.getString("condition");

				html = html + "<div><br><b>Title :</b> " + titles
						+ "<br><b>Description: </b>" + subtitle
						+ "<br><b>Price: </b>" + price + " " + currency
						+ "<br><b>State: </b>" + condition
						+ "<br><b>Up to: </b>" + stop_time
						+ "<br><img src=" + pic + "><br></div>";

			}

			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return html;

	}

}
