package Model;

import java.util.Objects;

public class Monomial {
	
	private int coef;
	private int exp;
	
	//constructor
	public Monomial(int newCoef, int newExp){
		this.setCoef(newCoef);
		this.setExp(newExp);
	}
	//set and get
	public int getCoef() {
		return this.coef;
	}

	public void setCoef(int newCoef) {
		this.coef = newCoef;
	}

	public int getExp() {
		return this.exp;
	}

	public void setExp(int newExp) {
		this.exp = newExp;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || getClass() != o.getClass()) 
        	return false;
        Monomial that = (Monomial) o;
        return Objects.equals(coef, that.coef) &&
                Objects.equals(exp, that.exp);
    }
}
