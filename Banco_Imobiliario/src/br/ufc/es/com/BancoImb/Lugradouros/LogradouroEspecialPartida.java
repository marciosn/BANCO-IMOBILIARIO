package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.utils.Constantes;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialPartida extends LogradouroEspecial{
	private DesenhaComponentesGraficos desenha;
	
	public LogradouroEspecialPartida(String nome, Point posicao, int indice) {
		super(nome, posicao, indice);
		desenha = new DesenhaComponentesGraficos();
	}

	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(new Constantes().BONUS_CASA_DE_PARTIDA);
		desenha.messageCasaDePartida(jogador, new Constantes().BONUS_CASA_DE_PARTIDA);
	}

}
