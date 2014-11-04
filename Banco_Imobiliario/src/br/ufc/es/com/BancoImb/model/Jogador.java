package br.ufc.es.com.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.interfaces.IJogador;

public class Jogador implements IJogador{
	private static int ultimoID = 0;
	private int id;
	private String nome;
	private ContaBancaria conta;
	private List<CasaDoTabuleiro> meusLogradouros;
	private int posicaoAtualJogador;
	private PecaJogador peca;
	
	public Jogador(String nome, ContaBancaria conta, PecaJogador peca) {
		this.nome = nome;
		this.conta = conta;
		meusLogradouros = new ArrayList<CasaDoTabuleiro>();
		this.id = ultimoID++;
		this.posicaoAtualJogador = 0;
		this.peca = peca;
	}
	@Override
	public void comprar(CasaDoTabuleiro logradouro) {
		logradouro.setProprietario(this);
		logradouro.setVendido(true);
		conta.sacar(logradouro.getValor());
		adicionarLogradouroAOPortifolio(logradouro);
	}
	@Override
	public void pagarTaxa(CasaDoTabuleiro logradouro) {
		conta.sacar(logradouro.getTaxa());
	}
	@Override
	public void pagarTaxa(float taxa) {
		conta.sacar(taxa);
	}
	@Override
	public void receberTaxa(CasaDoTabuleiro logradouro) {
		conta.depositar(logradouro.getTaxa());
	}
	@Override
	public void receberTaxa(float taxa) {
		conta.depositar(taxa);
	}
	@Override
	public void adicionarLogradouroAOPortifolio(CasaDoTabuleiro logradouro){
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
	public List<CasaDoTabuleiro> getMeusLogradouros() {
		return meusLogradouros;
	}
	public void setMeusLogradouros(List<CasaDoTabuleiro> meusLogradouros) {
		this.meusLogradouros = meusLogradouros;
	}
	
}
