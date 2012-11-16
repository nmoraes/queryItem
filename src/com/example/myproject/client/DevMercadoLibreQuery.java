package com.example.myproject.client;

import java.util.Vector;

import javax.persistence.QueryHint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DevMercadoLibreQuery implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	
	private HTML htmlNewHtml;
	private ListBox comboBox;
	private Button btnModificar;
	private Button buttonss =new Button();
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("query");
		final TextBox nameField = new TextBox();
		nameField.setText("ipod");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("nameFieldContainer");
		rootPanel.add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		
		htmlNewHtml = new HTML();
		htmlNewHtml.setWordWrap(false);
		rootPanel.add(htmlNewHtml, 207, 135);
		
		btnModificar = new Button("modificar");
		rootPanel.add(btnModificar);
		
		RootPanel.get("queryHTML").add(htmlNewHtml);
		
		comboBox = new ListBox();
		rootPanel.add(comboBox, 10, 85);
		comboBox.setSize("100px", "30px");
		comboBox.addItem("MLA");
		comboBox.addItem("MLB");
		comboBox.addItem("MCO");
		comboBox.addItem("MCR");
		comboBox.addItem("MEC");
		comboBox.addItem("MLC");
		comboBox.addItem("MLM");
		comboBox.addItem("MLU");
		comboBox.addItem("MLV");
		comboBox.addItem("MPA");
		comboBox.addItem("MPT");
		comboBox.addItem("MRD");

		RootPanel.get("comboBox").add(comboBox);
		

		
		
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("API say's ....");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending query to API:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>API replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//dialogBox.hide();
				//sendButton.setEnabled(true);
				//sendButton.setFocus(true);
			}
		});
		
		
		class MyHandlerTEST implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("hola");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("hola2");

			}
			
			
		}
		
		
		

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			@SuppressWarnings("rawtypes")
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				

				// Then, we send the input to the server.
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				 int a =comboBox.getSelectedIndex();
				String site=comboBox.getValue(a);
				 greetingService.queryItem(textToServer,site,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("API say's ...... Error");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								
								
							
																
								
								
								
								
								htmlNewHtml.setHTML(result);
								
								
								
								
								System.out.println("hola");
								
								//buttonss = Button.wrap(DOM.getElementById("btnModificar"));
								
								//Document.get().getElementById("btnModificar").<InputElement>cast();
								//buttonss = Button.wrap(Document.get().getElementById("btnModificar"));
								//System.out.println(buttonss.getHTML());
																
								}
								
								

								
								
								
							
							
						});
			}
		}

	
		
		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}
}
