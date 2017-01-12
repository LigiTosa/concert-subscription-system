package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nume;
	private JButton login;
	
	public LoginWindow(){
		super("Login abonat");
		add(creareButoane(), BorderLayout.CENTER);
	}

	private Component creareButoane() {
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2,2));
		
		JPanel linia1 = new JPanel();
		linia1.add(new JLabel("Nume: "));
		linia1.add(nume = new JTextField(10));
		pan.add(linia1);
		
		login = new JButton("Login");
		JPanel linia2 = new JPanel();
		linia2.add(login);
		pan.add(linia2);
		
		return pan;	
	}
	
	public String getNumeAbonat(){
		return nume.getText();
	}
	
	public void addLoginListener(ActionListener al){
		login.addActionListener(al);
	}
}
