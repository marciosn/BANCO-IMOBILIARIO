package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class VaParaAPrisao extends LogradouroEspecial implements ILogradouroEspecial{

	public VaParaAPrisao(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
		
	}

}
