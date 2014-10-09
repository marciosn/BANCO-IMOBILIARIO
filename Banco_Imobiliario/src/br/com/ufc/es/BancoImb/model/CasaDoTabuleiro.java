package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

public class CasaDoTabuleiro {
	String nome;
	List<Jogador> jogadoresNaCasa;
	Jogador proprietario;
	boolean vendido;
	float valor;
	float taxa;
	
	public CasaDoTabuleiro() {
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
	
	public void executarComportamento(Jogador jogador){
	}
	
	public String getNome(){
		return nome;
	}

	public Jogador getProprietario() {
		return proprietario;
	}

	public void setProprietario(Jogador proprietario) {
		this.proprietario = proprietario;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
