package View;

import java.awt.event.ActionListener;

import javax.swing.*;
//swing components - it helps making the interface

import Model.Polynomial;

public class UserInterface extends JFrame{

	private JTextField firstPolynomial = new JTextField(20);
	private JTextField secondPolynomial = new JTextField(20);
	private JButton sumButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton(":");
	private JButton derivateButton = new JButton("Derivate");
	private JButton integrationButton = new JButton("Integrate");
	private JTextField calcSolution = new JTextField(25);

	public UserInterface(){
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//make sure the app is close if the x button is clicked
		this.setSize(500, 200);
		//width, height in pixels
		
		//add the components to the panel
		calcPanel.add(firstPolynomial);
		calcPanel.add(secondPolynomial);
		calcPanel.add(sumButton);
		calcPanel.add(subButton);
		calcPanel.add(mulButton);
		calcPanel.add(divButton);
		calcPanel.add(derivateButton);
		calcPanel.add(integrationButton);
		calcPanel.add(calcSolution);
		
		this.add(calcPanel);

	}
	Polynomial polynomial = new Polynomial();
	//get access to the first polynomial; 
	public Polynomial getFirstPolynomial() {
		
		return polynomial.StringToPolynomial(firstPolynomial.getText());
	}
	
	public Polynomial getSecondPolynomial() {
		
		return polynomial.StringToPolynomial(secondPolynomial.getText());
	}

	public Polynomial getCalcSolution() {
	
		return polynomial.StringToPolynomial(calcSolution.getText());
	}
	
	//set the value of calcSolution, the controller will have to 
	//set the result(int) from the model to the view panel(string)
	public void setCalcSolution(Polynomial polynomial) {
		
		calcSolution.setText(polynomial.PolynomialToString());
		
	}
	//the controller is allerted when a button is clicked on the panel
	public void addCalculationListener(ActionListener listenerSumButton) {
		
		sumButton.addActionListener(listenerSumButton);
	
	}
	
	public void subCalculationListener(ActionListener listenerSubButton) {
		
		subButton.addActionListener(listenerSubButton);
	
	}
	
	public void mulCalculationListener(ActionListener listenerMulButton) {
		
		mulButton.addActionListener(listenerMulButton);
	
	}
	
	public void divCalculationListener(ActionListener listenerDivButton) {
		
		divButton.addActionListener(listenerDivButton);
	
	}
	
	public void derivateCalculationListener(ActionListener listenerDerivateButton) {
		
		derivateButton.addActionListener(listenerDerivateButton);
	
	}
	
	public void integrateCalculationListener(ActionListener listenerIntegrateButton) {
		
		integrationButton.addActionListener(listenerIntegrateButton);
	
	}
	
	public void displayErrorMessage(String errorMessage) {
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
}