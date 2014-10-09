package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class VaParaAPrisao extends LogradouroEspecial implements ILogradouroEspecial{
	public VaParaAPrisao(String nome) {
		super(nome);
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Mover Jogador");
	}

}
