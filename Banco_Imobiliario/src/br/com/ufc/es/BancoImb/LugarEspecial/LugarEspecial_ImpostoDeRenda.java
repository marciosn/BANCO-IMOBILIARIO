package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_ImpostoDeRenda extends LogradouroEspecial implements ILogradouroEspecial{

	public LugarEspecial_ImpostoDeRenda(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		jogador.pagarTaxa(200);
		JOptionPane.showMessageDialog(null, "Imposto de renda, você precisa pagar seus impostos" + "\n" +
				"Pague 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
	}

}
