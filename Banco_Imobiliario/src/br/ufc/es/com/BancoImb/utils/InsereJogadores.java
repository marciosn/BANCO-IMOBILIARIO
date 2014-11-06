package br.ufc.es.com.BancoImb.utils;

import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.repositorios.RepositorioLists;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class InsereJogadores {
	private Constantes constante;
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private RepositorioLists repositorioLits;
	
	public InsereJogadores(RepositorioLists repositorio) {
		constante = new Constantes();
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		repositorioLits = repositorio;
	}
	
	public void inserirJogador() {
		for (int i = 0; i < constante.QUANTIDADE_jOGADORES;) {
			String nomeJogador = desenha.inputDigiteONomeDoJogador(i);
			if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = constante.PECA + repositorioLits.getJogadores().size() + constante.FORMATO_IMAGEM;
				repositorioLits.adicionaJogador(new Jogador(nomeJogador,
						new ContaBancaria(constante.SALDO_CONTA_BANCARIA), 
						new PecaJogador(constante.PATH_IMAGE + peca)));
		i++;
			}else
			desenha.messageNomeInvalido();
		}
		repositorioLits.adicionaListaDeJogadoresNaCasaDePartida();
	}
}
