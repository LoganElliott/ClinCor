package correlates;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewPatientHistoryPanel extends JPanel {

	private ClinCorApp app;
	private JTextArea presentingComplaintsTextArea;
	private JTextArea hxPresentingComplaintsTextArea;
	private JTextArea pastMedicalHxTextArea;
	private JTextArea medicationsTextArea;
	private JTextArea allAdvDrugReactionsTextArea;
	private JTextArea perSocOccHxTextArea;
	private JTextArea familyHxTextArea;
	
	public NewPatientHistoryPanel(ClinCorApp app, int pNum) {
		setLayout(null);
		
		setPreferredSize (new Dimension(800, 670));
		setBounds(0, 0, 800, 600);
		
		this.app = app;
		
		presentingComplaintsTextArea = new JTextArea();
		presentingComplaintsTextArea.setBounds(201, 100, 170, 120);
		add(presentingComplaintsTextArea);
		
		JLabel lblPresentingComplaints = new JLabel("Presenting complaints:");
		lblPresentingComplaints.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPresentingComplaints.setBounds(62, 105, 129, 14);
		add(lblPresentingComplaints);
		
		hxPresentingComplaintsTextArea = new JTextArea();
		hxPresentingComplaintsTextArea.setBounds(201, 231, 170, 120);
		add(hxPresentingComplaintsTextArea);
		
		JLabel lblHxOfPresenting = new JLabel("Hx of presenting complaint:");
		lblHxOfPresenting.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHxOfPresenting.setBounds(36, 236, 155, 14);
		add(lblHxOfPresenting);
		
		pastMedicalHxTextArea = new JTextArea();
		pastMedicalHxTextArea.setBounds(201, 362, 170, 120);
		add(pastMedicalHxTextArea);
		
		JLabel lblPastMedicalHx = new JLabel("Past medical Hx:");
		lblPastMedicalHx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPastMedicalHx.setBounds(98, 367, 93, 14);
		add(lblPastMedicalHx);
		
		medicationsTextArea = new JTextArea();
		medicationsTextArea.setBounds(493, 68, 170, 60);
		add(medicationsTextArea);
		
		JLabel lblMedications = new JLabel("Medications:");
		lblMedications.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMedications.setBounds(412, 73, 71, 14);
		add(lblMedications);
		
		allAdvDrugReactionsTextArea = new JTextArea();
		allAdvDrugReactionsTextArea.setBounds(493, 139, 170, 120);
		add(allAdvDrugReactionsTextArea);
		
		JLabel lblNewLabel = new JLabel("<html>Allergies/Adverse<br>drug reactions:</html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(381, 144, 102, 28);
		add(lblNewLabel);
		
		perSocOccHxTextArea = new JTextArea();
		perSocOccHxTextArea.setBounds(493, 270, 170, 120);
		add(perSocOccHxTextArea);
		
		JLabel lblPersonalSocialAnd = new JLabel("<html>Personal, social<br>and occupational Hx:</html>");
		lblPersonalSocialAnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonalSocialAnd.setBounds(381, 275, 102, 42);
		add(lblPersonalSocialAnd);
		
		familyHxTextArea = new JTextArea();
		familyHxTextArea.setBounds(493, 401, 170, 120);
		add(familyHxTextArea);
		
		JLabel lblFamilyHx = new JLabel("Family Hx:");
		lblFamilyHx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFamilyHx.setBounds(425, 406, 58, 14);
		add(lblFamilyHx);
		
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
		String[] hist = new String[7];
		hist[0] = presentingComplaintsTextArea.getText();
		hist[1] = hxPresentingComplaintsTextArea.getText();
		hist[2] = pastMedicalHxTextArea.getText();
		hist[3] = medicationsTextArea.getText();
		hist[4] = allAdvDrugReactionsTextArea.getText();
		hist[5] = perSocOccHxTextArea.getText();
		hist[6] = familyHxTextArea.getText();
		return hist;
	}
	
	private void updateInfo (int pNum) {
		presentingComplaintsTextArea.setText(app.getSpecificPatient(pNum).presentingComplaints);
		hxPresentingComplaintsTextArea.setText(app.getSpecificPatient(pNum).hxPresentingComplaints);
		pastMedicalHxTextArea.setText(app.getSpecificPatient(pNum).pastMedicalHx);
		medicationsTextArea.setText(app.getSpecificPatient(pNum).medications);
		allAdvDrugReactionsTextArea.setText(app.getSpecificPatient(pNum).allergiesAdverse);
		perSocOccHxTextArea.setText(app.getSpecificPatient(pNum).personalSocialOccuHx);
		familyHxTextArea.setText(app.getSpecificPatient(pNum).familyHx);
	}
}
