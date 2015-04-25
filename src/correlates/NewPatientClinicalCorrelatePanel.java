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
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		dxClinCorTextField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, dxClinCorTextField, 100, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, dxClinCorTextField, 201, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, dxClinCorTextField, 371, SpringLayout.WEST, this);
		add(dxClinCorTextField);
		dxClinCorTextField.setColumns(10);
		
		JLabel lblOverallDxclinicalCorrelate = new JLabel("Overall dx/Clinical Correlate:");
		springLayout.putConstraint(SpringLayout.NORTH, lblOverallDxclinicalCorrelate, 103, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblOverallDxclinicalCorrelate, 30, SpringLayout.WEST, this);
		lblOverallDxclinicalCorrelate.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblOverallDxclinicalCorrelate);
		
		dxBackgroundClinCorTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.SOUTH, dxClinCorTextField, -11, SpringLayout.NORTH, dxBackgroundClinCorTextArea);
		springLayout.putConstraint(SpringLayout.NORTH, dxBackgroundClinCorTextArea, 131, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, dxBackgroundClinCorTextArea, 201, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, dxBackgroundClinCorTextArea, 251, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, dxBackgroundClinCorTextArea, 371, SpringLayout.WEST, this);
		add(dxBackgroundClinCorTextArea);
		
		
		JLabel lblBackgroundOfDxclin = new JLabel("Background of dx/clin corr:");
		springLayout.putConstraint(SpringLayout.NORTH, lblBackgroundOfDxclin, 136, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblBackgroundOfDxclin, 40, SpringLayout.WEST, this);
		lblBackgroundOfDxclin.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblBackgroundOfDxclin);
		
		commonCausesTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, commonCausesTextArea, 262, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, commonCausesTextArea, 201, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, commonCausesTextArea, 382, SpringLayout.NORTH, this);
		add(commonCausesTextArea);
		
		JLabel lblCommonCauses = new JLabel("Common causes:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCommonCauses, 267, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblCommonCauses, 96, SpringLayout.WEST, this);
		lblCommonCauses.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblCommonCauses);
		
		pathInvestTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, pathInvestTextArea, 393, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, pathInvestTextArea, 201, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, pathInvestTextArea, 513, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, pathInvestTextArea, 0, SpringLayout.EAST, dxClinCorTextField);
		add(pathInvestTextArea);
		
		JLabel lblPathologyinvestigations = new JLabel("Pathology/Investigations:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPathologyinvestigations, 398, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPathologyinvestigations, 43, SpringLayout.WEST, this);
		lblPathologyinvestigations.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblPathologyinvestigations);
		
		typicalSxTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, typicalSxTextArea, 100, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, typicalSxTextArea, 495, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, typicalSxTextArea, 220, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, typicalSxTextArea, 665, SpringLayout.WEST, this);
		add(typicalSxTextArea);
		
		JLabel lblTypicalSx = new JLabel("Typical Sx:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTypicalSx, 103, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTypicalSx, 425, SpringLayout.WEST, this);
		lblTypicalSx.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTypicalSx);
		
		typicalTxRxTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, typicalTxRxTextArea, 233, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, typicalTxRxTextArea, 495, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, typicalTxRxTextArea, 353, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, typicalTxRxTextArea, 665, SpringLayout.WEST, this);
		add(typicalTxRxTextArea);
		
		JLabel lblTypicalTxrx = new JLabel("Typical Tx/Rx:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTypicalTxrx, 238, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblTypicalTxrx, 404, SpringLayout.WEST, this);
		lblTypicalTxrx.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblTypicalTxrx);
		
		pxTextArea = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, pxTextArea, 364, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, pxTextArea, 495, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, pxTextArea, 484, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.EAST, pxTextArea, 665, SpringLayout.WEST, this);
		add(pxTextArea);
		
		JLabel lblPrognosispx = new JLabel("Prognosis (Px):");
		springLayout.putConstraint(SpringLayout.EAST, commonCausesTextArea, -33, SpringLayout.WEST, lblPrognosispx);
		springLayout.putConstraint(SpringLayout.NORTH, lblPrognosispx, 369, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, lblPrognosispx, 404, SpringLayout.WEST, this);
		lblPrognosispx.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblPrognosispx);
		
		JButton btnNewButton = new JButton("Create");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 605, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 282, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 371, SpringLayout.WEST, this);
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
		springLayout.putConstraint(SpringLayout.NORTH, btnCancel, 605, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, btnCancel, 428, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, btnCancel, 517, SpringLayout.WEST, this);
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
