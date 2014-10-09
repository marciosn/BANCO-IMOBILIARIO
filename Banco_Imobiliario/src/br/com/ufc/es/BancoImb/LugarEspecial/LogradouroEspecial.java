package br.com.ufc.es.BancoImb.LugarEspecial;

import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;

public class LogradouroEspecial extends CasaDoTabuleiro{
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
