package br.com.ufc.es.BancoImb.model;

public class LogradouroEspecial extends Casa{
	private String nome;
	
	public LogradouroEspecial(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}