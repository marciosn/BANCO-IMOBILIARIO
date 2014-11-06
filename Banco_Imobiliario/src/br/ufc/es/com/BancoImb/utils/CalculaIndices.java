package br.ufc.es.com.BancoImb.utils;

import java.util.List;

import br.ufc.es.com.BancoImb.model.Jogador;

public class CalculaIndices {
	private Constantes constante;
	
	public CalculaIndices() {
		constante = new Constantes();
	}
	
	public int obterIndiceProxCasa(int indiceAtual, int resultDado) {
		int indiceProximaCasa;
		indiceProximaCasa = indiceAtual + resultDado;
		if(indiceProximaCasa > (constante.QUANTIDADE_DE_CASAS_DO_TABULEIRO - 1)){
			int percent = indiceProximaCasa % constante.QUANTIDADE_DE_CASAS_DO_TABULEIRO;
			indiceProximaCasa = percent;
		}
		return indiceProximaCasa;
	}
	public int obterIndiceProxJogador(int indiceJogador, List<Jogador> jogadores) {
		int indiceProxJogador = 0, temp = 0;
		indiceProxJogador = indiceJogador + 1;
		if (indiceProxJogador > jogadores.size() - 1) {
			temp = indiceProxJogador % jogadores.size();
			indiceProxJogador = temp;
		}
		return indiceProxJogador;
		
	}
}
