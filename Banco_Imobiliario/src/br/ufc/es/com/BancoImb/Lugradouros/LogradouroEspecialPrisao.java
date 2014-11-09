package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.repositorio.RepositorioLists;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialPrisao extends LogradouroEspecial{
	private RepositorioLists lists;
	private DesenhaComponentesGraficos desenha;

	public LogradouroEspecialPrisao(String nome, Point posicao, int indice, RepositorioLists lists) {
		super(nome, posicao, indice, lists);
		this.lists = lists;
		desenha = new DesenhaComponentesGraficos();
	}

	public void ativarEfeito(Jogador jogador) {
		jogador.pagarTaxa(100);
		desenha.messageVoceParouNaPrisao(jogador);
		lists.adicionarJogadoresPresos(jogador);
	}

}
