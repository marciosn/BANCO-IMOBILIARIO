package br.com.ufc.es.BancoImb.control;

import java.util.List;

import br.com.ufc.es.BancoImb.model.Jogador;

public class MudarJogadorNaVez {
	public int mudarVezDeJogar(int indiceJogador, List<Jogador> jogadores) {
		int indiceProx = 0, temp = 0;
		indiceProx = indiceJogador + 1;
		if (indiceProx > jogadores.size() - 1) {
			temp = indiceProx % jogadores.size();
			indiceProx = temp;
		}
		return indiceProx;
		
	}

}
