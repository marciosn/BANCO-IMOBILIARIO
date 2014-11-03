package br.ufc.es.com.BancoImb.model;

import java.awt.Point;


public class LogradouroEspecial extends CasaDoTabuleiro{
	private String nome;
	private Point posicao;
	
	public LogradouroEspecial(String nome, Point posicao) {
		this.nome = nome;
		this.posicao = posicao;
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
	
}
