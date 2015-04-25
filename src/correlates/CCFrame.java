package correlates;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CCFrame extends JFrame {
			
	public CCFrame (String title, JPanel panel) {
		
		setTitle(title);
		
		Container cp = getContentPane();
		cp.add(panel);
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
