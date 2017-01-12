package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import model.ConcerteModel;
import validator.MyException;
import view.AdministratorWindow;

public class AdministratorController implements Observer {
	private ConcerteModel modelC;
	private AdministratorWindow view;
	
	public AdministratorController(ConcerteModel cm, AdministratorWindow v){
		this.modelC = cm;
		this.view = v;
		
		view.addAdaugaListener(new ActionListenerAdaugare());
	}
	
	class ActionListenerAdaugare implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String denumire = view.getDenumire();
			String data = view.getData();
			String nrLocuri = view.getLocuri();
			try{
				Integer nrlocuri = Integer.valueOf(nrLocuri);
				modelC.adaugaConcert(denumire, data, nrlocuri);
				view.fireTableDataChanged();
			}catch (MyException ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
			catch (NumberFormatException ex1){
				JOptionPane.showMessageDialog(null, "Numarul de locuri nu este valid: acesta trebuie sa fie intreg si nu poate fi nul!");
			}
			
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		view.setListaConcerte(modelC.getAllConcerte());
	}
	
}

