package br.com.ufc.es.BancoImb;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.ufc.es.BancoImb.model.Casa;
import br.com.ufc.es.BancoImb.model.ContaBancaria;
import br.com.ufc.es.BancoImb.model.Empresa;
import br.com.ufc.es.BancoImb.model.Imovel;
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
	
	@Test
	public void testAdcionarJogadorCasa() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(0, marcio);
		tab.adiconarJogadoresACasa(0, jose);
		tab.adiconarJogadoresACasa(0, joao);
		Casa c = tab.getPeloIndice(0);
		assertTrue(c.getNumJogadoresCasa() == 3);
	}
	
	@Test
	public void testMoverJogador() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(4, marcio);
		tab.adiconarJogadoresACasa(4, jose);
		tab.adiconarJogadoresACasa(4, joao);
		Casa origem = tab.getPeloIndice(4);
		Casa destino = tab.getPeloIndice(10);
		tab.moverJogador(marcio, origem, destino);
		assertTrue(origem.getNumJogadoresCasa() == 2 && destino.getNumJogadoresCasa() == 1);
	}
	@Test
	public void testIndiceCasa() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(0, marcio);
		Casa c = tab.getPeloIndice(4);
		assertTrue(tab.calculaIndiceProximaCasa(c, 5) == 9);
	}

	@Test
	public void testMoverJogadorReal() {
		tab.criarCasasNoTabuleiro();
		tab.adiconarJogadoresACasa(3, joao);
		Casa origem = tab.getPeloIndice(3);
		Casa destino = tab.getPeloIndice(10);
		tab.moverJogador(joao, origem, destino);
		assertTrue(origem.getNumJogadoresCasa() == 0 && destino.getNumJogadoresCasa() == 1);
	}
}









