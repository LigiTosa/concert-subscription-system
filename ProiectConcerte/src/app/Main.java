package app;

import javax.swing.UIManager;
import controller.AbonatiConcerteController;
import controller.AdministratorController;
import model.AbonatiModel;
import model.ConcerteModel;
import repository.AbonatiRepository;
import repository.ConcerteRepository;
import view.AbonatWindow;
import view.AdministratorWindow;
import view.LoginWindow;


public class Main {

	public static void main(String[] args) {
		AbonatiRepository abRepo = new AbonatiRepository();
		AbonatiModel modelA = new AbonatiModel(abRepo);
		
		ConcerteRepository conRepo = new ConcerteRepository();
		ConcerteModel modelC = new ConcerteModel(conRepo);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		AdministratorWindow aw = new AdministratorWindow(modelC.getAllConcerte());
		AdministratorController ac = new AdministratorController(modelC, aw);
		modelC.addObserver(ac);
		aw.setSize(400, 400);
		aw.setVisible(true);	
	
		LoginWindow l = new LoginWindow();
		AbonatWindow g = new AbonatWindow(modelC.getAllConcerte());
		AbonatiConcerteController acc = new AbonatiConcerteController(modelA, modelC, g, l);
		modelA.addObserver(acc);
		modelC.addObserver(acc);
		l.setSize(250, 100);
		l.setVisible(true);
		
		LoginWindow l1 = new LoginWindow();
		AbonatWindow g1 = new AbonatWindow(modelC.getAllConcerte());
		AbonatiConcerteController acc1 = new AbonatiConcerteController(modelA, modelC, g1, l1);
		modelA.addObserver(acc1);
		modelC.addObserver(acc1);
		l1.setSize(250, 100);
		l1.setVisible(true);
		

	}

}
