package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
	List<Casa> tabuleiro;
	int indiceProximaCasa;

	public Tabuleiro() {
		tabuleiro = new ArrayList<Casa>();
		criarCasasNoTabuleiro();
		// imprimiTabuleiro();
	}

	public void criarCasasNoTabuleiro() {
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
		tabuleiro.add(new Imovel("Facebook", 6000, 900));
		tabuleiro.add(new LugarEspecial("Receba Dinheiro"));
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
		tabuleiro.add(new Imovel("Facebook", 6000, 900));
		tabuleiro.add(new LugarEspecial("Receba Dinheiro"));
	}

	public void adiconarJogadoresACasa(int indice, Jogador jogador) {
		tabuleiro.get(indice).adicionarJogadoresNaLista(jogador);
	}

	public void moverJogador(Jogador jogador, Casa origem, Casa destino) {
		origem.removerJogador(jogador);
		destino.adicionarJogadoresNaLista(jogador);
		System.out.println("==============================================================================");
		System.out.println("O Jogador "+jogador.getNome()+ " foi movido da casa " +
		getIndiceCasa(origem)+ " para a casa " + getIndiceCasa(destino) + " | a casa " +
		destino.getNome() + " possui " + destino.getNumJogadoresCasa() + " jogadores");
		System.out.println("==============================================================================");
	}
	public int calculaIndiceProximaCasa(Casa casaAtual, int resultDado) {
		for (int i = 0; i < tabuleiro.size(); i++) {
			if (tabuleiro.get(i).equals(casaAtual)) {
				indiceProximaCasa = i;
			}
		}
		return indiceProximaCasa += resultDado;
	}

	public Casa getCasaPeloIndice(int indice) {
		return tabuleiro.get(indice);
	}
	public int getIndiceCasa(Casa casa){
		int indice = 0;
		for(int i = 0 ; i < tabuleiro.size() ; i++){
			if(tabuleiro.get(i).equals(casa)){
				indice = i;
			}
		}
		return indice;
	}
	
	public List<Casa> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(List<Casa> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public Jogador getJogadorASerMovido(int id, Casa origem){
		Jogador jogador = null;
		for(Jogador j : origem.getJogadoresNaCasa()){
			if(j.getID() == id){
				jogador = j;
				System.out.println("Jogador: " + jogador.getNome() + " " + jogador.getSaldo() + " | ID = " + jogador.getID());
			}
		}
		 
		return jogador;
	}
	
	public void imprimiTabuleiro() {
		for (Casa c : tabuleiro) {
			System.out.println(c.getNome() + " || " + c.getNumJogadoresCasa());
		}
	}
	
	public void imprimirJogadoresNaCasa(int indice){
		for(Jogador jogador : getCasaPeloIndice(indice).getJogadoresNaCasa()){
			System.out.println("Nome: " + jogador.getNome() + " ID: " +jogador.getID());
		}
	}

}
