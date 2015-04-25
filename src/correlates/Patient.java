package correlates;

import java.io.Serializable;

public class Patient implements Serializable {
	
	public String date;
	public String specialty;
	public String ptCode;
	public String age;
	public String gender;
	public String ethnicity;
	public String presentingComplaints;
	public String hxPresentingComplaints;
	public String pastMedicalHx;
	public String medications;
	public String allergiesAdverse;
	public String personalSocialOccuHx;
	public String familyHx;
	public String generalVitalSigns;
	public String cardio;
	public String resp;
	public String abdo;
	public String neuro;
	public String ddx;
	public String problemList;
	public String managementPlan;
	public String overallDxClinCor;
	public String backgroundDxClincor;
	public String commonCauses;
	public String pathologyInvestigations;
	public String typSx;
	public String typTxRx;
	public String px;
	private static final long serialVersionUID = 1;
	public int patientNum;
	
	public Patient (String[] demo, String[] hist, String[] exam, String[] ddx, String[] clinCor, int pNum) {
		date = demo[0];
		specialty = demo[1];
		ptCode = demo[2];
		age = demo[3];
		gender = demo[4];
		ethnicity = demo[5];
		presentingComplaints = hist[0];
		hxPresentingComplaints = hist[1];
		pastMedicalHx = hist[2];
		medications = hist[3];
		allergiesAdverse = hist[4];
		personalSocialOccuHx = hist[5];
		familyHx = hist[6];
		generalVitalSigns = exam[0];
		cardio = exam[1];
		resp = exam[2];
		abdo = exam[3];
		neuro = exam[4];
		this.ddx = ddx[0];
		problemList = ddx[1];
		managementPlan = ddx[2];
		overallDxClinCor = clinCor[0];
		backgroundDxClincor = clinCor[1];
		commonCauses = clinCor[2];
		pathologyInvestigations = clinCor[3];
		typSx = clinCor[4];
		typTxRx = clinCor[5];
		px = clinCor[6];
		patientNum = pNum;
		
	}
	
	public int getPNum() {
		return patientNum;
	}
	
	public void setPNum(int n) {
		patientNum = n;
	}
	
	public String toString() {
		String n = System.getProperty("line.separator");
		String info = "Date: " + date + n + "Specialty: " + specialty + n + "PtCode: " + ptCode + n + "Age: " + age;
		return info;
	}

}
