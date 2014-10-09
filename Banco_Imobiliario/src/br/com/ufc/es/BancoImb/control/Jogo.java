package br.com.ufc.es.BancoImb.control;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Jogo extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8790855397582688550L;
	public Jogo() {
		
	}
	public static void main(String[] args) {
		  
		
		/*EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Jogo janela = new Jogo();
				janela.setSize(800, 600);
				janela.setVisible(true);
				janela.setTitle("Banco Imobiliário");
				
				JButton iniciar = new JButton();
				iniciar.setText("Iniciar Jogo");
				iniciar.setVisible(true);
				iniciar.updateUI();
				
				
			}
		});
		*/
		new Controlador_Banco_Imobiliario();
		
		}

}
