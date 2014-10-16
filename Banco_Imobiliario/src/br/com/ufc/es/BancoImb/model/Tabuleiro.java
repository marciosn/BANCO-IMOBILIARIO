package br.com.ufc.es.BancoImb.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import jplay.Keyboard;
import jplay.Mouse;
import jplay.Scene;
import jplay.Window;
import br.com.ufc.es.BancoImb.LogradourComercializavel.LogradouroComercializavel_Empresa;
import br.com.ufc.es.BancoImb.LogradourComercializavel.LogradouroComercializavel_Imovel;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_ImpostoDeRenda;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_LucrosEDividendos;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_ParadaLivre;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_Partida;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_Prisao;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_SorteReves;
import br.com.ufc.es.BancoImb.LugarEspecial.LugarEspecial_VaParaAPrisao;

public class Tabuleiro {
	private List<CasaDoTabuleiro> tabuleiro;
	private int indiceProximaCasa;

	public Tabuleiro() {
		tabuleiro = new ArrayList<CasaDoTabuleiro>();
		criarCasasNoTabuleiro();
	}

	public void criarCasasNoTabuleiro() {
		tabuleiro.add(new LugarEspecial_Partida("Partida", new Point(13, 12)));														//POSICAO 00
		tabuleiro.add(new LogradouroComercializavel_Imovel("Brooklin", 260 , 260, new Point(13, 107)));								//POSICAO 01
		tabuleiro.add(new LogradouroComercializavel_Imovel("Jardim Paulista", 280 , 280, new Point(13, 164)));						//POSICAO 02
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte Reves", new Point(13,224)));												//POSICAO 03
		tabuleiro.add(new LogradouroComercializavel_Imovel("Ipanema", 300 , 300, new Point(13, 281)));								//POSICAO 04
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia Taxi Aereo", 200 , 200, new Point(13, 336)));					//POSICAO 05
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia Atlantica", 300 , 300, new Point(13, 393)));						//POSICAO 06
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia Vieira Souto", 320 , 320, new Point(13, 446)));					//POSICAO 07
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia De Aviacao", 200 , 200, new Point(13, 504)));					//POSICAO 08
		tabuleiro.add(new LogradouroComercializavel_Imovel("Copacabana", 260 , 260, new Point(13, 563)));							//POSICAO 09
		tabuleiro.add(new LugarEspecial_VaParaAPrisao("Va Para A Prisao", new Point(13, 629)));										//POSICAO 10
		tabuleiro.add(new LogradouroComercializavel_Imovel("Jardim Europa", 140, 14, new Point(165, 643)));							//POSICAO 11
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia Paulista", 140 , 140, new Point(248, 643)));						//POSICAO 12
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(332, 643)));												//POSICAO 13
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia Brasil", 160 , 160, new Point(416, 643)));						//POSICAO 14
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia De Navegacao", 150 , 150, new Point(498, 643)));				//POSICAO 15
		tabuleiro.add(new LugarEspecial_ImpostoDeRenda("Imposto De Renda", new Point(584, 643)));										//POSICAO 16
		tabuleiro.add(new LogradouroComercializavel_Imovel("Botafogo", 100 , 100, new Point(668, 643)));								//POSICAO 17
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte Reves", new Point(754, 643)));												//POSICAO 18
		tabuleiro.add(new LogradouroComercializavel_Imovel("Flamengo", 120 , 120, new Point(838, 643)));								//POSICAO 19
		tabuleiro.add(new LugarEspecial_ParadaLivre("Parada Livre", new Point(926, 643)));											//POSICAO 20
		tabuleiro.add(new LogradouroComercializavel_Imovel("Morumbi", 120 , 120, new Point(948, 563)));								//POSICAO 21
		tabuleiro.add(new LugarEspecial_LucrosEDividendos("Lucros E Dividendos", new Point(948, 511)));								//POSICAO 22
		tabuleiro.add(new LogradouroComercializavel_Imovel("Interlagos", 120 , 120, new Point(948, 452)));							//POSICAO 23
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte Reves", new Point(948, 394)));												//POSICAO 24
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia De Taxi", 150 , 150, new Point(948, 339)));					//POSICAO 25
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida Pacaembu", 180 , 180, new Point(948, 280)));						//POSICAO 26
		tabuleiro.add(new LogradouroComercializavel_Imovel("Rua Augusta", 180 , 180, new Point(948, 220)));							//POSICAO 27
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte Reves", new Point(948, 167)));												//POSICAO 28
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida Europa", 200 , 200, new Point(948, 108)));						//POSICAO 29
		tabuleiro.add(new LugarEspecial_Prisao("Prisao", new Point(937, 10)));														//POSICAO 30
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida 9 De Julho", 220 , 220, new Point(837, 10)));					//POSICAO 31
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida Reboucas", 220 , 220, new Point(758, 10)));						//POSICAO 32
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia De Viacao", 200 , 200, new Point(676, 10)));					//POSICAO 33
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida Brigadeiro Faria Lima", 240 , 240, new Point(591, 10)));			//POSICAO 34
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia Ferroviaria", 200 , 200, new Point(502, 10)));				//POSICAO 35
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida Nossa Senhora De Copacabana", 60 , 60, new Point(418, 10)));		//POSICAO 36
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida Presidente Vargas", 60 , 60, new Point(341, 10)));				//POSICAO 37
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte Reves", new Point(253, 10)));												//POSICAO 38
		tabuleiro.add(new LogradouroComercializavel_Imovel("Leblon", 100 , 100, new Point(171, 10)));								//POSICAO 39
	}

	public void adiconarJogadoresACasa(int indice, Jogador jogador) {
		tabuleiro.get(indice).adicionarJogadoresNaLista(jogador);
	}
	public void moverJogador(Jogador jogador, CasaDoTabuleiro destino) {
		CasaDoTabuleiro origem = getCasaByIndice(jogador.getPosicaoJogador());
		
		origem.removerJogador(jogador);
		jogador.setPosicaoJogador(getIndiceByCasa(destino));
		destino.adicionarJogadoresNaLista(jogador);
		
		System.out.println("\n");
		System.out.println("<<<<<<<<<<==============================================================================>>>>>>>>>>");
		
		System.out.println("\t" + "O Jogador "+jogador.getNome()+ " foi movido da casa " +
				getIndiceByCasa(origem)+ " para a casa " + getIndiceByCasa(destino) + " | a casa " +
				destino.getNome() + " possui " + destino.getNumJogadoresCasa() + " jogadores");
		
		System.out.println("\t" + "Agora o jogador esta na casa de posicao: " + jogador.getPosicaoJogador());
		
		System.out.println("\t" + "Posicao Origem: " + origem.getPosicao());
		System.out.println("\t" + "Posicao Destino: " + destino.getPosicao());
		
	}
	public void removeJogadorDefinitivo(Jogador jogador){
		try {
			getCasaByJogador(jogador).getJogadoresNaCasa().remove(jogador);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	public int calculaIndiceProximaCasa(int indiceAtual, int resultDado) {
		indiceProximaCasa = indiceAtual + resultDado;
		if(indiceProximaCasa > 39){
			int percent = indiceProximaCasa % 40;
			indiceProximaCasa = percent;
		}
		return indiceProximaCasa;
	}

	public CasaDoTabuleiro getCasaByIndice(int indice) {
		return tabuleiro.get(indice);
	}
	public int getIndiceByCasa(CasaDoTabuleiro casa){
		int indice = 0;
		for(int i = 0 ; i < tabuleiro.size() ; i++){
			if(tabuleiro.get(i).equals(casa)){
				indice = i;
			}
		}
		return indice;
	}
	
	public List<CasaDoTabuleiro> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
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
	public CasaDoTabuleiro getCasaByJogador(Jogador jogador){
		CasaDoTabuleiro casaT = null;
		for(CasaDoTabuleiro casa : tabuleiro){
			for(Jogador j : casa.getJogadoresNaCasa()){
				if(j.equals(jogador)){
					casaT = casa;
				}
			}
		}
		
		return casaT;
	}
	
	public void imprimiTabuleiro() {
		for (CasaDoTabuleiro c : tabuleiro) {
			System.out.println(c.getNome() + " || " + c.getNumJogadoresCasa());
		}
	}
	
	public void imprimirJogadoresNaCasa(int indice){
		for(Jogador jogador : getCasaByIndice(indice).getJogadoresNaCasa()){
			System.out.println("Nome: " + jogador.getNome() + " ID: " +jogador.getID());
		}
	}

}
