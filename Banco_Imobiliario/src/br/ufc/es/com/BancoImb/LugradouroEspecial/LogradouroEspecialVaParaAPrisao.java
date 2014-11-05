package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.constantes.Constantes;
import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class LogradouroEspecialVaParaAPrisao extends LogradouroEspecial implements IEfeitoCasa{
	private LogradouroEspecialPrisao prisao;
	private DesenhaComponentesGraficos desenha;
	private Constantes constante;

	public LogradouroEspecialVaParaAPrisao(String nome, Point posicao) {
		super(nome, posicao);
		constante = new Constantes();
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
		constante.getTabuleiro().moverJogador(jogador, prisao);
		desenha.moverPecaJogador(prisao, jogador);
	}

}
