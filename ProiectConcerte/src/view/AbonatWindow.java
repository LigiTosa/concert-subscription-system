package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import validator.MyException;
import domain.Concert;

public class AbonatWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ModelTableConcerte modelTabel;
	private JTable tabel;
	private JScrollPane scrollTabel;
	private JLabel numeAbonat;
	private JButton rezerva;
	private JLabel nrRezCon;
	
	public AbonatWindow(List<Concert> c){
		super("Abonat");
		add(creareTabel(c),BorderLayout.CENTER);
		add(creareButoane(),BorderLayout.SOUTH);
	}
	
	private Component creareButoane() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(3,2));
		
		JPanel linia = new JPanel();
		linia.add(new JLabel("Nume abonat: "));
		linia.add(numeAbonat = new JLabel());
		pan.add(linia);
		
		JPanel linia2 = new JPanel();
		linia2.add(new JLabel("Numar rezervari concerte: "));
		linia2.add(nrRezCon = new JLabel());
		pan.add(linia2);
		
		rezerva = new JButton("Rezerva");
		JPanel linia1 = new JPanel();
		linia1.add(rezerva);
		pan.add(linia1);
		
		return pan;
	}


	private JPanel creareTabel(List<Concert> c) {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(0,1));
		
		//cream modelul tabelului
		modelTabel = new ModelTableConcerte(c);
				
		//cream tabelul
		tabel = new JTable(modelTabel);
		tabel.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//tabel.getSelectionModel().addListSelectionListener(new TabelListener());
		
		//cream scroll pentru tabel
		scrollTabel = new JScrollPane(tabel);
		tabel.setSize(100,200);
		
		pan.add(scrollTabel);
		return pan;
				
	}
	
	public void setTextNrRezCon(String s){
		nrRezCon.setText(s);	
	}
	
	public void setTextNumeAbonat(String s){
		numeAbonat.setText(s);
	}
	
	public Integer getSelectedIndex(){
	    return tabel.getSelectedRow();
	}
	
	public Concert getConcertAtRow(int rowIndex){
		try{
			Concert c = modelTabel.getConcertAtRow(rowIndex);
			return c;
		}catch (MyException e){
			throw new MyException(e.getMessage());
		}	
	}
	
	public void fireTableDataChanged(){
		modelTabel.fireTableDataChanged();
	}
	
	public void setListaConcerte(List<Concert> concerte){
		modelTabel.setListaConcerte(concerte);
	}
	
	public void addRezervaListener(ActionListener al) {
		rezerva.addActionListener(al);
	}
		
}
	
	

