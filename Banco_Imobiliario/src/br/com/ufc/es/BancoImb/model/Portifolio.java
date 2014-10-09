package br.com.ufc.es.BancoImb.model;

import br.com.ufc.es.BancoImb.LogradourComercializavel.Jogador;

public class Portifolio {
	
	public void exibeFormulario(Jogador jogador){
		System.out.println("|-------------------------------------|");
		System.out.println("| Nome:" + jogador.getNome()+"        |");
		System.out.println("| Nome:" + jogador.getSaldo()+"       |");
		System.out.println("|                                     |");
		System.out.println("|                                     |");
		System.out.println("|                                     |");
		System.out.println("|-------------------------------------|");
		
	}

}
