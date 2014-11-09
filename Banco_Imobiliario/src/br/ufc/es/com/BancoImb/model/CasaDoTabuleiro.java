package br.ufc.es.com.BancoImb.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.interfaces.ICasaTabuleiro;
import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;

public class CasaDoTabuleiro implements IEfeitoCasa, ICasaTabuleiro{
	private String nome;
	private List<Jogador> jogadoresNaCasa;
	private int indice;
	private Point posicao;
	
	public CasaDoTabuleiro() {
		jogadoresNaCasa = new ArrayList<Jogador>();
	}

	@Override
	public void ativarEfeito(Jogador jogador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionarJogadoresNaListaDaCasa(Jogador jogador) {
		// TODO Auto-generated method stub
		jogadoresNaCasa.add(jogador);
	}

	@Override
	public void removerJogadoresDaListaDaCasa(Jogador jogador) {
		// TODO Auto-generated method stub
		jogadoresNaCasa.remove(jogador);
	}
	@Override
	public void mover(Jogador jogador, CasaDoTabuleiro destino){
		CasaDoTabuleiro origem = jogador.getPosicaoJogador();
		jogador.setPosicaoJogador(destino);
		jogador.setIndiceAtualJogador(destino.getIndice());
		destino.adicionarJogadoresNaListaDaCasa(jogador);
		origem.removerJogadoresDaListaDaCasa(jogador);
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

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	public List<Jogador> getJogadoresNaCasa() {
		return jogadoresNaCasa;
	}

	public void setJogadoresNaCasa(List<Jogador> jogadoresNaCasa) {
		this.jogadoresNaCasa = jogadoresNaCasa;
	}


}
