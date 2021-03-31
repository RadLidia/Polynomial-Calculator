package Controller;

import Model.Operation;
import View.UserInterface;

public class Main {
	
	public static void main(String[] arg) {
		//the objects
		UserInterface theView = new UserInterface();
		Operation theModel = new Operation();
		Controller theController = new Controller(theView, theModel);
		
		theView.setVisible(true);

	}
	
}