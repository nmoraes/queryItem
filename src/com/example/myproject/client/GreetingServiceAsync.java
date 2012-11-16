package com.example.myproject.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void queryItem(String query, String site, AsyncCallback<String> callback);
}
