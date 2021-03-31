package Model;

import org.junit.jupiter.api.Test;

class DerivateTest {

	@Test
	void test() {
		Operation test = new Operation();
		Polynomial P = new Polynomial();
		
		//5x^0+4x^1+3x^2
		P.addMonom(new Monomial(5,0));
		P.addMonom(new Monomial(4,1));
		P.addMonom(new Monomial(3,2));

		//4+6x
		Polynomial result = new Polynomial();
		result.addMonom(new Monomial(4,0));
		result.addMonom(new Monomial(6,1));

		Polynomial output = test.derivate(P);
		result.equals(output);
		
	}

}
