package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.IComportamentoLogradouro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_VaParaAPrisao extends LogradouroEspecial implements IComportamentoLogradouro{


	public LugarEspecial_VaParaAPrisao(String nome, Point posicao) {
		super(nome, posicao);
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
	}

}
