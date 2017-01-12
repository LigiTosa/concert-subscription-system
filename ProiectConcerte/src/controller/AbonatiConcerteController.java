package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import domain.Abonat;
import domain.Concert;
import validator.MyException;
import view.AbonatWindow;
import view.LoginWindow;
import model.AbonatiModel;
import model.ConcerteModel;

public class AbonatiConcerteController implements Observer{
	private AbonatiModel modelA;
	private ConcerteModel modelC;
	private AbonatWindow view;
	private LoginWindow viewL;
	
	public AbonatiConcerteController(AbonatiModel am, ConcerteModel cm, AbonatWindow v, LoginWindow l){
		this.modelA = am;
		this.modelC = cm;
		this.view = v;
		this.viewL = l;
		
		view.addRezervaListener(new ActionListenerRezervare());
		viewL.addLoginListener(new ActionListenerLogin());
	}
	
	class ActionListenerRezervare implements ActionListener{
	public void actionPerformed(ActionEvent e) {
			int selectedRowIndex = view.getSelectedIndex();
			if (selectedRowIndex >= 0){
				try{
					Concert c = (Concert) view.getConcertAtRow(selectedRowIndex);
					modelC.rezervareConcert(c.getDenumire());
					modelA.rezervareAbonat(viewL.getNumeAbonat());
					view.fireTableDataChanged();
					view.setTextNrRezCon(modelA.getAbonatByNume(viewL.getNumeAbonat()).getNrConcerteAlese().toString());
					
					}catch (MyException e1){
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			else
				JOptionPane.showMessageDialog(null, "Trebuie selectat un concert!");
			}
	}
	
	class ActionListenerLogin implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String numeAbonat = viewL.getNumeAbonat();
			try{
				Abonat a = modelA.getAbonatByNume(numeAbonat);
				if (!(a.equals(null))){
					viewL.setVisible(false);
					view.setSize(400, 400);
					view.setVisible(true);
					view.setTextNumeAbonat(numeAbonat);
					view.setTextNrRezCon(a.getNrConcerteAlese().toString());;
				}
			}
			catch (NullPointerException ex){
				JOptionPane.showMessageDialog(null, "Numele nu este valid!");
			}
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		view.setListaConcerte(modelC.getAllConcerte());
	}
		
	

}
