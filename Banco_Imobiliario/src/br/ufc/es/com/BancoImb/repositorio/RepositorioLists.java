package br.ufc.es.com.BancoImb.repositorio;

import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.utils.Constantes;

public class RepositorioLists {
	private List<Jogador> jogadores;
	private List<Jogador> jogadoresAindaJogando;
	private List<Jogador> jogadoresPresos;
	private List<CasaDoTabuleiro> tabuleiro;
	
	public RepositorioLists() {
		jogadores = new ArrayList<Jogador>();
		jogadoresAindaJogando = new ArrayList<Jogador>();
		tabuleiro = new ArrayList<CasaDoTabuleiro>();
		jogadoresPresos = new ArrayList<Jogador>();
	}
	public void adicionaJogador(Jogador jogador){
		jogadores.add(jogador);
	}
	public void adicionaJogadoresAindaJogando(Jogador jogador){
		jogadores.add(jogador);
	}
	public void adicionarJogadoresPresos(Jogador jogador){
		jogadoresPresos.add(jogador);
	}
	public void adicionaListaDeJogadoresNaCasaDePartida(){
		for (Jogador jogador : this.jogadores) {
			jogadoresAindaJogando.add(jogador);
			tabuleiro.get(new Constantes().INDICE_DA_CASA_DE_PARTIDA).adicionarJogadoresNaListaDaCasa(jogador);
		}
	}
	public void removerDeJogadoresAindaJogando(Jogador jogador){
		jogadoresAindaJogando.remove(jogador);
	}
	public CasaDoTabuleiro getCasaByIndice(int indice) {
		return tabuleiro.get(indice);
	}
	public Jogador getPrimeiroJogadorDaLista(){
		return jogadores.get(new Constantes().JOGADOR_NA_PRIMEIRA_POSICAO_DA_LISTA);
	}
	public Jogador getJogadorByID(int id){
		Jogador jogador = null;
		for (int i = 0; i < tabuleiro.size(); i++) {
			for (Jogador jog : tabuleiro.get(i).getJogadoresNaCasa()) {
				if (jog.getID() == id) {
					jogador = jog;
				}
			}
		}	 
		return jogador;
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
	public List<Jogador> getJogadoresPresos() {
		return jogadoresPresos;
	}
	public void setJogadoresPresos(List<Jogador> jogadoresPresos) {
		this.jogadoresPresos = jogadoresPresos;
	}

}
