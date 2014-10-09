package br.com.ufc.es.BancoImb;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.ufc.es.BancoImb.LogradourComercializavel.Empresa;
import br.com.ufc.es.BancoImb.LogradourComercializavel.Imovel;
import br.com.ufc.es.BancoImb.control.BancoImobiliario;
import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class TestTabuleiro {

	Empresa empresa = new Empresa("Google", 5000, 1000);
	Imovel imovel = new Imovel("Apartamento", 3000, 1000);
	Jogador marcio = new Jogador("Marcio", new ContaBancaria(10000));
	Jogador jose = new Jogador("Jose", new ContaBancaria(10000));
	Jogador joao = new Jogador("Joao", new ContaBancaria(10000));
	Casa casa = new Casa();
	Casa casa2 = new Casa();
	Tabuleiro tab = new Tabuleiro();
	BancoImobiliario bancoImobiliario = new BancoImobiliario();
	
	@Test
	public void testAdcionarJogadorCasa() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(0, marcio);
		tab.adiconarJogadoresACasa(0, jose);
		tab.adiconarJogadoresACasa(0, joao);
		Casa c = tab.getCasaByIndice(0);
		assertTrue(c.getNumJogadoresCasa() == 3);
	}
	
	@Test
	public void testMoverJogador() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(4, marcio);
		tab.adiconarJogadoresACasa(4, jose);
		tab.adiconarJogadoresACasa(4, joao);
		Casa origem = tab.getCasaByIndice(4);
		Casa destino = tab.getCasaByIndice(38);
		tab.moverJogador(marcio, destino);
		assertTrue(origem.getNumJogadoresCasa() == 2 && destino.getNumJogadoresCasa() == 1);
	}
	@Test
	public void testMoverJogadorReal() {
		tab.adiconarJogadoresACasa(3, joao);
		tab.adiconarJogadoresACasa(3, jose);
		tab.adiconarJogadoresACasa(3, marcio);
		Casa origem = tab.getCasaByIndice(3);
		Casa destino = tab.getCasaByIndice(34);
		tab.moverJogador(joao,destino);
		tab.moverJogador(jose,destino);
		tab.moverJogador(marcio,destino);
		assertTrue(origem.getNumJogadoresCasa() == 0 && destino.getNumJogadoresCasa() == 3);
	}
	
	@Test
	public void testPegaJogadorASerMovido() {
		Jogador marcio = new Jogador("marcio", new ContaBancaria(10000));
		Jogador souza = new Jogador("souza", new ContaBancaria(10000));
		Jogador nobre = new Jogador("nobre", new ContaBancaria(10000));
		Jogador edu = new Jogador("edu", new ContaBancaria(10000));
		Jogador dudu = new Jogador("dudu", new ContaBancaria(10000));
		
		bancoImobiliario.InserindoJogadores(marcio);
		bancoImobiliario.InserindoJogadores(souza);
		bancoImobiliario.InserindoJogadores(nobre);
		bancoImobiliario.InserindoJogadores(edu);
		bancoImobiliario.InserindoJogadores(dudu);
		
		bancoImobiliario.adicionarJogadoresNaCasaDePartida(bancoImobiliario.getJodagores());
		
		Casa destino = bancoImobiliario.getTabuleiroJogo().getCasaByIndice(10);
		Jogador jogador = bancoImobiliario.getTabuleiroJogo().getJogadorByID(12);
		bancoImobiliario.getTabuleiroJogo().moverJogador(jogador, destino);
				
		assertTrue(destino.getNumJogadoresCasa() == 1);
	}
	
	/*@Test
	public void testCalculaIndiceProximaCasa() {
		assertTrue(bancoImobiliario.getTabuleiroJogo().calculaIndiceProximaCasa(4, 30) == 34);
	}
	*/
	@Test
	public void testGetCasaPeloIndice(){
		assertTrue(bancoImobiliario.getTabuleiroJogo().getCasaByIndice(10).getNome().equals("Va_Para_A_Prisao"));
	}
	@Test
	public void testTamanhoTabuleiro(){
		assertTrue(bancoImobiliario.getTabuleiroJogo().getTabuleiro().size() == 40);
	}
	
	@Test
	public void testIndiceCasa() {
		assertTrue(tab.calculaIndiceProximaCasa(4, 5) == 9);
	}
}









