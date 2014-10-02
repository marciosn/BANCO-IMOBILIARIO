package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.es.BancoImb.interfaces.IJogador;

public class Jogador implements IJogador{
	private String nome;
	private ContaBancaria conta;
	private List<LogradouroComercializavel> meusLogradouros;	
	
	public Jogador(String nome, ContaBancaria conta) {
		this.nome = nome;
		this.conta = conta;
		meusLogradouros = new ArrayList<LogradouroComercializavel>();
	}
	@Override
	public void comprar(LogradouroComercializavel logradouro) {
		logradouro.setProprietario(this);
		logradouro.setVendido(true);
		conta.sacar(logradouro.getValor());
		adicionarNovoLogradouroALista(logradouro);
	}
	@Override
	public void pagarTaxa(LogradouroComercializavel logradouro) {
		conta.sacar(logradouro.getTaxa());
	}
	@Override
	public void receberTaxa(LogradouroComercializavel logradouro) {
		conta.depositar(logradouro.getTaxa());
		
	}
	public void adicionarNovoLogradouroALista(LogradouroComercializavel logradouro){
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
}
