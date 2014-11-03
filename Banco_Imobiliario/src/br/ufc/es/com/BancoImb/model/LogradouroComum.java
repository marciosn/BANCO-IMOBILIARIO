package br.ufc.es.com.BancoImb.model;

import java.awt.Point;


public class LogradouroComum extends CasaDoTabuleiro{
	private String nome;
	private float valor;
	private Jogador proprietario;
	private float taxa;
	private boolean vendido;
	private Point posicao;
	
	public LogradouroComum(String nome, float valor, float taxa, Point posicao) {
		this.nome = nome;
		this.valor = valor;
		this.vendido = false;
		this.taxa = taxa;
		this.proprietario = null;
		this.posicao = posicao;
	}

	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}
	public Jogador getProprietario() {
		return proprietario;
	}
	public void setProprietario(Jogador proprietario) {
		this.proprietario = proprietario;
	}
	public float getTaxa() {
		return taxa;
	}
	public boolean isVendido() {
		return vendido;
	}
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}

}
