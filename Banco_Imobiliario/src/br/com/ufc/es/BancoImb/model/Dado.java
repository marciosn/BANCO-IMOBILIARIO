package br.com.ufc.es.BancoImb.model;

public class Dado {
	private int jogada;
	
	public Dado() {
		geraJogada();
	}
	
	public int getJogada(){
		return jogada;
	}
	public void geraJogada(){
		jogada = (int) ( (Math.random() * 6) + 1 );
	}

}
