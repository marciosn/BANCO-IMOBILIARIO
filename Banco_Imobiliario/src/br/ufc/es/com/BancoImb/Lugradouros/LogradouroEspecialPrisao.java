package br.ufc.es.com.BancoImb.Lugradouros;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;

public class LogradouroEspecialPrisao extends LogradouroEspecial{
	private RepositorioLists lists;

	public LogradouroEspecialPrisao(String nome, Point posicao, int indice) {
		super(nome, posicao, indice);
		// TODO Auto-generated constructor stub
	}
	
	public LogradouroEspecialPrisao(String nome, Point posicao, int indice, RepositorioLists lists) {
		super(nome, posicao, indice, lists);
		this.lists = lists;
	}

	/*public LogradouroEspecialPrisao(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}*/
	public void ativarEfeito(Jogador jogador) {
		jogador.pagarTaxa(100);
		JOptionPane.showMessageDialog(null, "Você parou na casa vá para a prisão" 
				+ "\n"+"Vá para a prisao" 
				+ "\n"+ "Pague uma multa de R$ 100"
				+ "\n"+"Passe a vez de jogar"
				+ "\n"+ "Seu novo Saldo é R$ " 
				+ jogador.getSaldo());
		lists.getJogadoresPresos().add(jogador);
	}

}
