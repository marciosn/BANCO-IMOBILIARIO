package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_VaParaAPrisao extends LogradouroEspecial implements ILogradouroEspecial{


	public LugarEspecial_VaParaAPrisao(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
	}

}
