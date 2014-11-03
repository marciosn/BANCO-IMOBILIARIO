package br.ufc.es.com.BancoImb.LugradouroEspecial;

import java.awt.Point;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.LogradouroEspecial;

public class LogradouroEspecialPrisao extends LogradouroEspecial implements IEfeitoCasa{


	public LogradouroEspecialPrisao(String nome, Point posicao) {
		super(nome, posicao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

}
