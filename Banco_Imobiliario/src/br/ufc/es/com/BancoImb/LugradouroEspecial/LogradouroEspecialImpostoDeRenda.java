package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialImpostoDeRenda extends LogradouroEspecial{
	private DesenhaComponentesGraficos desenha;

	public LogradouroEspecialImpostoDeRenda(String nome, Point posicao) {
		super(nome, posicao);
		desenha = new DesenhaComponentesGraficos();
	}
	public void ativarEfeito(Jogador jogador) {
		jogador.pagarTaxa(200);
		desenha.messageImpostoDeRenda(jogador, 200);
	}

}
