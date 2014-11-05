package br.ufc.es.com.BancoImb.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public class Repositorio {
	private List<Jogador> jogadores;
	private List<Jogador> jogadoresAindaJogando;
	private List<CasaDoTabuleiro> tabuleiro;
	
	public Repositorio() {
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		tabuleiro = new ArrayList<CasaDoTabuleiro>();
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Jogador> getJogadoresAindaJogando() {
		return jogadoresAindaJogando;
	}

	public void setJogadoresAindaJogando(List<Jogador> jogadoresAindaJogando) {
		this.jogadoresAindaJogando = jogadoresAindaJogando;
	}

	public List<CasaDoTabuleiro> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	

}
