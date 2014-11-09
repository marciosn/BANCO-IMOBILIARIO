package br.ufc.es.com.BancoImb.model;

import java.awt.Point;

import br.ufc.es.com.BancoImb.repositorio.RepositorioLists;


public class LogradouroEspecial extends CasaDoTabuleiro{
	private String nome;
	private Point posicao;
	private int indice;
	private RepositorioLists lists;
	
	public LogradouroEspecial(String nome, Point posicao, int indice) {
		this.nome = nome;
		this.posicao = posicao;
		this.indice = indice;
	}
	public LogradouroEspecial(String nome, Point posicao, int indice, RepositorioLists lists) {
		this.nome = nome;
		this.posicao = posicao;
		this.indice = indice;
		this.lists = lists;
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
