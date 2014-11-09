package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;

public class LogradouroEspecialVaParaAPrisao extends LogradouroEspecial{
	private RepositorioLists lists;
	
	public LogradouroEspecialVaParaAPrisao(String nome, Point posicao,	int indice) {
		super(nome, posicao, indice);
	}
	public LogradouroEspecialVaParaAPrisao(String nome, Point posicao,	int indice, RepositorioLists lists) {
		super(nome, posicao, indice, lists);
		this.lists = lists;
	}

	public void ativarEfeito(Jogador jogador) {
		CasaDoTabuleiro prisao = lists.getTabuleiro().get(30);
		jogador.pagarTaxa(100);
		JOptionPane.showMessageDialog(null, "Você parou na casa vá para a prisão" 
				+"\n"+"Vá para a prisao" 
				+ "\n"+ "Pague uma multa de R$ 100" 
				+ "\n"	+ "Seu novo Saldo é R$ " 
				+ jogador.getSaldo());
		
		mover(jogador, prisao);
		lists.getJogadoresPresos().add(jogador);
	}
	
}
