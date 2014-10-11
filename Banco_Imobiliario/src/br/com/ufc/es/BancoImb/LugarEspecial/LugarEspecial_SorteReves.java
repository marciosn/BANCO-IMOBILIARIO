package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jplay.Sound;
import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_SorteReves extends LogradouroEspecial implements ILogradouroEspecial{
	
	private List<Float> cartas;
	private int indice;
	
	public LugarEspecial_SorteReves(String nome, Point posicao) {
		super(nome, posicao);
		cartas = new ArrayList<Float>();
		criarDeckCartas();
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		sorteReves();		
		if((indice % 2)  == 0){
			new Sound("caixinha.wav").play();;
			System.out.println(cartas.get(indice));
			jogador.receberTaxa(cartas.get(indice));
			JOptionPane.showMessageDialog(null, "Sorte"+ "\n" + "Receba: "+
			cartas.get(indice) + "\n" +
			"Seu novo saldo �: " + jogador.getSaldo());
		}else{
			System.out.println("N�o passou no IF");
			jogador.pagarTaxa(cartas.get(indice));
			JOptionPane.showMessageDialog(null, "Rev�s"+"\n" + "Pague: "+
			cartas.get(indice) +
			"\n" + "Seu novo saldo �: " + jogador.getSaldo());
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
















