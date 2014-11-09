package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import jplay.Sound;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.repositorio.RepositorioLists;
import br.ufc.es.com.BancoImb.utils.Constantes;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialSorteReves extends LogradouroEspecial{
	private RepositorioLists lists;
	private List<Float> cartas;
	private int indice;
	private DesenhaComponentesGraficos desenha;
	
	public LogradouroEspecialSorteReves(String nome, Point posicao, int indice, RepositorioLists lists) {
		super(nome, posicao, indice, lists);
		this.lists = lists;
		cartas = new ArrayList<Float>();
		criarDeckCartas();
		
		desenha = new DesenhaComponentesGraficos();
	}

	public void ativarEfeito(Jogador jogador) {
		indice = sorteReves();
		CasaDoTabuleiro destino = lists.getCasaByIndice(indice);
		
		if(indice > 25){
			
		if((indice % 2)  == 0){
			
			new Sound(new Constantes().CAIXINHA).play();
			jogador.receberTaxa(cartas.get(indice));
			desenha.messageSorte(jogador, cartas.get(indice));

		}else{
			jogador.pagarTaxa(cartas.get(indice));
			desenha.messageReves(jogador, cartas.get(indice));
		}
	}else{
		mover(jogador, destino);
		desenha.messageVaPara(destino);
		}
			
	}
	public int sorteReves(){
		indice = ((int) ( (Math.random() * 39) + 1 ));
		return indice;
	}
	
	public void criarDeckCartas(){
		cartas.add((float) 90);
		cartas.add((float) 70);
		cartas.add((float) 130);
		cartas.add((float) 50);
		cartas.add((float) 200);
		cartas.add((float) 120);
		cartas.add((float) 160);
		cartas.add((float) 40);
		cartas.add((float) 10);
		cartas.add((float) 190);
		cartas.add((float) 40);
		cartas.add((float) 70);
		cartas.add((float) 90);
		cartas.add((float) 100);
		cartas.add((float) 110);
		cartas.add((float) 10);
		cartas.add((float) 40);
		cartas.add((float) 60);
		cartas.add((float) 80);
		cartas.add((float) 160);
		cartas.add((float) 90);
		cartas.add((float) 70);
		cartas.add((float) 130);
		cartas.add((float) 50);
		cartas.add((float) 200);
		cartas.add((float) 120);
		cartas.add((float) 160);
		cartas.add((float) 40);
		cartas.add((float) 10);
		cartas.add((float) 190);
		cartas.add((float) 40);
		cartas.add((float) 70);
		cartas.add((float) 90);
		cartas.add((float) 100);
		cartas.add((float) 110);
		cartas.add((float) 10);
		cartas.add((float) 40);
		cartas.add((float) 60);
		cartas.add((float) 80);
		cartas.add((float) 160);
	}
}
