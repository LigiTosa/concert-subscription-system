package repository;

import java.util.List;

import domain.Abonat;

public interface AbonatiRepositoryInterface {
	List<Abonat> readFromFile();
	void writeToFile();
	List<Abonat> getAllAbonati();
	Abonat getAbonatByNume(String nume);
	void rezervareAbonat(String nume);
}
