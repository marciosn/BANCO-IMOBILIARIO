package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialPartida extends LogradouroEspecial{
	public LogradouroEspecialPartida(String nome, Point posicao, int indice) {
		super(nome, posicao, indice);
		desenha = new DesenhaComponentesGraficos();
	}

	private DesenhaComponentesGraficos desenha;

	/*public LogradouroEspecialPartida(String nome, Point posicao) {
		super(nome, posicao);
		desenha = new DesenhaComponentesGraficos();
	}*/
	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(200);
		desenha.messageCasaDePartida(jogador, 200);
	}

}
