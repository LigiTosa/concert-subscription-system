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
import domain.Concert;

public class ConcerteRepository implements ConcerteRepositoryInterface{
	protected List<Concert> listaConcerte;
	
	public ConcerteRepository(){
		this.listaConcerte = this.readFromFile();
	}
	
	@Override
	public List<Concert> readFromFile() {
		List<Concert> concerte = new ArrayList<Concert>();
		try{
		FileReader fr = new FileReader("src/concerte.txt");
		BufferedReader br = new BufferedReader(fr);
		String linie;
		while ((linie =br.readLine()) != null){
			String[] bucati = linie.split(",");
			Concert c = new Concert(bucati[0], bucati[1], Integer.parseInt(bucati[2]));
			concerte.add(c);
		}
		fr.close();
		}catch (IOException ex){
			System.out.println(ex.toString());
			return null;
		}
		return concerte;		
	}

	@Override
	public void writeToFile(){
		try{
			FileWriter fw = new FileWriter("src/concerte.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter fileOut = new PrintWriter(bw);
			for(Concert c:this.listaConcerte){
				fileOut.println(c.getDenumire() + "," + c.getData() + "," + c.getLocuriDisponibile().toString());
			}
			fileOut.close();
		}catch (IOException ex){
			System.out.println(ex.toString());
		}
	}

	@Override
	public List<Concert> getAllConcerte() {
		return this.listaConcerte;
	}

	@Override
	public Concert getConcertByDenumire(String denumire) {
		for(Concert c:this.listaConcerte){
			if(c.getDenumire().equals(denumire))
				return c;
		}
		return null;
	}

	@Override
	public void rezervareConcert(String denumire) {
		for(Concert c:this.listaConcerte){
			if(c.getDenumire().equals(denumire))
				if(c.getLocuriDisponibile() == 0)
					throw new MyException("Nu mai sunt locuri disponibile la acest concert!");
				else
					c.setLocuriDisponibile(c.getLocuriDisponibile() - 1);
		}
		this.writeToFile();
	}

	@Override
	public void adaugaConcert(Concert c) {
		listaConcerte.add(c);
		this.writeToFile();
	}

}
