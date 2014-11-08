package br.ufc.es.com.BancoImb.model;

import java.awt.Point;


public class LogradouroEspecial extends CasaDoTabuleiro{
	private String nome;
	private Point posicao;
	private int indice;
	
	public LogradouroEspecial(String nome, Point posicao, int indice) {
		this.nome = nome;
		this.posicao = posicao;
		this.indice = indice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Point getPosicao() {
		return posicao;
	}
	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	
}
