package br.ufc.es.com.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

public class Jogador{
	private static int ultimoID = 0;
	private int id;
	private String nome;
	private ContaBancaria conta;
	private List<LogradouroComercializavel> meusLogradouros;
	private int posicaoAtualJogador;
	private PecaJogador peca;
	
	public Jogador(String nome, ContaBancaria conta, PecaJogador peca) {
		this.nome = nome;
		this.conta = conta;
		meusLogradouros = new ArrayList<LogradouroComercializavel>();
		this.id = ultimoID++;
		this.posicaoAtualJogador = 0;
		this.peca = peca;
	}
	public void comprar(LogradouroComercializavel casa) {
		casa.setProprietario(this);
		casa.setVendido(true);
		conta.sacar(casa.getValor());
		adicionarLogradouroAOPortifolio(casa);
	}
	public void pagarTaxa(float taxa) {
		conta.sacar(taxa);
	}
	public void receberTaxa(float taxa) {
		conta.depositar(taxa);
	}
	public void adicionarLogradouroAOPortifolio(LogradouroComercializavel logradouro){
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
	public int getPosicaoAtualJogador() {
		return posicaoAtualJogador;
	}
	public void setPosicaoAtualJogador(int posicaoAtualJogador) {
		this.posicaoAtualJogador = posicaoAtualJogador;
	}
	public PecaJogador getPeca() {
		return peca;
	}
	public List<LogradouroComercializavel> getMeusLogradouros() {
		return meusLogradouros;
	}
	public void setMeusLogradouros(List<LogradouroComercializavel> meusLogradouros) {
		this.meusLogradouros = meusLogradouros;
	}
	
}
