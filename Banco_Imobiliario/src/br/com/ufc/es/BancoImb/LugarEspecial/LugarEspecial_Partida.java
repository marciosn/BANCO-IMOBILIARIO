package br.com.ufc.es.BancoImb.LugarEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.com.ufc.es.BancoImb.interfaces.IComportamentoLogradouro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LugarEspecial_Partida extends LogradouroEspecial implements IComportamentoLogradouro{


	public LugarEspecial_Partida(String nome, Point posicao) {
		super(nome, posicao);
	}

	@Override
	public void executarComportamento(Jogador jogador) {
		jogador.receberTaxa(200);
		JOptionPane.showMessageDialog(null, "Voc� passou pela casa de partida, merece um pr�mio" + "\n" +
		"Receba 200"+ "\n" +"Seu novo Saldo � " + jogador.getSaldo());
	}

}
