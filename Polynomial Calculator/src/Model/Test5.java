package Model;

import org.junit.jupiter.api.Test;

class IntegrateTest {

	@Test
	void test() {
		Operation test = new Operation();
		Polynomial P = new Polynomial();
		
		//5x^0+4x^1+3x^2
		P.addMonom(new Monomial(5,0));
		P.addMonom(new Monomial(4,1));
		P.addMonom(new Monomial(3,2));

		//5x+2x^2+x^3
		Polynomial result = new Polynomial();
		result.addMonom(new Monomial(0,0));
		result.addMonom(new Monomial(5,1));
		result.addMonom(new Monomial(2,2));
		result.addMonom(new Monomial(1,3));


		Polynomial output = test.derivate(P);
		result.equals(output);
		
	}

}
