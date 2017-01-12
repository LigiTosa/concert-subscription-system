package domain;

public class Abonat {
	String nume;
	String cnp;
	Integer nrConcerteAlese;
	
	public Abonat(String nume, String cnp, Integer nrConcerteAlese){
		this.nume = nume;
		this.cnp = cnp;
		this.nrConcerteAlese = nrConcerteAlese ;
	}
	
	public String getNume(){
		return this.nume;
	}
	
	public String getCnp(){
		return this.cnp;
	}
	
	public Integer getNrConcerteAlese(){
		return this.nrConcerteAlese;
	}
	
	public void setNume(String nume){
		this.nume = nume;
	}
	
	public void setCnp(String cnp){
		this.cnp = cnp;
	}
	
	public void setNrConcerteAlese(Integer nrConcerteAlese){
		this.nrConcerteAlese = nrConcerteAlese;
	}
	
	public String toString(){
		return "cnp: " + this.getCnp() +  ", nume: " + this.getNume() + ", numarul de concerte alese: " 
				+ this.getNrConcerteAlese().toString();
	}
	
}
