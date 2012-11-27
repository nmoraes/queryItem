package com.example.myproject.client;


import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void queryItem(String query, String site, AsyncCallback<String[]> callback);
	void viewItem(String query, AsyncCallback<String> callback);
}
