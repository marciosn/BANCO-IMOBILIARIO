package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialLucrosEDividendos extends LogradouroEspecial implements IEfeitoCasa{


	public LogradouroEspecialLucrosEDividendos(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(200);
		JOptionPane.showMessageDialog(null, "Lucros ou Dividendos" + "\n" +
				"Receba 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
		
	}

}
