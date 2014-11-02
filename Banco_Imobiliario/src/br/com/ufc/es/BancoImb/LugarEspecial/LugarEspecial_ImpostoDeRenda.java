package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.IComportamentoLogradouro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_ImpostoDeRenda extends LogradouroEspecial implements IComportamentoLogradouro{


	public LugarEspecial_ImpostoDeRenda(String nome, Point posicao) {
		super(nome, posicao);
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		jogador.pagarTaxa(200);
		JOptionPane.showMessageDialog(null, "Imposto de renda, você precisa pagar seus impostos" + "\n" +
				"Pague 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
	}

}
