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
		tabuleiro.add(new LugarEspecial_Partida("Partida", new Point(32, 26)));														//POSICAO 00
		tabuleiro.add(new LogradouroComercializavel_Imovel("Brooklin", 260 , 260, new Point(25, 117)));								//POSICAO 01
		tabuleiro.add(new LogradouroComercializavel_Imovel("Jardim_Paulista", 280 , 280, new Point(32, 179)));						//POSICAO 02
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(17, 270)));												//POSICAO 03
		tabuleiro.add(new LogradouroComercializavel_Imovel("Ipanema", 300 , 300, new Point(18, 333)));								//POSICAO 04
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia_Taxi_Aereo", 200 , 200, new Point(21, 393)));					//POSICAO 05
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia_Atlantica", 300 , 300, new Point(28, 456)));						//POSICAO 06
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia_Vieira_Souto", 320 , 320, new Point(22, 513)));					//POSICAO 07
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia_De_Aviacao", 200 , 200, new Point(20, 558)));					//POSICAO 08
		tabuleiro.add(new LogradouroComercializavel_Imovel("Copacabana", 260 , 260, new Point(15, 653)));							//POSICAO 09
		tabuleiro.add(new LugarEspecial_VaParaAPrisao("Va_Para_A_Prisao", new Point(32, 26)));										//POSICAO 10
		tabuleiro.add(new LogradouroComercializavel_Imovel("Jardim_Europa", 140, 14, new Point(32, 26)));							//POSICAO 11
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia_Paulista", 140 , 140, new Point(32, 26)));						//POSICAO 12
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(32, 26)));												//POSICAO 13
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avendia_Brasil", 160 , 160, new Point(32, 26)));						//POSICAO 14
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia_De_Navegacao", 150 , 150, new Point(32, 26)));				//POSICAO 15
		tabuleiro.add(new LugarEspecial_ImpostoDeRenda("Imposto_De_Renda", new Point(32, 26)));										//POSICAO 16
		tabuleiro.add(new LogradouroComercializavel_Imovel("Botafogo", 100 , 100, new Point(32, 26)));								//POSICAO 17
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(32, 26)));												//POSICAO 18
		tabuleiro.add(new LogradouroComercializavel_Imovel("Flamengo", 120 , 120, new Point(32, 26)));								//POSICAO 19
		tabuleiro.add(new LugarEspecial_ParadaLivre("Parada_Livre", new Point(32, 26)));											//POSICAO 20
		tabuleiro.add(new LogradouroComercializavel_Imovel("Morumbi", 120 , 120, new Point(32, 26)));								//POSICAO 21
		tabuleiro.add(new LugarEspecial_LucrosEDividendos("Lucros_E_Dividendos", new Point(32, 26)));								//POSICAO 22
		tabuleiro.add(new LogradouroComercializavel_Imovel("Interlagos", 120 , 120, new Point(32, 26)));							//POSICAO 23
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(32, 26)));												//POSICAO 24
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia_De_Taxi", 150 , 150, new Point(32, 26)));					//POSICAO 25
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_Pacaembu", 180 , 180, new Point(32, 26)));						//POSICAO 26
		tabuleiro.add(new LogradouroComercializavel_Imovel("Rua_Augusta", 180 , 180, new Point(32, 26)));							//POSICAO 27
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(32, 26)));												//POSICAO 28
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_Europa", 200 , 200, new Point(32, 26)));						//POSICAO 29
		tabuleiro.add(new LugarEspecial_Prisao("Prisao", new Point(32, 26)));														//POSICAO 30
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_9_De_Julho", 220 , 220, new Point(32, 26)));					//POSICAO 31
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_Reboucas", 220 , 220, new Point(32, 26)));						//POSICAO 32
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia_De_Viacao", 200 , 200, new Point(32, 26)));					//POSICAO 33
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_Brigadeiro_Faria_Lima", 240 , 240, new Point(32, 26)));			//POSICAO 34
		tabuleiro.add(new LogradouroComercializavel_Empresa("Companhia_Ferroviaria", 200 , 200, new Point(32, 26)));				//POSICAO 35
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_Nossa_Senhora_De_Copacabana", 60 , 60, new Point(32, 26)));		//POSICAO 36
		tabuleiro.add(new LogradouroComercializavel_Imovel("Avenida_Presidente_Vargas", 60 , 60, new Point(32, 26)));				//POSICAO 37
		tabuleiro.add(new LugarEspecial_SorteReves("Sorte_Reves", new Point(32, 26)));												//POSICAO 38
		tabuleiro.add(new LogradouroComercializavel_Imovel("Leblon", 100 , 100, new Point(32, 26)));								//POSICAO 39
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
