package Model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
	
	private ArrayList<Monomial> polynom = new ArrayList<Monomial>();
	private int nrMonom = 0;
	
	public ArrayList<Monomial> getPolynom(){
		
		return this.polynom;
		
	}
	
	public int getNrMonom() {
		
		return this.nrMonom;
		
	}
	
	public void addMonom(Monomial monom) {
		
		polynom.add(monom);
		nrMonom++;
		
	}
	
	public void deleteMonom(int i) {
		
		polynom.remove(i);
		nrMonom--;
		
	}
	
	public Monomial getMonom(int i) {
		
		return polynom.get(i);
		
	}
	
	public boolean isEmpty() {
		if(polynom.isEmpty()) 
			return true;
		else 
			return false;
		
	}

	public String PolynomialToString() {
		
		String stringPolynom = new String("");
		
		for(Monomial m : polynom) {
			
			if(m.getExp() == 0) {
				if(m.getCoef() >= 0)
					stringPolynom = stringPolynom + ("+" + m.getCoef());
				else
					stringPolynom = stringPolynom + ( m.getCoef());
			}else {
				if(m.getExp() == 1) { 
					if(m.getCoef() >= 0) {
						if(m.getCoef() == 0)
							stringPolynom = stringPolynom + ("+0");
						else {
							if(m.getCoef() == 1)
								stringPolynom = stringPolynom + ("+x");
							else
								stringPolynom = stringPolynom + ("+" + m.getCoef() + "x");
						}
					}else {
							if(m.getCoef() == -1)
								stringPolynom = stringPolynom + ("-x");
							else
								stringPolynom = stringPolynom + (m.getCoef() + "x");
					}
				}else {
					if(m.getCoef() >= 0)
						if(m.getCoef() == 0)
							stringPolynom = stringPolynom + ("+0");
						else {
							if(m.getCoef() == 1)
								stringPolynom = stringPolynom + ("+x^" + m.getExp());
							else
								stringPolynom = stringPolynom + ("+" + m.getCoef() + "x^" + m.getExp());}
					else
						stringPolynom = stringPolynom + ( m.getCoef() + "x^" + m.getExp());
				}
			}
		}
		return stringPolynom;
	}
	//accepta doar forma 5x^0+4x^1+3x^2
    public Polynomial StringToPolynomial(String text) {

        Polynomial polynom = new Polynomial();
        int k = 0;
        //5x^0   +4x^1   +3x^2
        Pattern patternMonom = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))");//separate the monoms
	    Matcher matcherMonom = patternMonom.matcher(text);

	    while(matcherMonom.find()) {

	    	String s = matcherMonom.group(1);
	    	
	        Pattern patternDigit = Pattern.compile("[+-]?\\d+");//separates digits
	        Matcher matcherDigit = patternDigit.matcher(s);
	        
	        Monomial m = new Monomial(0, 0);
	        
	        while(matcherDigit.find()){

	        	if(k % 2 == 0){
	        		m.setCoef(Integer.parseInt(matcherDigit.group()));
	                }
	            else{
	                m.setExp(Integer.parseInt(matcherDigit.group()));
	                polynom.addMonom(m);
	            }
	        	k++;
	        }
	    }
	    
	    return polynom;
    }
}

