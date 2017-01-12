package domain;

public class Concert {
	String denumire;
	String data;
	Integer locuriDisponibile;
	
	public Concert(String denumire, String data, Integer locuriDisponibile){
		this.denumire = denumire;
		this.data = data;
		this.locuriDisponibile = locuriDisponibile;		
	}
	
	public String getDenumire(){
		return this.denumire;
	}
	
	public String getData(){
		return this.data;
	}
	
	public Integer getLocuriDisponibile(){
		return this.locuriDisponibile ;
	}
	
	public void setDenumire(String denumire){
		this.denumire = denumire;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	public void setLocuriDisponibile(Integer locuriDisponibile){
		this.locuriDisponibile = locuriDisponibile;
	}

	public String toString(){
		return "denumire: " + this.getDenumire() + ", data: " + this.getData() + ", locuri disponibile: " 
				+ this.getLocuriDisponibile().toString();
	}
}
