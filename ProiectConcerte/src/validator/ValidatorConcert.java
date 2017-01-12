package validator;

import domain.Concert;

public class ValidatorConcert implements ValidatorInterface{
	private String erori = "";
	private Concert c;
	
	public ValidatorConcert(Concert c){
		this.c = c;
	}
	
	public void valideaza() throws MyException{
		if(c.getDenumire().equals("")) erori += "Denumirea concertului nu poate fi vida!";
		if(c.getData().equals("")) erori += "Data concertului nu poate fi vida!";
		if(c.getLocuriDisponibile() < 0) erori += "Numarul de locuri disponibile nu poate fi negativ!";
		if (!(erori.equals(""))) {
			String erori1 = erori;
			erori = "";
			throw new MyException(erori1);	
		}
		
	}
}
