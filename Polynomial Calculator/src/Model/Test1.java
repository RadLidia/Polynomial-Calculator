package Model;

import org.junit.jupiter.api.Test;

class SumTest {

	@Test
	void test() {
		Operation test = new Operation();
		Polynomial P = new Polynomial();
		Polynomial Q = new Polynomial();
		//1x^0+2x^1+1x^2
		P.addMonom(new Monomial(1,0));
		P.addMonom(new Monomial(2,1));
		P.addMonom(new Monomial(1,2));
		
		Q.addMonom(new Monomial(1,0));
		Q.addMonom(new Monomial(2,1));
		Q.addMonom(new Monomial(1,2));
		
		Polynomial result = new Polynomial();
		result.addMonom(new Monomial(2,0));
		result.addMonom(new Monomial(4,1));
		result.addMonom(new Monomial(2,2));
		

		Polynomial output = test.add(P, Q);
		result.equals(output);
		
//		Polynomial result = new Polynomial();
//		result.addMonom(new Monomial(0,0));
//		result.addMonom(new Monomial(0,1));
//		result.addMonom(new Monomial(0,2));
//		Polynomial output = test.sub(P, Q);
		
		//result.PolynomialToString();
		
		///Polynomial polynomial = new Polynomial();
		///polynomial.PolynomialToString()
		
	}

}
