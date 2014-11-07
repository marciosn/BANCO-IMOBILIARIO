package br.ufc.es.com.BancoImb.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;

public class CasaDoTabuleiro implements IEfeitoCasa{
	private String nome;
	private List<Jogador> jogadoresNaCasa;
	private Jogador proprietario;
	private boolean vendido;
	private float valor;
	private float taxa;
	private Point posicao;
	
	public CasaDoTabuleiro() {
		jogadoresNaCasa = new ArrayList<Jogador>();
	}

	public void adicionarJogadoresNaListaDaCasa(Jogador jogador){
		jogadoresNaCasa.add(jogador);
	}
	
	public List<Jogador> getJogadoresNaCasa() {
		return jogadoresNaCasa;
	}

	public void setJogadoresNaCasa(List<Jogador> jogadoresNaCasa) {
		this.jogadoresNaCasa = jogadoresNaCasa;
	}
	public void removerJogadoresDaListaDaCasa(Jogador jogador){
		jogadoresNaCasa.remove(jogador);
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		// TODO Auto-generated method stub		
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

	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}

}
