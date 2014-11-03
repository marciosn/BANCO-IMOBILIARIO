package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import jplay.Sound;
import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialSorteReves extends LogradouroEspecial implements IEfeitoCasa{
	
	private List<Float> cartas;
	private int indice;
	private Constantes constante;
	
	public LogradouroEspecialSorteReves(String nome, Point posicao) {
		super(nome, posicao);
		cartas = new ArrayList<Float>();
		criarDeckCartas();
		constante = new Constantes();
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		sorteReves();		
		if((indice % 2)  == 0){
			new Sound(constante.PATH_AUDIO + "caixinha.wav").play();;
			System.out.println(cartas.get(indice));
			jogador.receberTaxa(cartas.get(indice));
			JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "+	cartas.get(indice) + "\n" +
			"Seu novo saldo é: " + jogador.getSaldo(), "Sorte", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "happy.png"));
		}else{
			jogador.pagarTaxa(cartas.get(indice));
			JOptionPane.showMessageDialog(null, "Revés"+"\n" + "Pague: "+cartas.get(indice) +
			"\n" + "Seu novo saldo é: " + jogador.getSaldo(), "Reves", JOptionPane.PLAIN_MESSAGE, new ImageIcon(constante.PATH_IMAGE + "sad.png"));
		}		
	}
	
	public int sorteReves(){
		indice = ((int) ( (Math.random() * 19) + 1 ));
		return indice;

	}
		
	public void criarDeckCartas(){
		
		cartas.add((float) 200);
		cartas.add((float) 100);
		cartas.add((float) 150);
		cartas.add((float) 250);
		cartas.add((float) 220);
		cartas.add((float) 180);
		cartas.add((float) 190);
		cartas.add((float) 240);
		cartas.add((float) 120);
		cartas.add((float) 160);
		cartas.add((float) 180);
		cartas.add((float) 140);
		cartas.add((float) 150);
		cartas.add((float) 200);
		cartas.add((float) 160);
		cartas.add((float) 210);
		cartas.add((float) 200);
		cartas.add((float) 160);
		cartas.add((float) 180);
		cartas.add((float) 260);
	}
	
}
















