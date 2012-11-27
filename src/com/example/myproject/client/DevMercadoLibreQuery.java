package com.example.myproject.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.ListBox;

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


	
	//html blocks to show the api results
	private HTML htmlNewHtml;
	private HTML htmlNewHtml2;
	private HTML htmlNewHtml3;
	private HTML htmlNewHtml4;
	private HTML htmlNewHtml5;
	private HTML htmlNewHtml6;
	private HTML htmlNewHtml7;


	private String producto1;
	private String producto2;
	private String producto3;
	private String producto4;
	private String producto5;
	private String producto6;
	private String producto7;
	
	
	
	
	
	private ListBox comboBox;
	private Button btnModificar;

	private RootPanel rootPanel;
	

	
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
		rootPanel = RootPanel.get("nameFieldContainer");
		rootPanel.add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		
		
		htmlNewHtml = new HTML();
		htmlNewHtml.setWordWrap(false);
		rootPanel.add(htmlNewHtml, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml);
		
		htmlNewHtml2 = new HTML();
		htmlNewHtml2.setWordWrap(false);
		rootPanel.add(htmlNewHtml2, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml2);
		
		htmlNewHtml3 = new HTML();
		htmlNewHtml3.setWordWrap(false);
		rootPanel.add(htmlNewHtml3, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml3);
		
		htmlNewHtml3 = new HTML();
		htmlNewHtml3.setWordWrap(false);
		rootPanel.add(htmlNewHtml3, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml3);
		
		htmlNewHtml4 = new HTML();
		htmlNewHtml4.setWordWrap(false);
		rootPanel.add(htmlNewHtml4, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml4);
		
		htmlNewHtml5 = new HTML();
		htmlNewHtml5.setWordWrap(false);
		rootPanel.add(htmlNewHtml5, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml5);
		
		htmlNewHtml6 = new HTML();
		htmlNewHtml6.setWordWrap(false);
		rootPanel.add(htmlNewHtml6, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml6);
		
		htmlNewHtml7 = new HTML();
		htmlNewHtml7.setWordWrap(false);
		rootPanel.add(htmlNewHtml7, 207, 135);
		RootPanel.get("queryHTML").add(htmlNewHtml7);
		
		
		
		
		
		btnModificar = new Button("modificar");
		rootPanel.add(btnModificar);
		
		
		
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
		
		
		class MyHandlerProducto1 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod1");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod1");

			}
			
			
		}
		
		class MyHandlerProducto2 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				viewItem();
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				viewItem();

			}
			
			
			
			
			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void viewItem() {
			
				 greetingService.viewItem(producto2,
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
							
	
								
																
								}
								
								

								
								
								
							
							
						});
			}
			
			
			
			
			
		}
		
		class MyHandlerProducto3 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 3");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 3");

			}
			
			
		}
		
		class MyHandlerProducto4 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 4");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 4");

			}
			
			
		}
		
		class MyHandlerProducto5 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 5");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 5");

			}
			
			
		}
		
		
		class MyHandlerProducto6 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 6");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 6");

			}
			
			
		}
		
		class MyHandlerProducto7 implements ClickHandler, KeyUpHandler{

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 7");
			}

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				System.out.println("prod 7");

			}
			
			
		}
		

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendQueryToApi();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendQueryToApi();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendQueryToApi() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				

				// Then, we send the input to the server.
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				 int a =comboBox.getSelectedIndex();
				String site=comboBox.getValue(a);
				 greetingService.queryItem(textToServer,site,
						new AsyncCallback<String []>() {
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

							public void onSuccess(String[] result) {
							
	
								htmlNewHtml.setHTML(result[0]);
								producto1= result[0].substring(4, 18);
								producto1=producto1.trim();
								
								producto2= result[1].substring(4, 18);
								producto2=producto2.trim();
								
								producto3= result[2].substring(4, 18);
								producto3=producto3.trim();
								
								producto4= result[3].substring(4, 18);
								producto4=producto4.trim();
								
								producto5= result[4].substring(4, 18);
								producto5=producto5.trim();
								
								producto6= result[5].substring(4, 18);
								producto6=producto6.trim();
								
								producto7= result[6].substring(4, 18);
								producto7=producto7.trim();

								
								
								htmlNewHtml2.setHTML(result[1]);
								htmlNewHtml3.setHTML(result[2]);
								htmlNewHtml4.setHTML(result[3]);
								htmlNewHtml5.setHTML(result[4]);
								htmlNewHtml6.setHTML(result[5]);
								htmlNewHtml7.setHTML(result[6]);

																
								}
								
								

								
								
								
							
							
						});
			}
		}

	
		
		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
		
		
		
		//Define handler to manage the click event on the product list
		MyHandlerProducto1 p1 = new MyHandlerProducto1();
		htmlNewHtml.addClickHandler(p1);
		
		MyHandlerProducto2 p2 = new MyHandlerProducto2();
		htmlNewHtml2.addClickHandler(p2);
		
		MyHandlerProducto3 p3 = new MyHandlerProducto3();
		htmlNewHtml3.addClickHandler(p3);
		
		MyHandlerProducto4 p4 = new MyHandlerProducto4();
		htmlNewHtml4.addClickHandler(p4);
		
		MyHandlerProducto5 p5 = new MyHandlerProducto5();
		htmlNewHtml5.addClickHandler(p5);
		
		MyHandlerProducto6 p6 = new MyHandlerProducto6();
		htmlNewHtml6.addClickHandler(p6);
		
		MyHandlerProducto7 p7 = new MyHandlerProducto7();
		htmlNewHtml7.addClickHandler(p7);
		
		
	}
	
	
	
	
	
	
	
	
}
