package model;

import java.util.List;
import java.util.Observable;

import repository.AbonatiRepository;
import validator.MyException;
import domain.Abonat;

public class AbonatiModel extends Observable implements AbonatiModelInterface{
private AbonatiRepository repo;
	
	public AbonatiModel(AbonatiRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public List<Abonat> getAllAbonati() {
		return repo.getAllAbonati();
	}

	@Override
	public Abonat getAbonatByNume(String nume) {
		return repo.getAbonatByNume(nume);
	}

	@Override
	public void rezervareAbonat(String nume) {
		try{
			repo.rezervareAbonat(nume);
		}catch(MyException ex){
			throw new MyException(ex.getMessage());
		}
		 setChanged();
	     notifyObservers(this);
	}

}
