package view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import validator.MyException;
import domain.Concert;

public class ModelTableConcerte extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] numeColoane = {"Denumire", "Data", "Locuri disponibile"};
	private List<Concert> concerte;
	
	public ModelTableConcerte(List<Concert> concerte){
		this.concerte = concerte;
	}

	@Override
	public int getColumnCount() {
		return numeColoane.length;
	}
	
	@Override
	public String getColumnName(int index)
	{
		if (index == 0)
			return "Denumire";
		if (index == 1)
			return "Data";
		if (index == 2)
			return "Locuri disponibile";
		
		return null;
	}
	

	@Override
	public int getRowCount() {
		if (concerte != null)
				return concerte.size();
		else
			return -1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0)
			return concerte.get(rowIndex).getDenumire();
		if (columnIndex == 1)
			return concerte.get(rowIndex).getData();
		if (columnIndex == 2)
			return concerte.get(rowIndex).getLocuriDisponibile();
		return null;
		
	}
	
	public Concert getConcertAtRow(int rowIndex){
		try{
			Concert c = new Concert(concerte.get(rowIndex).getDenumire(),
					concerte.get(rowIndex).getData(),concerte.get(rowIndex).getLocuriDisponibile());
			return c;
		}catch (MyException e){
			throw new MyException(e.getMessage());
		}	
	}
	
	public void setListaConcerte(List<Concert> concerte)
	{
		this.concerte  = concerte;
		fireTableDataChanged();
	}
	
}
