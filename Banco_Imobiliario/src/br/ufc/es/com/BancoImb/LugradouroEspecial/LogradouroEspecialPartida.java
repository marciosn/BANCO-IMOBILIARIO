package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialPartida extends LogradouroEspecial implements IEfeitoCasa{


	public LogradouroEspecialPartida(String nome, Point posicao) {
		super(nome, posicao);
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		jogador.receberTaxa(200);
		JOptionPane.showMessageDialog(null, "Você passou pela casa de partida, merece um prêmio" + "\n" +
		"Receba 200"+ "\n" +"Seu novo Saldo é " + jogador.getSaldo());
	}

}
