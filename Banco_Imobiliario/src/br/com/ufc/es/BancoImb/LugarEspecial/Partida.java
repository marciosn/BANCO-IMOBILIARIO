package br.com.ufc.es.BancoImb.LugarEspecial;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;
import br.com.ufc.es.BancoImb.model.Jogador;

public class Partida extends LogradouroEspecial implements ILogradouroEspecial{

	public Partida(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		jogador.receberTaxa(200);
		JOptionPane.showMessageDialog(null, "Você está passando pela casa de partida, merece um prêmio" + "\n" +
		"Receba 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
	}

}
