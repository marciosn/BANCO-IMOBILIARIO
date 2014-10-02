package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	List<Casa> tabuleiro;
	int indiceProximaCasa;
	
	public Tabuleiro() {
		tabuleiro = new ArrayList<Casa>();
		criarCasasNoTabuleiro();
	}
	public void criarCasasNoTabuleiro(){
		tabuleiro.add(new LugarEspecial("Partida"));
		tabuleiro.add(new Imovel("Apartamento", 1000, 500));
		tabuleiro.add(new Empresa("Google", 4000, 100));
		tabuleiro.add(new LugarEspecial("Receba Dinheiro"));
		tabuleiro.add(new Imovel("Casa", 5000, 200));
		tabuleiro.add(new Imovel("Apartamento", 1500, 700));
		tabuleiro.add(new Empresa("Facebook", 6000, 900));
		tabuleiro.add(new Imovel("Apartamento", 1000, 500));
		tabuleiro.add(new Empresa("Google", 4000, 100));
		tabuleiro.add(new LugarEspecial("Receba Dinheiro"));
		tabuleiro.add(new Imovel("Casa", 5000, 200));
		tabuleiro.add(new Imovel("Apartamento", 1500, 700));
		tabuleiro.add(new Empresa("Facebook", 6000, 900));
		tabuleiro.add(new Imovel("Apartamento", 1000, 500));
		tabuleiro.add(new Empresa("Google", 4000, 100));
		tabuleiro.add(new LugarEspecial("Receba Dinheiro"));
		tabuleiro.add(new Imovel("Casa", 5000, 200));
		tabuleiro.add(new Imovel("Apartamento", 1500, 700));
		tabuleiro.add(new Empresa("Facebook", 6000, 900));
	}

	public void adiconarJogadoresACasa(int indice, Jogador jogador){
		tabuleiro.get(indice).adicionarJogadoresNaLista(jogador);
	}
	public void moverJogador(Jogador jogador,Casa origem, Casa destino){
		origem.removerJogador(jogador);
		destino.adicionarJogadoresNaLista(jogador);
	}
	public int calculaIndiceProximaCasa(Casa casaAtual, int resultDado){
		for(int i = 0 ; i < tabuleiro.size() ; i++){
			if(tabuleiro.get(i).equals(casaAtual)){
				indiceProximaCasa = i;
			}
		}
		return indiceProximaCasa += resultDado;
	}
	public Casa getPeloIndice(int indice){
		return tabuleiro.get(indice);
	}
	
	public List<Casa> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(List<Casa> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	
}
