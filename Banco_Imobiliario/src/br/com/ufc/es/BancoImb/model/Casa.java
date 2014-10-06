package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

public class Casa {
	String nome;
	List<Jogador> jogadoresNaCasa;
	
	public Casa() {
		jogadoresNaCasa = new ArrayList<Jogador>();
	}

	public void adicionarJogadoresNaLista(Jogador jogador){
		jogadoresNaCasa.add(jogador);
	}
	
	public int getNumJogadoresCasa(){
		return jogadoresNaCasa.size();
	}
	
	public List<Jogador> getJogadoresNaCasa() {
		return jogadoresNaCasa;
	}

	public void setJogadoresNaCasa(List<Jogador> jogadoresNaCasa) {
		this.jogadoresNaCasa = jogadoresNaCasa;
	}
	public void removerJogador(Jogador jogador){
		jogadoresNaCasa.remove(jogador);
	}
	public String getNome(){
		return nome;
	}

}
