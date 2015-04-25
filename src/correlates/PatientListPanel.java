package correlates;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PatientListPanel extends JPanel {
	
	private ClinCorApp app;
	private ArrayList<Patient> p;
	private int row;
	private int currentPNum;

	public PatientListPanel(ClinCorApp app, ArrayList<Patient> p) {
		super(new GridLayout(1,0));
		setPreferredSize (new Dimension(1366, 768));
		
		//creating column names for table
		String[] columnNames = {"Patient Number", "Date", "Gender", "Specialty", 
				"Overall dx/Clinical Correlate"};
		
		//creating table model and making it not editable
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		//iterating through patient arraylist and retrieving patient info
		for(int i = 0; i < p.size(); i++) {
			Object[] currentPatient = {p.get(i).getPNum(), p.get(i).date, p.get(i).gender, p.get(i).specialty, 
					p.get(i).overallDxClinCor};
			tableModel.addRow(currentPatient);
		}
		
		JTable table = new JTable(tableModel);
		
		//each column can be sorted alphabetically/numerically
		table.setAutoCreateRowSorter(true);
				
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane);
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount()==2) {
					row = table.rowAtPoint(e.getPoint());
					currentPNum = Integer.parseInt(table.getValueAt(row, 0).toString());
					app.viewCurrentPatient(currentPNum);
				}
			}
		});
		
		
		this.app = app;
		this.p = p;

	}
}
