package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.UserInterface;
import Model.Operation;
import Model.Polynomial;

public class Controller {
	
	private UserInterface theView;
	private Operation theModel;
	//constructor
	public Controller(UserInterface theView, Operation theModel) {
		this.theView = theView;
		this.theModel = theModel;
		//tell the view, when button is clicked, to execute the action
		//performed method of calculate listener class 
		this.theView.addCalculationListener(new CalculateSumListener());
		this.theView.subCalculationListener(new CalculateSubListener());
		this.theView.mulCalculationListener(new CalculateMulListener());
		this.theView.divCalculationListener(new CalculateDivListener());
		this.theView.derivateCalculationListener(new CalculateDerivateListener());
		this.theView.integrateCalculationListener(new CalculateIntegrateListener());
	}
	 class CalculateSumListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			//all interactions are performed here
			Polynomial firstPolynomial, secondPolynomial = new Polynomial();
			try {
				firstPolynomial = theView.getFirstPolynomial();
				secondPolynomial = theView.getSecondPolynomial();
				
				theModel.add(firstPolynomial, secondPolynomial);
				
				theView.setCalcSolution(theModel.getAddResult());
			}
			
			catch(NumberFormatException ex) {
				
				theView.displayErrorMessage("You need to enter 2 integers");
			
			}
			
		}
		 
	 }
	 class CalculateSubListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//all interactions are performed here
				Polynomial firstPolynomial, secondPolynomial = new Polynomial();
				try {
					firstPolynomial = theView.getFirstPolynomial();
					secondPolynomial = theView.getSecondPolynomial();
					
					theModel.sub(firstPolynomial, secondPolynomial);
					
					theView.setCalcSolution(theModel.getSubResult());
				}
				
				catch(NumberFormatException ex) {
					
					theView.displayErrorMessage("You need to enter 2 integers");
				
				}
				
			}
			 
		 }
	 
	 class CalculateMulListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//all interactions are performed here
				Polynomial firstPolynomial, secondPolynomial = new Polynomial();
				try {
					firstPolynomial = theView.getFirstPolynomial();
					secondPolynomial = theView.getSecondPolynomial();
					
					theModel.mul(firstPolynomial, secondPolynomial);
					
					theView.setCalcSolution(theModel.getMulResult());
				}
				
				catch(NumberFormatException ex) {
					
					theView.displayErrorMessage("You need to enter 2 integers");
				
				}
				
			}
			 
		 }
	 class CalculateDivListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//all interactions are performed here
				Polynomial firstPolynomial, secondPolynomial = new Polynomial();
				try {
					firstPolynomial = theView.getFirstPolynomial();
					secondPolynomial = theView.getSecondPolynomial();
					
					theModel.div(firstPolynomial, secondPolynomial);
					
					theView.setCalcSolution(theModel.getDivResult());
					//theView.setCalcSolution(theModel.getDivResult().get(1));
					
				}
				
				catch(NumberFormatException ex) {
					
					theView.displayErrorMessage("You need to enter 2 integers");
				
				}
				
			}
			 
		 }
	 class CalculateDerivateListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//all interactions are performed here
				Polynomial firstPolynomial, secondPolynomial = new Polynomial();
				try {
					firstPolynomial = theView.getFirstPolynomial();
					
					theModel.derivate(firstPolynomial);
					
					theView.setCalcSolution(theModel.getDerivateResult());
					//theView.setCalcSolution(theModel.getDivResult().get(1));
					
				}
				
				catch(NumberFormatException ex) {
					
					theView.displayErrorMessage("You need to enter 2 integers");
				
				}
				
			}
			 
		 }
	 class CalculateIntegrateListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//all interactions are performed here
				Polynomial firstPolynomial = new Polynomial();
				try {
					firstPolynomial = theView.getFirstPolynomial();
					
					theModel.integration(firstPolynomial);
					
					theView.setCalcSolution(theModel.getIntegrationResult());
					
				}
				
				catch(NumberFormatException ex) {
					
					theView.displayErrorMessage("You need to enter 2 integers");
				
				}
				
			}
			 
		 }
	 
}