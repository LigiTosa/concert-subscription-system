package validator;

import domain.Abonat;

public class ValidatorAbonat implements ValidatorInterface{
	private String erori = "";
	private Abonat a;
	
	public ValidatorAbonat(Abonat a){
		this.a = a;
	}
	
	public void valideaza(){
		if(a.getNume().equals("")) erori += "Numele abonatului nu poate fi vid!";
		if(a.getCnp().equals("")) erori += "Cnp-ul abonatului nu poate fi vid!";
		if(a.getNrConcerteAlese() < 0) erori += "Numarul de concerte alese nu poate fi negativ!";
		if (!(erori.equals(""))) {
			String erori1 = erori;
			erori = "";
			throw new MyException(erori1);
		}
	}
}
