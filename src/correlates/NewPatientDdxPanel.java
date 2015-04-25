package correlates;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewPatientDdxPanel extends JPanel {

	private ClinCorApp app;
	private JTextArea ddxTextArea;
	private JTextArea problemListTextArea;
	private JTextArea managementPlanTextArea;
	
	public NewPatientDdxPanel(ClinCorApp app, int pNum) {
		setLayout(null);
		
		setPreferredSize (new Dimension(800, 670));
		setBounds(0, 0, 800, 600);
		
		this.app = app;
		
		ddxTextArea = new JTextArea();
		ddxTextArea.setBounds(201, 100, 170, 60);
		add(ddxTextArea);
		
		JLabel lblDdx = new JLabel("Ddx:");
		lblDdx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDdx.setBounds(166, 105, 25, 14);
		add(lblDdx);
		
		problemListTextArea = new JTextArea();
		problemListTextArea.setBounds(201, 171, 170, 120);
		add(problemListTextArea);
		
		JLabel lblProblemList = new JLabel("Problem list:");
		lblProblemList.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProblemList.setBounds(121, 176, 70, 14);
		add(lblProblemList);
		
		managementPlanTextArea = new JTextArea();
		managementPlanTextArea.setBounds(495, 100, 170, 120);
		add(managementPlanTextArea);
		
		JLabel lblManagementPlan = new JLabel("Management Plan:");
		lblManagementPlan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblManagementPlan.setBounds(380, 105, 105, 14);
		add(lblManagementPlan);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pNum == -1) {
					app.retrievePatientDetails();
				} else {
					app.retrieveEditedPatientDetails(pNum);
				}
			}
		});
		btnNewButton.setBounds(282, 605, 89, 23);
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pNum == -1) {
					app.closeNewPatient();
				} else {
					app.closeSpecificPatient();
				}
			}
		});
		btnCancel.setBounds(428, 605, 89, 23);
		add(btnCancel);
		
		if (pNum != -1)
			updateInfo(pNum);

	}
	
	public String[] sendPatientDetails() {
		String[] ddx = new String[3];
		ddx[0] = ddxTextArea.getText();
		ddx[1] = problemListTextArea.getText();
		ddx[2] = managementPlanTextArea.getText();
		return ddx;
	}
	
	private void updateInfo (int pNum) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ddxTextArea.setText(app.getSpecificPatient(pNum).ddx);
				problemListTextArea.setText(app.getSpecificPatient(pNum).problemList);
				managementPlanTextArea.setText(app.getSpecificPatient(pNum).managementPlan);
			}
		});
	}

}
