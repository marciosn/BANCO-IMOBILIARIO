package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialParadaLivre extends LogradouroEspecial{
	private DesenhaComponentesGraficos desenha;
	
	public LogradouroEspecialParadaLivre(String nome, Point posicao, int indice) {
		super(nome, posicao, indice);
		desenha = new DesenhaComponentesGraficos();
	}

	public void ativarEfeito(Jogador jogador) {
		desenha.messageParadaLivre(jogador);
	}

}
