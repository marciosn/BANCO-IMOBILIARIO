package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import javax.swing.JOptionPane;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialParadaLivre extends LogradouroEspecial implements IEfeitoCasa{


	public LogradouroEspecialParadaLivre(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		JOptionPane.showMessageDialog(null, "Parada Livre" + "\n" + "Não precisa pagar impostos!");
		
	}

}
