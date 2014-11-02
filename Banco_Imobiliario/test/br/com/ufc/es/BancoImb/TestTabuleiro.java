package br.com.ufc.es.BancoImb;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import br.com.ufc.es.BancoImb.LogradourComercializavel.LogradouroComercializavel_Empresa;
import br.com.ufc.es.BancoImb.LogradourComercializavel.LogradouroComercializavel_Imovel;
import br.com.ufc.es.BancoImb.control.Controlador_Banco_Imobiliario;
import br.com.ufc.es.BancoImb.model.CasaDoTabuleiro;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Jogador;
import br.com.ufc.es.BancoImb.model.PecaJogador;
import br.com.ufc.es.BancoImb.model.Tabuleiro;

public class TestTabuleiro {

	LogradouroComercializavel_Empresa empresa = new LogradouroComercializavel_Empresa("Google", 5000, 1000, new Point(32, 26));
	LogradouroComercializavel_Imovel imovel = new LogradouroComercializavel_Imovel("Apartamento", 3000, 1000, new Point(32, 26));
	Jogador marcio = new Jogador("Marcio", new ContaBancaria(10000), new PecaJogador(""));
	Jogador jose = new Jogador("Jose", new ContaBancaria(10000), new PecaJogador(""));
	Jogador joao = new Jogador("Joao", new ContaBancaria(10000), new PecaJogador(""));
	CasaDoTabuleiro casa = new CasaDoTabuleiro();
	CasaDoTabuleiro casa2 = new CasaDoTabuleiro();
	Tabuleiro tab = new Tabuleiro();
	Controlador_Banco_Imobiliario bancoImobiliario = new Controlador_Banco_Imobiliario();
	
	@Test
	public void testAdcionarJogadorCasa() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(0, marcio);
		tab.adiconarJogadoresACasa(0, jose);
		tab.adiconarJogadoresACasa(0, joao);
		CasaDoTabuleiro c = tab.getCasaByIndice(0);
		assertTrue(c.getNumJogadoresCasa() == 3);
	}
	
	@Test
	public void testMoverJogador() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(4, marcio);
		tab.adiconarJogadoresACasa(4, jose);
		tab.adiconarJogadoresACasa(4, joao);
		CasaDoTabuleiro origem = tab.getCasaByIndice(4);
		CasaDoTabuleiro destino = tab.getCasaByIndice(38);
		tab.moverJogador(marcio, destino);
		assertTrue(origem.getNumJogadoresCasa() == 2 && destino.getNumJogadoresCasa() == 1);
	}
	@Test
	public void testMoverJogadorReal() {
		tab.adiconarJogadoresACasa(3, joao);
		tab.adiconarJogadoresACasa(3, jose);
		tab.adiconarJogadoresACasa(3, marcio);
		CasaDoTabuleiro origem = tab.getCasaByIndice(3);
		CasaDoTabuleiro destino = tab.getCasaByIndice(34);
		tab.moverJogador(joao,destino);
		tab.moverJogador(jose,destino);
		tab.moverJogador(marcio,destino);
		assertTrue(origem.getNumJogadoresCasa() == 0 && destino.getNumJogadoresCasa() == 3);
	}
	
	@Test
	public void testPegaJogadorASerMovido() {
		Jogador marcio = new Jogador("marcio", new ContaBancaria(10000), new PecaJogador(""));
		Jogador souza = new Jogador("souza", new ContaBancaria(10000), new PecaJogador(""));
		Jogador nobre = new Jogador("nobre", new ContaBancaria(10000), new PecaJogador(""));
		Jogador edu = new Jogador("edu", new ContaBancaria(10000), new PecaJogador(""));
		Jogador dudu = new Jogador("dudu", new ContaBancaria(10000), new PecaJogador(""));
		
		bancoImobiliario.InserindoJogadorNoJogo(marcio);
		bancoImobiliario.InserindoJogadorNoJogo(souza);
		bancoImobiliario.InserindoJogadorNoJogo(nobre);
		bancoImobiliario.InserindoJogadorNoJogo(edu);
		bancoImobiliario.InserindoJogadorNoJogo(dudu);
		
		bancoImobiliario.adicionarJogadoresNaCasaDePartida(bancoImobiliario.getJodagores());
		
		CasaDoTabuleiro destino = bancoImobiliario.getTabuleiroJogo().getCasaByIndice(10);
		Jogador jogador = bancoImobiliario.getTabuleiroJogo().getJogadorByID(12);
		bancoImobiliario.getTabuleiroJogo().moverJogador(jogador, destino);
				
		assertTrue(destino.getNumJogadoresCasa() == 1);
	}
	
	@Test
	public void testCalculaIndiceProximaCasa() {
		assertTrue(bancoImobiliario.getTabuleiroJogo().calculaIndiceProximaCasa(4, 30) == 34);
	}
	
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









