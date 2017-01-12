package model;

import java.util.List;

import domain.Concert;

public interface ConcerteModelInterface {
	List<Concert> getAllConcerte();
	Concert getConcertByDenumire(String denumire);
	void rezervareConcert(String denumire);
	void adaugaConcert(String denumire, String data, Integer locuriDisponibile);
}
