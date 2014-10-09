package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_ParadaLivre extends LogradouroEspecial implements ILogradouroEspecial{

	public LugarEspecial_ParadaLivre(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Parada Livre" + "\n" + "Não precisa pagar impostos!");
		
	}

}
