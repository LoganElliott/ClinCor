package correlates;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.SwingWorker;
import javax.swing.SpringLayout;

public class NewPatientClinicalCorrelatePanel extends JPanel {

	private ClinCorApp app;
	private JTextField dxClinCorTextField;
	private JTextArea dxBackgroundClinCorTextArea;
	private JTextArea commonCausesTextArea;
	private JTextArea pathInvestTextArea;
	private JTextArea typicalSxTextArea;
	private JTextArea typicalTxRxTextArea;
	private JTextArea pxTextArea;
	
	public NewPatientClinicalCorrelatePanel(ClinCorApp app, int pNum) {
		
		setPreferredSize (new Dimension(800, 670));
		setBounds(0, 0, 800, 600);
		
		this.app = app;
		setLayout(null);
		
		dxClinCorTextField = new JTextField();
		dxClinCorTextField.setBounds(201, 100, 170, 20);
		add(dxClinCorTextField);
		dxClinCorTextField.setColumns(10);
		
		JLabel lblOverallDxclinicalCorrelate = new JLabel("Overall dx/Clinical Correlate:");
		lblOverallDxclinicalCorrelate.setBounds(30, 103, 161, 14);
		lblOverallDxclinicalCorrelate.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblOverallDxclinicalCorrelate);
		
		dxBackgroundClinCorTextArea = new JTextArea();
		dxBackgroundClinCorTextArea.setBounds(201, 131, 170, 120);
		
		JScrollPane dxBackgroundScrollPane = new JScrollPane(dxBackgroundClinCorTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(dxBackgroundScrollPane);
		add(dxBackgroundClinCorTextArea);

		
		
		JLabel lblBackgroundOfDxclin = new JLabel("Background of dx/clin corr:");
		lblBackgroundOfDxclin.setBounds(40, 136, 152, 14);
		lblBackgroundOfDxclin.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblBackgroundOfDxclin);
		
		commonCausesTextArea = new JTextArea();
		commonCausesTextArea.setBounds(201, 262, 170, 120);
		add(commonCausesTextArea);
		
		JLabel lblCommonCauses = new JLabel("Common causes:");
		lblCommonCauses.setBounds(96, 267, 95, 14);
		lblCommonCauses.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblCommonCauses);
		
		pathInvestTextArea = new JTextArea();
		pathInvestTextArea.setBounds(201, 393, 170, 120);
		add(pathInvestTextArea);
		
		JLabel lblPathologyinvestigations = new JLabel("Pathology/Investigations:");
		lblPathologyinvestigations.setBounds(43, 398, 148, 14);
		lblPathologyinvestigations.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblPathologyinvestigations);
		
		typicalSxTextArea = new JTextArea();
		typicalSxTextArea.setBounds(495, 100, 170, 120);
		add(typicalSxTextArea);
		
		JLabel lblTypicalSx = new JLabel("Typical Sx:");
		lblTypicalSx.setBounds(425, 103, 60, 14);
		lblTypicalSx.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTypicalSx);
		
		typicalTxRxTextArea = new JTextArea();
		typicalTxRxTextArea.setBounds(495, 233, 170, 120);
		add(typicalTxRxTextArea);
		
		JLabel lblTypicalTxrx = new JLabel("Typical Tx/Rx:");
		lblTypicalTxrx.setBounds(404, 238, 81, 14);
		lblTypicalTxrx.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTypicalTxrx);
		
		pxTextArea = new JTextArea();
		pxTextArea.setBounds(495, 364, 170, 120);
		add(pxTextArea);
		
		JLabel lblPrognosispx = new JLabel("Prognosis (Px):");
		lblPrognosispx.setBounds(404, 369, 85, 14);
		lblPrognosispx.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblPrognosispx);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(282, 605, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pNum != -1 ) {
					app.retrievePatientDetails();
				} else {
					app.retrieveEditedPatientDetails(pNum);
				}
			}
		});
		add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(428, 605, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pNum != -1) {
					app.closeNewPatient();
				} else {
					app.closeSpecificPatient();
				}
			}
		});
		add(btnCancel);
		
		if (pNum != -1) 
			updateDetails(pNum);
		
	}
	
	
	public String[] sendPatientDetails() {
		String[] clinCor = new String[7];
		clinCor[0] = dxClinCorTextField.getText();
		clinCor[1] = dxBackgroundClinCorTextArea.getText();
		clinCor[2] = commonCausesTextArea.getText();
		clinCor[3] = pathInvestTextArea.getText();
		clinCor[4] = typicalSxTextArea.getText();
		clinCor[5] = typicalTxRxTextArea.getText();
		clinCor[6] = pxTextArea.getText();
		return clinCor;
	}
	
	private void updateDetails (int pNum) {
		dxClinCorTextField.setText(app.getSpecificPatient(pNum).ddx);
		dxBackgroundClinCorTextArea.setText(app.getSpecificPatient(pNum).backgroundDxClincor);
		commonCausesTextArea.setText(app.getSpecificPatient(pNum).commonCauses);
		pathInvestTextArea.setText(app.getSpecificPatient(pNum).pathologyInvestigations);
		typicalSxTextArea.setText(app.getSpecificPatient(pNum).typSx);
		typicalTxRxTextArea.setText(app.getSpecificPatient(pNum).typTxRx);
		pxTextArea.setText(app.getSpecificPatient(pNum).px);
	}
}
