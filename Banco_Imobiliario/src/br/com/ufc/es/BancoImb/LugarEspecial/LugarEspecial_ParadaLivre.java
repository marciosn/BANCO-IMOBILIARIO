package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.IComportamentoLogradouro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_ParadaLivre extends LogradouroEspecial implements IComportamentoLogradouro{


	public LugarEspecial_ParadaLivre(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Parada Livre" + "\n" + "Não precisa pagar impostos!");
		
	}

}
