package br.ufc.es.com.BancoImb.tabuleiro;

import java.awt.Point;
import java.util.List;

import br.ufc.es.com.BancoImb.LogradouroComum.LogradouroComumEmpresa;
import br.ufc.es.com.BancoImb.LogradouroComum.LogradouroComumImovel;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialImpostoDeRenda;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialLucrosEDividendos;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialParadaLivre;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialPartida;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialPrisao;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialSorteReves;
import br.ufc.es.com.BancoImb.LugradouroEspecial.LogradouroEspecialVaParaAPrisao;
import br.ufc.es.com.BancoImb.interfaces.ITabuleiro;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.Jogador;

public class Tabuleiro implements ITabuleiro{
	private List<CasaDoTabuleiro> tabuleiro;
	
	public Tabuleiro(List<CasaDoTabuleiro> tabuleiroList) {
		tabuleiro = tabuleiroList;
		criarCasasNoTabuleiro();
	}
	@Override
	public void moverJogador(Jogador jogador, CasaDoTabuleiro destino) {
		CasaDoTabuleiro origem = getCasaByIndice(jogador.getPosicaoAtualJogador());
		origem.removerJogador(jogador);
		jogador.setPosicaoAtualJogador(getIndiceByCasa(destino));
		destino.adicionarJogadoresNaListaDaCasa(jogador);
	}
	@Override
	public CasaDoTabuleiro getCasaByIndice(int indice) {
		return tabuleiro.get(indice);
	}
	@Override
	public int getIndiceByCasa(CasaDoTabuleiro casa){
		int indice = 0;
		for(int i = 0 ; i < tabuleiro.size() ; i++){
			if(tabuleiro.get(i).equals(casa)){
				indice = i;
			}
		}
		return indice;
	}
	@Override
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
	@Override
	public CasaDoTabuleiro getCasaByJogador(Jogador jogador){
		CasaDoTabuleiro casa = null;
		for(CasaDoTabuleiro c : tabuleiro){
			for(Jogador jog : c.getJogadoresNaCasa()){
				if(jog.equals(jogador)){
					casa = c;
				}
			}
		}
		return casa;
	}
	@Override
	public void criarCasasNoTabuleiro() {
		tabuleiro.add(new LogradouroEspecialPartida("Partida", new Point(13, 12)));											//POSICAO 00
		tabuleiro.add(new LogradouroComumImovel("Brooklin", 260 , 260, new Point(13, 107)));								//POSICAO 01
		tabuleiro.add(new LogradouroComumImovel("Jardim Paulista", 280 , 280, new Point(13, 164)));							//POSICAO 02
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(13,224)));									//POSICAO 03
		tabuleiro.add(new LogradouroComumImovel("Ipanema", 300 , 300, new Point(13, 281)));									//POSICAO 04
		tabuleiro.add(new LogradouroComumEmpresa("Companhia Taxi Aereo", 200 , 200, new Point(13, 336)));					//POSICAO 05
		tabuleiro.add(new LogradouroComumImovel("Avendia Atlantica", 300 , 300, new Point(13, 393)));						//POSICAO 06
		tabuleiro.add(new LogradouroComumImovel("Avendia Vieira Souto", 320 , 320, new Point(13, 446)));					//POSICAO 07
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Aviacao", 200 , 200, new Point(13, 504)));					//POSICAO 08
		tabuleiro.add(new LogradouroComumImovel("Copacabana", 260 , 260, new Point(13, 563)));								//POSICAO 09
		tabuleiro.add(new LogradouroEspecialVaParaAPrisao("Va Para A Prisao", new Point(13, 629)));							//POSICAO 10
		tabuleiro.add(new LogradouroComumImovel("Jardim Europa", 140, 14, new Point(165, 643)));							//POSICAO 11
		tabuleiro.add(new LogradouroComumImovel("Avendia Paulista", 140 , 140, new Point(248, 643)));						//POSICAO 12
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte_Reves", new Point(332, 643)));								//POSICAO 13
		tabuleiro.add(new LogradouroComumImovel("Avendia Brasil", 160 , 160, new Point(416, 643)));							//POSICAO 14
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Navegacao", 150 , 150, new Point(498, 643)));				//POSICAO 15
		tabuleiro.add(new LogradouroEspecialImpostoDeRenda("Imposto De Renda", new Point(584, 643)));						//POSICAO 16
		tabuleiro.add(new LogradouroComumImovel("Botafogo", 100 , 100, new Point(668, 643)));								//POSICAO 17
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(754, 643)));								//POSICAO 18
		tabuleiro.add(new LogradouroComumImovel("Flamengo", 120 , 120, new Point(838, 643)));								//POSICAO 19
		tabuleiro.add(new LogradouroEspecialParadaLivre("Parada Livre", new Point(926, 643)));								//POSICAO 20
		tabuleiro.add(new LogradouroComumImovel("Morumbi", 120 , 120, new Point(948, 563)));								//POSICAO 21
		tabuleiro.add(new LogradouroEspecialLucrosEDividendos("Lucros E Dividendos", new Point(948, 511)));					//POSICAO 22
		tabuleiro.add(new LogradouroComumImovel("Interlagos", 120 , 120, new Point(948, 452)));								//POSICAO 23
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(948, 394)));								//POSICAO 24
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Taxi", 150 , 150, new Point(948, 339)));						//POSICAO 25
		tabuleiro.add(new LogradouroComumImovel("Avenida Pacaembu", 180 , 180, new Point(948, 280)));						//POSICAO 26
		tabuleiro.add(new LogradouroComumImovel("Rua Augusta", 180 , 180, new Point(948, 220)));							//POSICAO 27
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(948, 167)));								//POSICAO 28
		tabuleiro.add(new LogradouroComumImovel("Avenida Europa", 200 , 200, new Point(948, 108)));							//POSICAO 29
		tabuleiro.add(new LogradouroEspecialPrisao("Prisao", new Point(937, 10)));											//POSICAO 30
		tabuleiro.add(new LogradouroComumImovel("Avenida 9 De Julho", 220 , 220, new Point(837, 10)));						//POSICAO 31
		tabuleiro.add(new LogradouroComumImovel("Avenida Reboucas", 220 , 220, new Point(758, 10)));						//POSICAO 32
		tabuleiro.add(new LogradouroComumEmpresa("Companhia De Viacao", 200 , 200, new Point(676, 10)));					//POSICAO 33
		tabuleiro.add(new LogradouroComumImovel("Avenida Brigadeiro Faria Lima", 240 , 240, new Point(591, 10)));			//POSICAO 34
		tabuleiro.add(new LogradouroComumEmpresa("Companhia Ferroviaria", 200 , 200, new Point(502, 10)));					//POSICAO 35
		tabuleiro.add(new LogradouroComumImovel("Avenida Nossa Senhora De Copacabana", 60 , 60, new Point(418, 10)));		//POSICAO 36
		tabuleiro.add(new LogradouroComumImovel("Avenida Presidente Vargas", 60 , 60, new Point(341, 10)));					//POSICAO 37
		tabuleiro.add(new LogradouroEspecialSorteReves("Sorte Reves", new Point(253, 10)));									//POSICAO 38
		tabuleiro.add(new LogradouroComumImovel("Leblon", 100 , 100, new Point(171, 10)));									//POSICAO 39
	}
	public List<CasaDoTabuleiro> getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(List<CasaDoTabuleiro> tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
