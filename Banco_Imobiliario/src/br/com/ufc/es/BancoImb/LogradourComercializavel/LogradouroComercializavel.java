package br.com.ufc.es.BancoImb.LogradourComercializavel;

import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.Jogador;

public class LogradouroComercializavel extends CasaDoTabuleiro{
	private String nome;
	private float valor;
	private Jogador proprietario;
	private float taxa;
	private boolean vendido;
	
	public LogradouroComercializavel(String nome, float valor, float taxa) {
		this.nome = nome;
		this.valor = valor;
		this.vendido = false;
		this.taxa = taxa;
		this.proprietario = null;
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

}
