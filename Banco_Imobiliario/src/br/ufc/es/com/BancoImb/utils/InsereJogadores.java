package br.ufc.es.com.BancoImb.utils;

import br.ufc.es.com.BancoImb.model.ContaBancaria;
import br.ufc.es.com.BancoImb.model.Jogador;
import br.ufc.es.com.BancoImb.model.PecaJogador;
import br.ufc.es.com.BancoImb.repositorio.RepositorioLists;
import br.ufc.es.com.BancoImb.view.DesenhaComponentesGraficos;

public class InsereJogadores {
	private DesenhaComponentesGraficos desenha;
	private VerificacoesDeLogicaDoJogo verifica;
	private RepositorioLists repositorioLits;
	
	public InsereJogadores(RepositorioLists repositorio) {
		desenha = new DesenhaComponentesGraficos();
		verifica = new VerificacoesDeLogicaDoJogo();
		repositorioLits = repositorio;
	}
	
	public void inserirJogador() {
		for (int i = 0; i < new Constantes().QUANTIDADE_jOGADORES;) {
			String nomeJogador = desenha.inputDigiteONomeDoJogador(i);
			if(verifica.verificaNomeIsValido(nomeJogador)){
				String peca = new Constantes().PECA + repositorioLits.getJogadores().size() + new Constantes().FORMATO_IMAGEM;
				repositorioLits.adicionaJogador(new Jogador(nomeJogador,
						new ContaBancaria(new Constantes().SALDO_CONTA_BANCARIA), 
						new PecaJogador(new Constantes().PATH_IMAGE + peca), repositorioLits.getTabuleiro().get(0)));
		i++;
			}else
			desenha.messageNomeInvalido();
		}
		repositorioLits.adicionaListaDeJogadoresNaCasaDePartida();
	}
}
