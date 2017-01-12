package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import validator.MyException;
import domain.Abonat;

public class AbonatiRepository implements AbonatiRepositoryInterface{
	protected List<Abonat> listaAbonati;
	
	public AbonatiRepository(){
		this.listaAbonati = this.readFromFile(); 
	}
	
	@Override
	public List<Abonat> readFromFile(){
		List<Abonat> abonati = new ArrayList<Abonat>();
		try{
		FileReader fr = new FileReader("src/abonati.txt");
		BufferedReader br = new BufferedReader(fr);
		String linie;
		while ((linie =br.readLine()) != null){
			String[] bucati = linie.split(",");
			Abonat a = new Abonat(bucati[0], bucati[1], Integer.parseInt(bucati[2]));
			abonati.add(a);
		}
		fr.close();
		}catch (IOException ex){
			System.out.println(ex.toString());
			return null;
		}
		return abonati;		
	}
	
	@Override
	public void writeToFile(){
		try{
			FileWriter fw =  new FileWriter("src/abonati.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fileOut = new PrintWriter(bw);
			for(Abonat a:this.listaAbonati){
				fileOut.println(a.getNume() + "," + a.getCnp() + "," + a.getNrConcerteAlese().toString());
		}
			fileOut.close();
		}catch (IOException ex){
			System.out.println(ex.toString());
		}
	}
	
	@Override
	public List<Abonat> getAllAbonati(){
		return this.listaAbonati;
	}
	
	@Override
	public Abonat getAbonatByNume(String nume){
		for(Abonat a:this.listaAbonati){
			if(a.getNume().equals(nume))
				return a;
		}
		return null;
	}
	
	@Override
	public void rezervareAbonat(String nume){
		for(Abonat a:this.listaAbonati){
			if(a.getNume() .equals(nume))
				if (a.getNrConcerteAlese().equals(10))
					throw new MyException("Ati facut deja rezervare la 10 concerte!");
				else
					a.setNrConcerteAlese(a.getNrConcerteAlese() + 1);
		}
		this.writeToFile();
	}

	
}
