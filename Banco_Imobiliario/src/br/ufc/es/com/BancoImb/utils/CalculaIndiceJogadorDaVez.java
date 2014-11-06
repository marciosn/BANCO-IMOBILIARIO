package br.ufc.es.com.BancoImb.utils;

import java.util.List;

import br.ufc.es.com.BancoImb.model.Jogador;

public class CalculaIndiceJogadorDaVez {
	public int calculaIndiceProximoJogador(int indiceJogador, List<Jogador> jogadores) {
		int indiceProx = 0, temp = 0;
		indiceProx = indiceJogador + 1;
		if (indiceProx > jogadores.size() - 1) {
			temp = indiceProx % jogadores.size();
			indiceProx = temp;
		}
		return indiceProx;
		
	}

}
