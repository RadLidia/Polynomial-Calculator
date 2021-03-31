package Model;

import org.junit.jupiter.api.Test;

class MulTestt {

	@Test
	void test() {
		Operation test = new Operation();
		Polynomial P = new Polynomial();
		Polynomial Q = new Polynomial();
		//x^4+4x^3+6x^2+4x^1+1
		P.addMonom(new Monomial(1,0));
		P.addMonom(new Monomial(4,1));
		P.addMonom(new Monomial(6,2));
		P.addMonom(new Monomial(4,3));
		P.addMonom(new Monomial(1,4));

		//x+1
		Q.addMonom(new Monomial(1,0));
		Q.addMonom(new Monomial(1,1));
		
		//9x+5+7x^2+3x^3
		Polynomial result = new Polynomial();
		result.addMonom(new Monomial(5,0));
		result.addMonom(new Monomial(9,1));
		result.addMonom(new Monomial(7,2));
		result.addMonom(new Monomial(3,3));

		Polynomial output = test.mul(P, Q);
		result.equals(output);
		
	}

}
