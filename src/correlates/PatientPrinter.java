package correlates;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PatientPrinter {
	
	
	public static void printPatient (Patient p) {
		
		try {
			PrintWriter printer = new PrintWriter (new BufferedWriter(new FileWriter("patient" + p.patientNum + ".txt")));
			printer.println(p.toString());
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
