package correlates;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel implements ActionListener {
	
	private JButton createNewPatientButton;
	private JButton viewPatientsButton;
	private JButton closeButton;
	private final ClinCorApp app;
	
	public MainMenuPanel (ClinCorApp app) {
		setPreferredSize (new Dimension(800, 600));
		setBounds(0, 0, 800, 600);
		
		createNewPatientButton = new JButton("Create New Patient");
		viewPatientsButton = new JButton("View Current Patients");
		closeButton = new JButton("Close");
		
		createNewPatientButton.addActionListener(this);
		viewPatientsButton.addActionListener(this);
		closeButton.addActionListener(this);
		
		add(createNewPatientButton);
		add(viewPatientsButton);
		add(closeButton);
		
		this.app = app;
	}
	
	public void actionPerformed (ActionEvent e) {
		 
		if (e.getSource() == createNewPatientButton) {
			app.openNewPatient();
		}
		
		if (e.getSource() == viewPatientsButton) {
			app.openViewPatients();
		}
		
		if (e.getSource() == closeButton) {
			app.savePatients();
			app.closeMainMenuAndExit();
		}
	}

}
