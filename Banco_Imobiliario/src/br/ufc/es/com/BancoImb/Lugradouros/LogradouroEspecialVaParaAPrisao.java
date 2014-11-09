package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.repositorio.RepositorioLists;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialVaParaAPrisao extends LogradouroEspecial{
	private RepositorioLists lists;
	private DesenhaComponentesGraficos desenha;

	public LogradouroEspecialVaParaAPrisao(String nome, Point posicao,	int indice, RepositorioLists lists) {
		super(nome, posicao, indice, lists);
		this.lists = lists;
		desenha = new DesenhaComponentesGraficos();
	}

	public void ativarEfeito(Jogador jogador) {
		CasaDoTabuleiro prisao = lists.getTabuleiro().get(30);
		
		jogador.pagarTaxa(100);
		desenha.messageCasaVaParaPrisa(jogador);
		mover(jogador, prisao);
		lists.adicionarJogadoresPresos(jogador);
	}
	
}
