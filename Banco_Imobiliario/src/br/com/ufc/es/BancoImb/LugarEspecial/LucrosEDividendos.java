package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LucrosEDividendos extends LogradouroEspecial implements ILogradouroEspecial{

	public LucrosEDividendos(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		jogador.receberTaxa(200);
		JOptionPane.showMessageDialog(null, "Lucros ou Dividendos" + "\n" +
				"Receba 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
		
	}

}
