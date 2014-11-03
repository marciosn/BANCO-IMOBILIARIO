package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialVaParaAPrisao extends LogradouroEspecial implements IEfeitoCasa{


	public LogradouroEspecialVaParaAPrisao(String nome, Point posicao) {
		super(nome, posicao);
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
	}

}
