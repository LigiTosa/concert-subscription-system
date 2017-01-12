package model;

import java.util.List;
import java.util.Observable;

import repository.ConcerteRepository;
import validator.MyException;
import validator.ValidatorConcert;
import domain.Concert;

public class ConcerteModel extends Observable implements ConcerteModelInterface{
	private ConcerteRepository repo;
	private ValidatorConcert vali;
	
	public ConcerteModel(ConcerteRepository repo){
		this.repo = repo;
	}
	
	@Override
	public List<Concert> getAllConcerte() {
		return repo.getAllConcerte();
	}

	@Override
	public Concert getConcertByDenumire(String denumire) {
		return repo.getConcertByDenumire(denumire);
	}

	@Override
	public void rezervareConcert(String denumire) {
		try{
			repo.rezervareConcert(denumire);
		}catch(MyException ex){
			throw new MyException(ex.getMessage());
		}
		setChanged();
	    notifyObservers(this);
		
	}

	@Override
	public void adaugaConcert(String denumire, String data,Integer locuriDisponibile) {
		try{
			Concert c = new Concert(denumire, data, locuriDisponibile);
			vali = new ValidatorConcert(c);
			vali.valideaza();
			repo.adaugaConcert(c);
		}
		catch (MyException ex){
			throw new MyException(ex.getMessage());
		}
		setChanged();
	    notifyObservers(this);
	}
}
