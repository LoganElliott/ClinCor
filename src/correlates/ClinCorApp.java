package correlates;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class ClinCorApp {
	
	private CCFrame mainMenuFrame;
	private JFrame newPatientFrame;
	private JFrame currentPatientFrame;
	private CCFrame patientListFrame;
	private JTabbedPane newPatientTabbedPane;
	private JTabbedPane currentPatientTabbedPane;
	private NewPatientPatientDemographicsPanel patientDemographics;
	private NewPatientHistoryPanel patientHistory;
	private NewPatientExaminationsPanel patientExaminations;
	private NewPatientDdxPanel patientDdx;
	private NewPatientClinicalCorrelatePanel patientClinicalCorrelate;
	private NewPatientPatientDemographicsPanel currentPatientDemographics;
	private NewPatientHistoryPanel currentPatientHistory;
	private NewPatientExaminationsPanel currentPatientExaminations;
	private NewPatientDdxPanel currentPatientDdx;
	private NewPatientClinicalCorrelatePanel currentPatientClinicalCorrelate;
	
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	
	public ClinCorApp() {
		loadPatients();
		mainMenuFrame = new CCFrame("ClinCor - Main Menu", new MainMenuPanel(this));
		mainMenuFrame.setVisible(true);
	}
	
	private void loadPatients() {
		try {
			FileInputStream patientsIn = new FileInputStream("patients.ser");
			ObjectInputStream in = new ObjectInputStream(patientsIn);
			patients = (ArrayList<Patient>) in.readObject();
			in.close();
			patientsIn.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void savePatients() {
		try {
			FileOutputStream patientsOut = new FileOutputStream("patients.ser");
			ObjectOutputStream out = new ObjectOutputStream(patientsOut);
			out.writeObject(patients);
			out.close();
			patientsOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}
	
	public Patient getSpecificPatient(int num) {
		return patients.get(num);
	}
	
	public void closeMainMenuAndExit() {
		mainMenuFrame.setVisible(false);
		System.exit(0);
	}
	
	public void openNewPatient() {
		patientDemographics = new NewPatientPatientDemographicsPanel(this, -1);
		patientHistory = new NewPatientHistoryPanel(this, -1);
		patientExaminations = new NewPatientExaminationsPanel(this, -1);
		patientDdx = new NewPatientDdxPanel(this, -1);
		patientClinicalCorrelate = new NewPatientClinicalCorrelatePanel(this, -1);
		newPatientFrame = new JFrame("ClinCor - New Patient");
		newPatientFrame.setVisible(true);
		newPatientFrame.setResizable(false);
		newPatientTabbedPane = new JTabbedPane();
		newPatientTabbedPane.addTab("Patient Demographics", patientDemographics);
		newPatientTabbedPane.addTab("History", patientHistory);
		newPatientTabbedPane.addTab("Examinations", patientExaminations);
		newPatientTabbedPane.addTab("Ddx", patientDdx);
		newPatientTabbedPane.addTab("Clinical Correlate", patientClinicalCorrelate);
		newPatientFrame.add(newPatientTabbedPane);
		newPatientFrame.pack();
		newPatientFrame.setLocationRelativeTo(null);
	}
	
	//calls for each panel to send patient info
	public void retrievePatientDetails() {
		String[] demo = patientDemographics.sendPatientDetails();
		String[] hist = patientHistory.sendPatientDetails();
		String[] exam = patientExaminations.sendPatientDetails();
		String[] ddx = patientDdx.sendPatientDetails();
		String[] clinCor = patientClinicalCorrelate.sendPatientDetails();
		addNewPatient(new Patient(demo, hist, exam, ddx, clinCor, patients.size()));
		savePatients();
	}
	
	public void retrieveEditedPatientDetails(int pNum) {
		String[] demo = currentPatientDemographics.sendPatientDetails();
		String[] hist = currentPatientHistory.sendPatientDetails();
		String[] exam = currentPatientExaminations.sendPatientDetails();
		String[] ddx = currentPatientDdx.sendPatientDetails();
		String[] clinCor = currentPatientClinicalCorrelate.sendPatientDetails();
		Patient p = new Patient(demo, hist, exam, ddx, clinCor, pNum);
		patients.remove(pNum);
		patients.add(pNum, p);
		savePatients();
	}
	
	public void closeNewPatient() {
		newPatientFrame.setVisible(false);
	}
	
	public void addNewPatient(Patient p) {
		patients.add(p);
		closeNewPatient();
	}
	
	public void openViewPatients() {
		patientListFrame = new CCFrame("ClinCor - View Patients", new PatientListPanel(this, patients));
		patientListFrame.setVisible(true);
	}
	
	public void viewCurrentPatient(int pNum) {
		currentPatientDemographics = new NewPatientPatientDemographicsPanel(this, pNum);
		currentPatientHistory = new NewPatientHistoryPanel(this, pNum);
		currentPatientExaminations = new NewPatientExaminationsPanel(this, pNum);
		currentPatientDdx = new NewPatientDdxPanel(this, pNum);
		currentPatientClinicalCorrelate = new NewPatientClinicalCorrelatePanel(this, pNum);
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem printMenuItem = new JMenuItem("Print");
		printMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatientPrinter.printPatient(getSpecificPatient(pNum));
			}
		});
		
		menu.add(printMenuItem);
						
		currentPatientFrame = new JFrame("ClinCor - Edit Patient");
		currentPatientFrame.setVisible(true);
//		currentPatientFrame.setResizable(false);
		currentPatientTabbedPane = new JTabbedPane();
		currentPatientTabbedPane.addTab("Patient Demographics", currentPatientDemographics);
		currentPatientTabbedPane.addTab("History", currentPatientHistory);
		currentPatientTabbedPane.addTab("Examinations", currentPatientExaminations);
		currentPatientTabbedPane.addTab("Ddx", currentPatientDdx);
		currentPatientTabbedPane.addTab("Clinical Correlate", currentPatientClinicalCorrelate);
		currentPatientFrame.add(currentPatientTabbedPane);
		currentPatientFrame.setJMenuBar(menuBar);
		currentPatientFrame.pack();
		currentPatientFrame.setLocationRelativeTo(null);
	}
	
	public void closeSpecificPatient() {
		currentPatientFrame.setVisible(false);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ClinCorApp();
			}
		});
	}
}
