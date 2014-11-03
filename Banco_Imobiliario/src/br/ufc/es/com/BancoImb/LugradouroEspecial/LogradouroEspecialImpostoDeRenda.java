package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialImpostoDeRenda extends LogradouroEspecial implements IEfeitoCasa{


	public LogradouroEspecialImpostoDeRenda(String nome, Point posicao) {
		super(nome, posicao);
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		jogador.pagarTaxa(200);
		JOptionPane.showMessageDialog(null, "Imposto de renda, você precisa pagar seus impostos" + "\n" +
				"Pague 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
	}

}
