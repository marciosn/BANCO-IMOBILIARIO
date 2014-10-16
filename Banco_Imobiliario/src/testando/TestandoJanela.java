package testando;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import jplay.Window;

public class TestandoJanela {
	 public static void main(String[] args) {
		 
		JTextArea portifolio = new JTextArea();
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.append("TESTANDO PRA VER SE ESSA PORRA PRESTA" + "\n");
		portifolio.setAutoscrolls(true);
		JOptionPane.showMessageDialog(null, portifolio.getText());	
		 
	 }
}
