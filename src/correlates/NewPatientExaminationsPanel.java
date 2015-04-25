package correlates;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewPatientExaminationsPanel extends JPanel {

	private ClinCorApp app;
	private JTextArea generalVitalSignsTextArea;
	private JTextArea cardioTextArea;
	private JTextArea respTextArea;
	private JTextArea abdoTextArea;
	private JTextArea neuroTextArea;
	
	public NewPatientExaminationsPanel(ClinCorApp app, int pNum) {
		setLayout(null);
		
		setPreferredSize (new Dimension(800, 670));
		setBounds(0, 0, 800, 600);
		
		this.app = app;
		
		generalVitalSignsTextArea = new JTextArea();
		generalVitalSignsTextArea.setBounds(201, 100, 170, 60);
		add(generalVitalSignsTextArea);
		
		JLabel lblGeneralvitalSigns = new JLabel("General/Vital signs:");
		lblGeneralvitalSigns.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGeneralvitalSigns.setBounds(81, 105, 110, 14);
		add(lblGeneralvitalSigns);
		
		cardioTextArea = new JTextArea();
		cardioTextArea.setBounds(201, 171, 170, 60);
		add(cardioTextArea);
		
		JLabel lblCardio = new JLabel("Cardio:");
		lblCardio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCardio.setBounds(152, 176, 39, 14);
		add(lblCardio);
		
		respTextArea = new JTextArea();
		respTextArea.setBounds(201, 242, 170, 60);
		add(respTextArea);
		
		JLabel lblResp = new JLabel("Resp:");
		lblResp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblResp.setBounds(160, 247, 31, 14);
		add(lblResp);
		
		abdoTextArea = new JTextArea();
		abdoTextArea.setBounds(495, 100, 170, 60);
		add(abdoTextArea);
		
		JLabel lblAbdo = new JLabel("Abdo:");
		lblAbdo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAbdo.setBounds(446, 105, 39, 14);
		add(lblAbdo);
		
		neuroTextArea = new JTextArea();
		neuroTextArea.setBounds(495, 171, 170, 60);
		add(neuroTextArea);
		
		JLabel lblNeuro = new JLabel("Neuro:");
		lblNeuro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNeuro.setBounds(446, 176, 39, 14);
		add(lblNeuro);
		
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
		String[] exam = new String[5];
		exam[0] = generalVitalSignsTextArea.getText();
		exam[1] = cardioTextArea.getText();
		exam[2] = respTextArea.getText();
		exam[3] = abdoTextArea.getText();
		exam[4] = neuroTextArea.getText();
		return exam;
	}
	
	private void updateInfo (int pNum) {
		generalVitalSignsTextArea.setText(app.getSpecificPatient(pNum).generalVitalSigns);
		cardioTextArea.setText(app.getSpecificPatient(pNum).cardio);
		respTextArea.setText(app.getSpecificPatient(pNum).resp);
		abdoTextArea.setText(app.getSpecificPatient(pNum).abdo);
		neuroTextArea.setText(app.getSpecificPatient(pNum).neuro);
	}

}
