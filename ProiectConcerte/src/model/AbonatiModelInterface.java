package model;

import java.util.List;

import domain.Abonat;

public interface AbonatiModelInterface {
	List<Abonat> getAllAbonati();
	Abonat getAbonatByNume(String nume);
	void rezervareAbonat(String nume);
}
