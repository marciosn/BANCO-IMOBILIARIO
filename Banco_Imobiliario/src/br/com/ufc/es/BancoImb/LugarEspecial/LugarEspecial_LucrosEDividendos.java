package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.IComportamentoLogradouro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_LucrosEDividendos extends LogradouroEspecial implements IComportamentoLogradouro{


	public LugarEspecial_LucrosEDividendos(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		jogador.receberTaxa(200);
		JOptionPane.showMessageDialog(null, "Lucros ou Dividendos" + "\n" +
				"Receba 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
		
	}

}
