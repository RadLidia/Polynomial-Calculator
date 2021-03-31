package Model;

public class Operation {
	
	private Polynomial addResult = new Polynomial();
	private Polynomial subResult = new Polynomial();
	private Polynomial mulResult = new Polynomial();
	private Polynomial divResult = new Polynomial();
	private Polynomial derivateResult = new Polynomial();
	private Polynomial integrationResult = new Polynomial();
	Polynomial polynomial = new Polynomial();
	
	//private ArrayList<Polynomial> divResult = new ArrayList<Polynomial>();
	
	public Polynomial add(Polynomial P, Polynomial Q) {
		
		int i = 0;
		int j = 0;
		Monomial m;
		
		while(i < P.getNrMonom() && j < Q.getNrMonom()) {
		
			if(P.getMonom(i).getExp() == Q.getMonom(j).getExp()) {
				m = new Monomial(P.getMonom(i).getCoef() + Q.getMonom(j).getCoef(), P.getMonom(i).getExp());
				addResult.addMonom(m);
				i++;j++;
			}else{
				if(P.getMonom(i).getExp() < Q.getMonom(j).getExp()) {
					m = new Monomial(P.getMonom(i).getCoef(), P.getMonom(i).getExp());
					addResult.addMonom(m);
					i++;
				}else {
				m = new Monomial(Q.getMonom(j).getCoef(), Q.getMonom(j).getExp());
				addResult.addMonom(m);
				j++;
				}
			}
		}
		while(i < P.getNrMonom()){
			m = new Monomial(P.getMonom(i).getCoef(), P.getMonom(i).getExp());
			addResult.addMonom(m);
			i++;
	        }
		while(j < Q.getNrMonom()){
			m = new Monomial(Q.getMonom(j).getCoef(), Q.getMonom(j).getExp());
			addResult.addMonom(m);
			j++;
	    }

		return addResult;	
	}
	
	public Polynomial sub(Polynomial P, Polynomial Q) {

		int i = 0;
		int j = 0;
		Monomial m;
		
		while(i < P.getNrMonom() && j < Q.getNrMonom()) {
		
			if(P.getMonom(i).getExp() == Q.getMonom(j).getExp()) {
				m = new Monomial(P.getMonom(i).getCoef() - Q.getMonom(j).getCoef(), P.getMonom(i).getExp());
				subResult.addMonom(m);
				i++;j++;
			}else{
				if(P.getMonom(i).getExp() < Q.getMonom(j).getExp()) {
					m = new Monomial(P.getMonom(i).getCoef(), P.getMonom(i).getExp());
					subResult.addMonom(m);
					i++;
				}else {
				m = new Monomial(Q.getMonom(j).getCoef(), Q.getMonom(j).getExp());
				subResult.addMonom(m);
				j++;
				}
			}
		}
		while(i < P.getNrMonom()){
			m = new Monomial(P.getMonom(i).getCoef(), P.getMonom(i).getExp());
			subResult.addMonom(m);
			i++;
	        }
		while(j < Q.getNrMonom()){
			m = new Monomial(Q.getMonom(j).getCoef(), Q.getMonom(j).getExp());
			subResult.addMonom(m);
			j++;
	    }

		return subResult;	
	}
	
	public Polynomial mul(Polynomial P, Polynomial Q) {

		int i = 0;
		int j = 0;
		Polynomial mulResult1 = new Polynomial();
		
		for(Monomial m : P.getPolynom()) {
			j = 0;
			for(Monomial n : Q.getPolynom()) {
				m = new Monomial(P.getMonom(i).getCoef() * Q.getMonom(j).getCoef(), P.getMonom(i).getExp() + Q.getMonom(j).getExp());
				mulResult1.addMonom(m);
				j++;
			}
			i++;
		}
		//reduce the elements with the same exponent
		i = 0;int ok = 0;
		Monomial n;
		while(i < mulResult1.getNrMonom() - 1) {
			j = i + 1; ok = 0;
			while(j < mulResult1.getNrMonom()) {
				if(mulResult1.getMonom(i).getExp() == mulResult1.getMonom(j).getExp()) {
					n = new Monomial(mulResult1.getMonom(i).getCoef() + mulResult1.getMonom(j).getCoef(), mulResult1.getMonom(i).getExp());
					mulResult.addMonom(n);
					mulResult1.deleteMonom(j);
					ok = 1;
				}
			j++;
			}
			if(ok == 0) {
				n = new Monomial(mulResult1.getMonom(i).getCoef(), mulResult1.getMonom(i).getExp());
				mulResult.addMonom(n);
			}
			i++;
		}
		n = new Monomial(mulResult1.getMonom(i).getCoef(), mulResult1.getMonom(i).getExp());
		mulResult.addMonom(n);
		
		return mulResult;	
	}
	
	//public ArrayList<Polynomial> div(Polynomial P1, Polynomial P2) {
	public Polynomial div(Polynomial P1, Polynomial P2) {
		
		Polynomial Q = new Polynomial(); //Quotient
		Polynomial R = new Polynomial(); //Remainder
		R = P1;

		int co, ex, i = 0;
		if(R.getMonom(0).getExp() < P2.getMonom(0).getExp()) {
			Q.addMonom(new Monomial(0,0));
		}else {
			while(R.getMonom(0).getExp() >= P2.getMonom(0).getExp()) {
				if(R.getMonom(0).getCoef() == 0)
					R.deleteMonom(0);
				co = R.getMonom(0).getCoef()/P2.getMonom(0).getCoef();
				ex = R.getMonom(0).getExp() - P2.getMonom(0).getExp();
				Monomial m = new Monomial(co,ex);
				Polynomial op = new Polynomial();
				op.addMonom(m);
				Q.addMonom(m);
				Polynomial op1 = new Polynomial();
				op1 = mul(op,P2);
				if(i == 0) {
					R = sub(R, mul(op,P2));
					i++;
				}else
					break;
			}
		}
		if(R.isEmpty()) 
			R.addMonom(new Monomial(0,0));
		//divResult.add(Q);
		//divResult.add(R);
		//return divResult;
		return Q;
	}
	
public Polynomial derivate(Polynomial P) {
		
	int i = 0;
	while(i < P.getNrMonom()) {
		int co = P.getMonom(i).getCoef();
		int ex = P.getMonom(i).getExp();
		i++;
			
		if(ex != 0){
			Monomial m = new Monomial(co * ex, ex-1);
			derivateResult.addMonom(m);
		}
	}
	return derivateResult;
}

	public Polynomial integration(Polynomial P) {
	
		int i = 0;
	
		while(i < P.getNrMonom()) {
			int co = P.getMonom(i).getCoef();
			int ex = P.getMonom(i).getExp();
			i++;
			
			Monomial m = new Monomial(co/(ex + 1), ex + 1);
			integrationResult.addMonom(m);
			}	
		return integrationResult;	
}


	public Polynomial getAddResult() {
		
		return addResult;
	}
	public Polynomial getSubResult() {
		
		return subResult;
	}
	public Polynomial getMulResult() {
		
		return mulResult;
	}
	public Polynomial getDivResult() {
		
		return divResult;
	}
	public Polynomial getDerivateResult() {
		
		return derivateResult;
	}
	public Polynomial getIntegrationResult() {
		
		return integrationResult;
	}

//	public ArrayList<Polynomial> getDivResult() {
//	
//	return divResult;
//	}
}
