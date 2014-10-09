package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class ParadaLivre extends LogradouroEspecial implements ILogradouroEspecial{

	public ParadaLivre(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Parada Livre" + "\n" + "Não precisa pagar impostos!");
		
	}

}
