package br.ufc.es.com.BancoImb.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.utils.Constantes;

public class RepositorioLists {
	private List<Jogador> jogadores;
	private List<Jogador> jogadoresAindaJogando;
	private List<CasaDoTabuleiro> tabuleiro;
	private Constantes constante;
	
	public RepositorioLists() {
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		tabuleiro = new ArrayList<CasaDoTabuleiro>();
		constante = new Constantes();
	}
	public void adicionaJogador(Jogador jogador){
		jogadores.add(jogador);
	}
	public void adicionaJogadoresAindaJogando(Jogador jogador){
		jogadores.add(jogador);
	}
	public void adicionaListaDeJogadoresNaCasaDePartida(){
		for (Jogador jogador : this.jogadores) {
			jogadoresAindaJogando.add(jogador);
			tabuleiro.get(constante.INDICE_DA_CASA_DE_PARTIDA).adicionarJogadoresNaListaDaCasa(jogador);
		}
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
