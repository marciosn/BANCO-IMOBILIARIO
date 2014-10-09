package br.com.ufc.es.BancoImb.LugarEspecial;

import br.com.ufc.es.BancoImb.LogradourComercializavel.Jogador;
import br.com.ufc.es.BancoImb.interfaces.ILogradouroEspecial;

public class Partida extends LogradouroEspecial implements ILogradouroEspecial{

	public Partida(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efeitoDaCasa(Jogador jogador) {
		jogador.receberTaxa(200);
		
	}

}
