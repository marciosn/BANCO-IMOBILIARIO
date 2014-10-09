package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.es.BancoImb.interfaces.IJogador;

public class Jogador{
	private static int ultimoID = 0;
	private int id;
	private String nome;
	private ContaBancaria conta;
	private List<CasaDoTabuleiro> meusLogradouros;
	private int posicaoJogador;
	
	public Jogador(String nome, ContaBancaria conta) {
		this.nome = nome;
		this.conta = conta;
		meusLogradouros = new ArrayList<CasaDoTabuleiro>();
		this.id = ultimoID++;
		this.posicaoJogador = 0;
	}
	public void comprar(CasaDoTabuleiro logradouro) {
		logradouro.setProprietario(this);
		logradouro.setVendido(true);
		conta.sacar(logradouro.getValor());
		adicionarNovoLogradouroALista(logradouro);
	}
	public void pagarTaxa(CasaDoTabuleiro logradouro) {
		conta.sacar(logradouro.getTaxa());
	}
	public void pagarTaxa(float taxa) {
		conta.sacar(taxa);
	}
	public void receberTaxa(CasaDoTabuleiro logradouro) {
		conta.depositar(logradouro.getTaxa());
		
	}
	public void receberTaxa(float taxa) {
		conta.depositar(taxa);
		
	}
	public void adicionarNovoLogradouroALista(CasaDoTabuleiro logradouro){
		meusLogradouros.add(logradouro);
	}
	public int quantidadeLogradouros(){
		return meusLogradouros.size();
	}
	public float getSaldo(){
		return conta.getSaldo();
	}
	public String getNome(){
		return nome;
	}
	public int getID(){
		return id;
	}
	public int getPosicaoJogador() {
		return posicaoJogador;
	}
	public void setPosicaoJogador(int posicaoJogador) {
		this.posicaoJogador = posicaoJogador;
	}
	
}
