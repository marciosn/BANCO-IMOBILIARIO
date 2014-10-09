package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class ImpostoDeRenda extends LogradouroEspecial implements ILogradouroEspecial{

	public ImpostoDeRenda(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		jogador.pagarTaxa(200);
		JOptionPane.showMessageDialog(null, "Imposto de renda, voc� precisa pagar seus impostos" + "\n" +
				"Pague 200"+ "\n" +"Seu novo Saldo � " + jogador.getSaldo());
	}

}
