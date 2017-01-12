package repository;

import java.util.List;

import domain.Concert;

public interface ConcerteRepositoryInterface {
	List<Concert> readFromFile();
	void writeToFile();
	List<Concert> getAllConcerte();
	Concert getConcertByDenumire(String denumire);
	void rezervareConcert(String denumire);
	void adaugaConcert(Concert c);
}
