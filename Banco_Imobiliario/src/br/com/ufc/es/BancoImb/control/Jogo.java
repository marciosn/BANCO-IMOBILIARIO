package br.com.ufc.es.BancoImb.control;

import br.com.ufc.es.BancoImb.model.Dado;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class Jogo {
	public static void main(String[] args) {
		Dado dado = new Dado();
		System.out.println(dado.getJogada());
	}

}
