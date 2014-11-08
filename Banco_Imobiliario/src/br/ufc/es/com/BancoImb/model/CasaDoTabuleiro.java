package br.ufc.es.com.BancoImb.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;

public class CasaDoTabuleiro implements IEfeitoCasa{
	private String nome;
	private List<Jogador> jogadoresNaCasa;
	private Point posicao;
	
	public CasaDoTabuleiro() {
		jogadoresNaCasa = new ArrayList<Jogador>();
	}

	public void adicionarJogadoresNaListaDaCasa(Jogador jogador){
		jogadoresNaCasa.add(jogador);
	}
	
	public List<Jogador> getJogadoresNaCasa() {
		return jogadoresNaCasa;
	}

	public void setJogadoresNaCasa(List<Jogador> jogadoresNaCasa) {
		this.jogadoresNaCasa = jogadoresNaCasa;
	}
	public void removerJogadoresDaListaDaCasa(Jogador jogador){
		jogadoresNaCasa.remove(jogador);
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		// TODO Auto-generated method stub		
	}
	public String getNome(){
		return nome;
	}

	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}

}
