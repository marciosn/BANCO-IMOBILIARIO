package br.com.ufc.es.BancoImb.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CriarTabuleiro {
	JFrame frame = new JFrame();
	JButton[][] grid;

	public CriarTabuleiro(int width, int length) {
		frame.setTitle("Banco Imobiliario");
		frame.setLayout(new GridLayout(width, length));
		grid = new JButton[width][length];
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y] = new JButton("(" + x + "," + y + ")");
				frame.add(grid[x][y]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void criarTabuleiro(int width, int length) {
		frame.setTitle("Banco Imobiliario");
		frame.setLayout(new GridLayout(width, length));
		grid = new JButton[width][length];
		for (int y = 0; y < length; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y] = new JButton("(" + x + "," + y + ")");
				frame.add(grid[x][y]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
