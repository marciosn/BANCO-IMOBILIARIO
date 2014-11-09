package br.ufc.es.com.BancoImb.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import br.ufc.es.com.BancoImb.interfaces.IEfeitoCasa;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class CasaDoTabuleiro implements IEfeitoCasa{
	private String nome;
	private List<Jogador> jogadoresNaCasa;
	private int indice;
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
		
	}
	
	public void mover(Jogador jogador, CasaDoTabuleiro destino){
		CasaDoTabuleiro origem = jogador.getPosicaoJogador();
		jogador.setPosicaoJogador(destino);
		jogador.setIndiceAtualJogador(destino.getIndice());
		destino.adicionarJogadoresNaListaDaCasa(jogador);
		origem.removerJogadoresDaListaDaCasa(jogador);
		imprimeJogadores(destino);
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
	public void imprimeJogadores(CasaDoTabuleiro casa){
		for(Jogador jogador : casa.getJogadoresNaCasa())
			System.out.println(jogador.getNome() + " | " + jogador.getPosicaoJogador().getNome() + " | " + jogador.getIndiceAtualJogador());
	}

}
