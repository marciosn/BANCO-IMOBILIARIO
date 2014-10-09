package br.com.ufc.es.BancoImb.model;

import java.util.ArrayList;
import java.util.List;

import br.com.ufc.es.BancoImb.LogradourComercializavel.Empresa;
import br.com.ufc.es.BancoImb.LogradourComercializavel.Imovel;
import br.com.ufc.es.BancoImb.LugarEspecial.ImpostoDeRenda;
import br.com.ufc.es.BancoImb.LugarEspecial.LogradouroEspecial;
import br.com.ufc.es.BancoImb.LugarEspecial.LucrosEDividendos;
import br.com.ufc.es.BancoImb.LugarEspecial.ParadaLivre;
import br.com.ufc.es.BancoImb.LugarEspecial.Partida;
import br.com.ufc.es.BancoImb.LugarEspecial.Prisao;
import br.com.ufc.es.BancoImb.LugarEspecial.SorteReves;
import br.com.ufc.es.BancoImb.LugarEspecial.VaParaAPrisao;

public class Tabuleiro {
	List<Casa> tabuleiro;
	int indiceProximaCasa;

	public Tabuleiro() {
		tabuleiro = new ArrayList<Casa>();
		criarCasasNoTabuleiro();
	}

	public void criarCasasNoTabuleiro() {
		tabuleiro.add(new Partida("Partida"));														//POSICAO 00
		tabuleiro.add(new Imovel("Brooklin", 260 , 260));											//POSICAO 01
		tabuleiro.add(new Imovel("Jardim_Paulista", 280 , 280));									//POSICAO 02
		tabuleiro.add(new SorteReves("Sorte_Reves"));												//POSICAO 03
		tabuleiro.add(new Imovel("Ipanema", 300 , 300));											//POSICAO 04
		tabuleiro.add(new Empresa("Companhia_Taxi_Aereo", 200 , 200));								//POSICAO 05
		tabuleiro.add(new Imovel("Avendia_Atlantica", 300 , 300));									//POSICAO 06
		tabuleiro.add(new Imovel("Avendia_Vieira_Souto", 320 , 320));								//POSICAO 07
		tabuleiro.add(new Empresa("Companhia_De_Aviacao", 200 , 200));								//POSICAO 08
		tabuleiro.add(new Imovel("Copacabana", 260 , 260));											//POSICAO 09
		tabuleiro.add(new VaParaAPrisao("Va_Para_A_Prisao"));										//POSICAO 10
		tabuleiro.add(new Imovel("Jardim_Europa", 140, 140));										//POSICAO 11
		tabuleiro.add(new Imovel("Avendia_Paulista", 140 , 140));									//POSICAO 12
		tabuleiro.add(new SorteReves("Sorte_Reves"));												//POSICAO 13
		tabuleiro.add(new Imovel("Avendia_Brasil", 160 , 160));										//POSICAO 14
		tabuleiro.add(new Empresa("Companhia_De_Navegacao", 150 , 150));							//POSICAO 15
		tabuleiro.add(new ImpostoDeRenda("Imposto_De_Renda"));										//POSICAO 16
		tabuleiro.add(new Imovel("Botafogo", 100 , 100));											//POSICAO 17
		tabuleiro.add(new SorteReves("Sorte_Reves"));												//POSICAO 18
		tabuleiro.add(new Imovel("Flamengo", 120 , 120));											//POSICAO 19
		tabuleiro.add(new ParadaLivre("Parada_Livre"));												//POSICAO 20
		tabuleiro.add(new Imovel("Morumbi", 120 , 120));											//POSICAO 21
		tabuleiro.add(new LucrosEDividendos("Lucros_E_Dividendos"));								//POSICAO 22
		tabuleiro.add(new Imovel("Interlagos", 120 , 120));											//POSICAO 23
		tabuleiro.add(new SorteReves("Sorte_Reves"));												//POSICAO 24
		tabuleiro.add(new Empresa("Companhia_De_Taxi", 150 , 150));									//POSICAO 25
		tabuleiro.add(new Imovel("Avenida_Pacaembu", 180 , 180));									//POSICAO 26
		tabuleiro.add(new Imovel("Rua_Augusta", 180 , 180));										//POSICAO 27
		tabuleiro.add(new SorteReves("Sorte_Reves"));												//POSICAO 28
		tabuleiro.add(new Imovel("Avenida_Europa", 	200 , 200));									//POSICAO 29
		tabuleiro.add(new Prisao("Prisao"));														//POSICAO 30
		tabuleiro.add(new Imovel("Avenida_9_De_Julho", 220 , 220));									//POSICAO 31
		tabuleiro.add(new Imovel("Avenida_Reboucas", 220 , 220));									//POSICAO 32
		tabuleiro.add(new Empresa("Companhia_De_Viacao", 200 , 200));								//POSICAO 33
		tabuleiro.add(new Imovel("Avenida_Brigadeiro_Faria_Lima", 240 , 240));						//POSICAO 34
		tabuleiro.add(new Empresa("Companhia_Ferroviaria", 200 , 200));								//POSICAO 35
		tabuleiro.add(new Imovel("Avenida_Nossa_Senhora_De_Copacabana", 60 , 60));					//POSICAO 36
		tabuleiro.add(new Imovel("Avenida_Presidente_Vargas", 60 , 60));							//POSICAO 37
		tabuleiro.add(new SorteReves("Sorte_Reves"));												//POSICAO 38
		tabuleiro.add(new Imovel("Leblon", 100 , 100));												//POSICAO 39
	}

	public void adiconarJogadoresACasa(int indice, Jogador jogador) {
		tabuleiro.get(indice).adicionarJogadoresNaLista(jogador);
	}
	public void moverJogador(Jogador jogador, Casa destino) {
		Casa origem = getCasaByIndice(jogador.getPosicaoJogador());
		
		origem.removerJogador(jogador);
		jogador.setPosicaoJogador(getIndiceByCasa(destino));
		destino.adicionarJogadoresNaLista(jogador);
		
		System.out.println("\n");
		System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
		
		System.out.println("\t" + "O Jogador "+jogador.getNome()+ " foi movido da casa " +
				getIndiceByCasa(origem)+ " para a casa " + getIndiceByCasa(destino) + " | a casa " +
				destino.getNome() + " possui " + destino.getNumJogadoresCasa() + " jogadores");
		
		System.out.println("\t" + "Agora o jogador esta na casa de posicao: " + jogador.getPosicaoJogador());
		
	}
	
	public int calculaIndiceProximaCasa(int indiceAtual, int resultDado) {
		indiceProximaCasa = indiceAtual + resultDado;
		if(indiceProximaCasa > 39){
			int percent = indiceProximaCasa % 40;
			indiceProximaCasa = percent;
		}
		return indiceProximaCasa;
	}

	public Casa getCasaByIndice(int indice) {
		return tabuleiro.get(indice);
	}
	public int getIndiceByCasa(Casa casa){
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
	
	public Jogador getJogadorByID(int id){
		Jogador jogador = null;
		for (int i = 0; i < tabuleiro.size(); i++) {
			for (Jogador jog : tabuleiro.get(i).getJogadoresNaCasa()) {
				if (jog.getID() == id) {
					jogador = jog;
				}
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
		for(Jogador jogador : getCasaByIndice(indice).getJogadoresNaCasa()){
			System.out.println("Nome: " + jogador.getNome() + " ID: " +jogador.getID());
		}
	}

}
