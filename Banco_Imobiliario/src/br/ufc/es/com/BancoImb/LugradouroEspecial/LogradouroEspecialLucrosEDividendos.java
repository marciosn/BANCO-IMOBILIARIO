package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialLucrosEDividendos extends LogradouroEspecial{
	private DesenhaComponentesGraficos desenha;

	public LogradouroEspecialLucrosEDividendos(String nome, Point posicao) {
		super(nome, posicao);
		desenha = new DesenhaComponentesGraficos();
	}
	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(200);
		desenha.messageLucrosDividendos(jogador, 200);		
	}

}
