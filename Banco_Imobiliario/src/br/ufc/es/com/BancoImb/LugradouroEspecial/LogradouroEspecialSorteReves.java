package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import jplay.Sound;
import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.utils.Constantes;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialSorteReves extends LogradouroEspecial implements IEfeitoCasa{
	
	private List<Float> cartas;
	private int indice;
	private Constantes constante;
	private DesenhaComponentesGraficos desenha;
	
	public LogradouroEspecialSorteReves(String nome, Point posicao) {
		super(nome, posicao);
		cartas = new ArrayList<Float>();
		criarDeckCartas();
		constante = new Constantes();
		desenha = new DesenhaComponentesGraficos();
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		sorteReves();		
		if((indice % 2)  == 0){
			new Sound(constante.CAIXINHA).play();;
			jogador.receberTaxa(cartas.get(indice));
			desenha.messageSorte(jogador, cartas.get(indice));
		}else{
			jogador.pagarTaxa(cartas.get(indice));
			desenha.messageReves(jogador, cartas.get(indice));
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
















