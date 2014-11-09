package br.ufc.es.com.BancoImb.control;

import java.awt.Point;
import java.util.List;

import br.ufc.es.com.BancoImb.Lugradouros.LogradouroComumEmpresa;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroComumImovel;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialImpostoDeRenda;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialLucrosEDividendos;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialParadaLivre;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialPartida;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialPrisao;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialSorteReves;
import br.ufc.es.com.BancoImb.Lugradouros.LogradouroEspecialVaParaAPrisao;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;

public class Tabuleiro{
	private List<CasaDoTabuleiro> tabuleiro;
	private RepositorioLists repositorioLists;
	
	/*public ControllTabuleiro(List<CasaDoTabuleiro> tabuleiroList) {
		tabuleiro = tabuleiroList;
		criarCasasNoTabuleiro();
	}*/
	public Tabuleiro(RepositorioLists repositorio) {
		repositorioLists = repositorio;
		tabuleiro = repositorio.getTabuleiro();
		criarCasasNoTabuleiro();
	}
	
	public void criarCasasNoTabuleiro() {
		tabuleiro.add(new LogradouroEspecialPartida("Partida", new Point(13, 12), 0));											//POSICAO 00
		tabuleiro.add(new LogradouroComumImovel("Brooklin", 260 , 260, new Point(13, 107), 1));								//POSICAO 01
		tabuleiro.add(new LogradouroComumImovel("Jardim Paulista", 280 , 280, new Point(13, 164), 2));							//POSICAO 02
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(13,224), 3, repositorioLists));									//POSICAO 03
		tabuleiro.add(new LogradouroComumImovel("Ipanema", 300 , 300, new Point(13, 281), 4));									//POSICAO 04
		tabuleiro.add(new LogradouroComumEmpresa("Companhia Taxi Aereo", 200 , 200, new Point(13, 336), 5));					//POSICAO 05
		tabuleiro.add(new LogradouroComumImovel("Avendia Atlantica", 300 , 300, new Point(13, 393), 6));						//POSICAO 06
		tabuleiro.add(new LogradouroComumImovel("Avendia Vieira Souto", 320 , 320, new Point(13, 446), 7));					//POSICAO 07
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Aviacao", 200 , 200, new Point(13, 504), 8));					//POSICAO 08
		tabuleiro.add(new LogradouroComumImovel("Copacabana", 260 , 260, new Point(13, 563), 9));								//POSICAO 09
		tabuleiro.add(new LogradouroEspecialVaParaAPrisao("Va Para A Prisao", new Point(13, 629), 10, repositorioLists));							//POSICAO 10
		tabuleiro.add(new LogradouroComumImovel("Jardim Europa", 140, 14, new Point(165, 643), 11));							//POSICAO 11
		tabuleiro.add(new LogradouroComumImovel("Avendia Paulista", 140 , 140, new Point(248, 643), 12));						//POSICAO 12
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte_Reves", new Point(332, 643), 13, repositorioLists));								//POSICAO 13
		tabuleiro.add(new LogradouroComumImovel("Avendia Brasil", 160 , 160, new Point(416, 643), 14));							//POSICAO 14
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Navegacao", 150 , 150, new Point(498, 643), 15));				//POSICAO 15
		tabuleiro.add(new LogradouroEspecialImpostoDeRenda("Imposto De Renda", new Point(584, 643), 16));						//POSICAO 16
		tabuleiro.add(new LogradouroComumImovel("Botafogo", 100 , 100, new Point(668, 643), 17));								//POSICAO 17
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(754, 643), 18, repositorioLists));								//POSICAO 18
		tabuleiro.add(new LogradouroComumImovel("Flamengo", 120 , 120, new Point(838, 643), 19));								//POSICAO 19
		tabuleiro.add(new LogradouroEspecialParadaLivre("Parada Livre", new Point(926, 643), 20));								//POSICAO 20
		tabuleiro.add(new LogradouroComumImovel("Morumbi", 120 , 120, new Point(948, 563), 21));								//POSICAO 21
		tabuleiro.add(new LogradouroEspecialLucrosEDividendos("Lucros E Dividendos", new Point(948, 511), 22));					//POSICAO 22
		tabuleiro.add(new LogradouroComumImovel("Interlagos", 120 , 120, new Point(948, 452), 23));								//POSICAO 23
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(948, 394), 24, repositorioLists));								//POSICAO 24
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Taxi", 150 , 150, new Point(948, 339), 25));						//POSICAO 25
		tabuleiro.add(new LogradouroComumImovel("Avenida Pacaembu", 180 , 180, new Point(948, 280), 26));						//POSICAO 26
		tabuleiro.add(new LogradouroComumImovel("Rua Augusta", 180 , 180, new Point(948, 220), 27));							//POSICAO 27
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(948, 167), 28, repositorioLists));								//POSICAO 28
		tabuleiro.add(new LogradouroComumImovel("Avenida Europa", 200 , 200, new Point(948, 108), 29));							//POSICAO 29
		tabuleiro.add(new LogradouroEspecialPrisao("Prisao", new Point(937, 10), 30));											//POSICAO 30
		tabuleiro.add(new LogradouroComumImovel("Avenida 9 De Julho", 220 , 220, new Point(837, 10), 31));						//POSICAO 31
		tabuleiro.add(new LogradouroComumImovel("Avenida Reboucas", 220 , 220, new Point(758, 10), 32));						//POSICAO 32
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Viacao", 200 , 200, new Point(676, 10), 33));					//POSICAO 33
		tabuleiro.add(new LogradouroComumImovel("Avenida Brigadeiro Faria Lima", 240 , 240, new Point(591, 10), 34));			//POSICAO 34
		tabuleiro.add(new LogradouroComumEmpresa("Companhia Ferroviaria", 200 , 200, new Point(502, 10), 35));					//POSICAO 35
		tabuleiro.add(new LogradouroComumImovel("Avenida Nossa Senhora De Copacabana", 60 , 60, new Point(418, 10), 36));		//POSICAO 36
		tabuleiro.add(new LogradouroComumImovel("Avenida Presidente Vargas", 60 , 60, new Point(341, 10), 37));					//POSICAO 37
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(253, 10), 38, repositorioLists));									//POSICAO 38
		tabuleiro.add(new LogradouroComumImovel("Leblon", 100 , 100, new Point(171, 10), 39));									//POSICAO 39
	}
}
