package correlates;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewPatientPatientDemographicsPanel extends JPanel {
	protected JTextField dateTextField;
	
	private ClinCorApp app;
	private JTextField ptCodeTextField;
	private JTextField ageTextField;
	private JTextField ethnicityTextField;
	private JComboBox specialtyComboBox;
	private JComboBox genderComboBox;


	public NewPatientPatientDemographicsPanel(ClinCorApp app, int pNum) {
		setLayout(null);
		
		setPreferredSize (new Dimension(800, 670));
		setBounds(0, 0, 800, 600);
		
		this.app = app;
		
		dateTextField = new JTextField();
		dateTextField.setBounds(201, 100, 170, 20);
		add(dateTextField);
		dateTextField.setColumns(10);
		
		JLabel lblModulegeneral = new JLabel("Date:");
		lblModulegeneral.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModulegeneral.setBounds(161, 103, 30, 14);
		add(lblModulegeneral);
		
		JLabel lblClinicalCorrelatedx = new JLabel("Specialty:");
		lblClinicalCorrelatedx.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClinicalCorrelatedx.setBounds(136, 134, 55, 14);
		add(lblClinicalCorrelatedx);
		
		JLabel lblPtcode = new JLabel("Pt code:");
		lblPtcode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPtcode.setBounds(145, 159, 46, 14);
		add(lblPtcode);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(163, 184, 28, 14);
		add(lblAge);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(145, 209, 46, 14);
		add(lblGender);
		
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
		
		specialtyComboBox = new JComboBox();
		specialtyComboBox.setModel(new DefaultComboBoxModel(new String[] {"CVS", "ClinSci", "Derm", "Endcr", "GastrEnt", "Haem", "H&N", "Immn", "ID", "MS", "Nephr", "NS", "Onco", "ReprO", "U&G", "RS", "Hep"}));
		specialtyComboBox.setBounds(201, 131, 170, 20);
		add(specialtyComboBox);
		
		JLabel lblEthnicity = new JLabel("Ethnicity:");
		lblEthnicity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEthnicity.setBounds(136, 234, 55, 14);
		add(lblEthnicity);
		
		genderComboBox = new JComboBox();
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		genderComboBox.setBounds(201, 206, 55, 20);
		add(genderComboBox);
		
		ptCodeTextField = new JTextField();
		ptCodeTextField.setColumns(10);
		ptCodeTextField.setBounds(201, 156, 170, 20);
		add(ptCodeTextField);
		
		ageTextField = new JTextField();
		ageTextField.setColumns(10);
		ageTextField.setBounds(201, 181, 170, 20);
		add(ageTextField);
		
		ethnicityTextField = new JTextField();
		ethnicityTextField.setColumns(10);
		ethnicityTextField.setBounds(201, 231, 170, 20);
		add(ethnicityTextField);
		
		if (pNum != -1)
			updateInfo(pNum);

	}
	
	//creates a String array that contains all the patient info for this panel which is then sent to the ClinCorApp class
	public String[] sendPatientDetails() {
		String[] demo = new String[6];
		demo[0] = dateTextField.getText();
		demo[1] = (String)specialtyComboBox.getSelectedItem();
		demo[2] = ptCodeTextField.getText();
		demo[3] = ageTextField.getText();
		demo[4] = (String)genderComboBox.getSelectedItem();
		demo[5] = ethnicityTextField.getText();
		return demo;
	}
	
	private void updateInfo (int pNum) {
		ptCodeTextField.setText(app.getSpecificPatient(pNum).ptCode);
		ageTextField.setText(app.getSpecificPatient(pNum).age);
		dateTextField.setText(app.getSpecificPatient(pNum).date);
		specialtyComboBox.setSelectedItem(app.getSpecificPatient(pNum).specialty);
		genderComboBox.setSelectedItem(app.getSpecificPatient(pNum).gender);
		ethnicityTextField.setText(app.getSpecificPatient(pNum).ethnicity);
	}
	
}
