package br.ufc.es.com.BancoImb.model;

public class ContaBancaria {
	
	private float saldo;
	
	public ContaBancaria(float saldo) {
		this.saldo = saldo;
	}
	
	public void depositar(float valor){
		this.saldo = saldo + valor;
	}
	public void sacar(float valor){
		this.saldo = saldo - valor;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
}
