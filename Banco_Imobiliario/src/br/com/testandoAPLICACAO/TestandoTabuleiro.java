package br.com.testandoAPLICACAO;

import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class TestandoTabuleiro {
	public static void main(String[] args) {
		Tabuleiro tab = new Tabuleiro();
		tab.adiconarJogadoresACasa(0, new Jogador("marcio", new ContaBancaria(100000)));
		Casa origem = tab.getCasaPeloIndice(0);
		Casa destino = tab.getCasaPeloIndice(39);
		Jogador j = tab.getJogadorASerMovido(0, origem);
		
		System.out.println("Nome: "+j.getNome());
		System.out.println("Saldo: "+j.getSaldo());
		
		System.out.println(origem.getNome());
		System.out.println(origem.getNumJogadoresCasa());
		
		tab.moverJogador(j, origem, destino);
		
	}

}
