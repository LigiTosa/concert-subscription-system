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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import domain.Concert;

public class AdministratorWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private ModelTableConcerte modelTabel;
	private JTable tabel;
	private JScrollPane scrollTabel;
	JTextField denumire, data, locuri;
	JButton adauga, sterge;
	
	public AdministratorWindow(List<Concert> c){
		super("Administrator");
		add(creareTabel(c),BorderLayout.CENTER);
		add(creareButoane(),BorderLayout.SOUTH);
	}


	private Component creareButoane() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(4,2));
		
		JPanel linia = new JPanel();
		linia.add(new JLabel("Denumire: "));
		linia.add(denumire = new JTextField(10));
		denumire.setEditable(true);
		pan.add(linia);
		
		JPanel linia2 = new JPanel();
		linia2.add(new JLabel("Data: "));
		linia2.add(data = new JTextField(10));
		data.setEditable(true);
		pan.add(linia2);
		
		JPanel linia3 = new JPanel();
		linia3.add(new JLabel("Numar locuri: "));
		linia3.add(locuri = new JTextField(10));
		locuri.setEditable(true);
		pan.add(linia3);
		
		adauga = new JButton("Adauga");
		JPanel linia1 = new JPanel();
		linia1.add(adauga);
		pan.add(adauga);
		
		return pan;
	}


	private Component creareTabel(List<Concert> c) {
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
	
	public void setListaConcerte(List<Concert> concerte){
		modelTabel.setListaConcerte(concerte);
	}
	
	public void fireTableDataChanged(){
		modelTabel.fireTableDataChanged();
	}
	
	public void addAdaugaListener(ActionListener al) {
		adauga.addActionListener(al);
	}
	
	public String getDenumire(){
		return denumire.getText();
	}
	
	public String getData(){
		return data.getText();
	}
	
	public String getLocuri(){
		return locuri.getText();
	}
	
	
}
