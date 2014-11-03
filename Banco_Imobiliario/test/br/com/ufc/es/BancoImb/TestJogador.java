package br.com.ufc.es.BancoImb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import br.ufc.es.com.BancoImb.LogradouroComum.LogradouroComumEmpresa;
import br.ufc.es.com.BancoImb.LogradouroComum.LogradouroComumImovel;
import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;

public class TestJogador {
	LogradouroComumEmpresa empresa = new LogradouroComumEmpresa("Google", 1000, 400, new Point(32, 26));
	LogradouroComumEmpresa empresa2 = new LogradouroComumEmpresa("Facebook", 4000, 400, new Point(32, 26));
	LogradouroComumEmpresa empresa3 = new LogradouroComumEmpresa("Twitter", 2000, 400, new Point(32, 26));
	LogradouroComumEmpresa empresa4 = new LogradouroComumEmpresa("Sony", 2500, 400, new Point(32, 26));
	
	LogradouroComumImovel imovel = new LogradouroComumImovel("Casa", 500, 200, new Point(32, 26));
	LogradouroComumImovel imovel2 = new LogradouroComumImovel("Apartamento", 1500, 200, new Point(32, 26));
	LogradouroComumImovel imovel3 = new LogradouroComumImovel("Sobrado", 700, 200,new Point(32, 26));
	LogradouroComumImovel imovel4 = new LogradouroComumImovel("Galpao", 500, 200, new Point(32, 26));
	
	Jogador jogador = new Jogador("Marcio", new ContaBancaria(10000), new PecaJogador(""));
	Jogador jogador2 = new Jogador("Souza", new ContaBancaria(10000), new PecaJogador(""));
	
	float saldo = jogador.getSaldo(); 

	@Test
	public void testComprarEmpresa() {
		jogador.comprar(empresa);
		assertTrue(jogador.getSaldo() == (saldo -= empresa.getValor()));
	}
	@Test
	public void testComprarEmpresa2() {
		jogador.comprar(empresa);
		assertTrue(jogador.getSaldo() == 9000);
	}
	@Test
	public void testComprarImovel() {
		jogador.comprar(imovel);
		assertTrue(jogador.getSaldo() == (saldo -= imovel.getValor()));
	}
	@Test
	public void testComprarImovel2() {
		jogador.comprar(imovel);
		assertTrue(jogador.getSaldo() == 9500);
	}
	@Test
	public void testPagarTaxaEmpresa() {
		jogador.pagarTaxa(empresa);
		assertTrue(jogador.getSaldo() == (saldo -= empresa.getTaxa()));
	}
	@Test
	public void testPagarTaxaEmpresa2() {
		jogador.pagarTaxa(empresa);
		assertTrue(jogador.getSaldo() == 9600);
	}
	@Test
	public void testPagarTaxaImovel() {
		jogador.pagarTaxa(imovel);
		assertTrue(jogador.getSaldo() == (saldo -= imovel.getTaxa()));
	}
	@Test
	public void testPagarTaxaImovel2() {
		jogador.pagarTaxa(imovel);
		assertTrue(jogador.getSaldo() == 9800);
	}
	@Test
	public void testReceberTaxaEmpresa() {
		jogador.receberTaxa(empresa);
		assertTrue(jogador.getSaldo() == (saldo += empresa.getTaxa()));
	}
	@Test
	public void testReceberTaxaEmpresa2() {
		jogador.receberTaxa(empresa);
		assertTrue(jogador.getSaldo() == 10400);
	}
	@Test
	public void testReceberTaxaImovel() {
		jogador.receberTaxa(imovel);
		assertTrue(jogador.getSaldo() == (saldo += imovel.getTaxa()));
	}
	@Test
	public void testReceberTaxaImovel2() {
		jogador.receberTaxa(imovel);
		assertTrue(jogador.getSaldo() == 10200);
	}
	@Test
	public void testComprarLogradouroEVerificarNomeProprietario_Empresa() {
		jogador.comprar(empresa);
		assertEquals(jogador, empresa.getProprietario());
	}
	@Test
	public void testComprarLogradouroEVerificarNomeProprietario_Imovel() {
		jogador.comprar(imovel);
		assertEquals(jogador, imovel.getProprietario());
	}
	@Test
	public void testComprarLogradouroEVerificarLista_Empresa() {
		jogador.comprar(empresa);
		jogador.comprar(empresa2);
		jogador.comprar(empresa3);
		jogador.comprar(empresa4);
		jogador.comprar(imovel);
		jogador.comprar(imovel2);
		jogador.comprar(imovel3);
		jogador.comprar(imovel4);
		assertTrue(jogador.quantidadeLogradouros() == 8);
	}
	@Test
	public void testComprarLogradouroEVerificarLista_Imovel() {
		jogador.comprar(imovel);
		jogador.comprar(imovel2);
		jogador.comprar(imovel3);
		jogador.comprar(imovel4);
		jogador.comprar(empresa);
		jogador.comprar(empresa2);
		jogador.comprar(empresa3);
		jogador.comprar(empresa4);
		assertTrue(jogador.quantidadeLogradouros() == 8);
	}
	
	@Test
	public void testVerificarAcaoLogradouroJaVendido(){
		jogador2.comprar(empresa);
		if(empresa.isVendido()){
			jogador.pagarTaxa(empresa);	
		}
		assertTrue(jogador.getSaldo() == (saldo -= empresa.getTaxa()));
	}
	@Test
	public void testVerificarAcaoLogradouroNaoVendido(){
		if(!empresa.isVendido()){
			jogador.comprar(empresa);	
		}
		assertTrue(jogador.getSaldo() == (saldo -= empresa.getValor()));
	}
}

























