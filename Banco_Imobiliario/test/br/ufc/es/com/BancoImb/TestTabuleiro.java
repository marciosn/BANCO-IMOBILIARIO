package br.ufc.es.com.BancoImb;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import br.ufc.es.com.BancoImb.LogradouroComum.LogradouroComumEmpresa;
import br.ufc.es.com.BancoImb.LogradouroComum.LogradouroComumImovel;
import br.ufc.es.com.BancoImb.control.CalcularIndiceProximaCasa;
import br.ufc.es.com.BancoImb.control.ControladorBancoImobiliario;
import br.ufc.es.com.BancoImb.model.CasaDoTabuleiro;
import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.tabuleiro.Tabuleiro;

public class TestTabuleiro {

	LogradouroComumEmpresa empresa = new LogradouroComumEmpresa("Google", 5000, 1000, new Point(32, 26));
	LogradouroComumImovel imovel = new LogradouroComumImovel("Apartamento", 3000, 1000, new Point(32, 26));
	Jogador marcio = new Jogador("Marcio", new ContaBancaria(10000), new PecaJogador(""));
	Jogador jose = new Jogador("Jose", new ContaBancaria(10000), new PecaJogador(""));
	Jogador joao = new Jogador("Joao", new ContaBancaria(10000), new PecaJogador(""));
	CasaDoTabuleiro casa = new CasaDoTabuleiro();
	CasaDoTabuleiro casa2 = new CasaDoTabuleiro();
	CalcularIndiceProximaCasa calc = new CalcularIndiceProximaCasa();
	Tabuleiro tab = new Tabuleiro();
	ControladorBancoImobiliario bancoImobiliario = new ControladorBancoImobiliario();
	
	@Test
	public void testAdcionarJogadorCasa() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasaDePartida(0, marcio);
		tab.adiconarJogadoresACasaDePartida(0, jose);
		tab.adiconarJogadoresACasaDePartida(0, joao);
		CasaDoTabuleiro c = tab.getCasaByIndice(0);
		assertTrue(c.getNumJogadoresCasa() == 3);
	}
	
	@Test
	public void testMoverJogador() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasaDePartida(4, marcio);
		tab.adiconarJogadoresACasaDePartida(4, jose);
		tab.adiconarJogadoresACasaDePartida(4, joao);
		CasaDoTabuleiro origem = tab.getCasaByIndice(4);
		CasaDoTabuleiro destino = tab.getCasaByIndice(38);
		tab.moverJogador(marcio, destino);
		assertTrue(origem.getNumJogadoresCasa() == 2 && destino.getNumJogadoresCasa() == 1);
	}
	@Test
	public void testMoverJogadorReal() {
		tab.adiconarJogadoresACasaDePartida(3, joao);
		tab.adiconarJogadoresACasaDePartida(3, jose);
		tab.adiconarJogadoresACasaDePartida(3, marcio);
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
		
		bancoImobiliario.InserirJogadorNaListaDeJogadores(marcio);
		bancoImobiliario.InserirJogadorNaListaDeJogadores(souza);
		bancoImobiliario.InserirJogadorNaListaDeJogadores(nobre);
		bancoImobiliario.InserirJogadorNaListaDeJogadores(edu);
		bancoImobiliario.InserirJogadorNaListaDeJogadores(dudu);
		
		bancoImobiliario.adicionarListaDeJogadoresNaCasaDePartida(bancoImobiliario.getJodagores());
		
		CasaDoTabuleiro destino = bancoImobiliario.getTabuleiroJogo().getCasaByIndice(10);
		Jogador jogador = bancoImobiliario.getTabuleiroJogo().getJogadorByID(12);
		bancoImobiliario.getTabuleiroJogo().moverJogador(jogador, destino);
				
		assertTrue(destino.getNumJogadoresCasa() == 1);
	}
	
	@Test
	public void testCalculaIndiceProximaCasa() {
		assertTrue(calc.obterIndiceProximaCasa(4, 30) == 34);
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
		assertTrue(calc.obterIndiceProximaCasa(4, 5) == 9);
	}
}









