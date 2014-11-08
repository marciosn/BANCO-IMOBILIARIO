package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialVaParaAPrisao extends LogradouroEspecial{

	public LogradouroEspecialVaParaAPrisao(String nome, Point posicao) {
		super(nome, posicao);
	}
	public void ativarEfeito(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
		//constante.getTabuleiro().moverJogador(jogador, prisao);
		//desenha.moverPecaJogador(jogador, prisao);
	}

}
